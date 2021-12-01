package me.coopersully.Core;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class HalaraCorePlugin extends JavaPlugin implements Listener {

    public static String prefix;
    public static String serverSelectorTitle;
    public static String serverSelectorItemOneName;
    public static List<String> serverSelectorItemOneDescription;
    public static String serverSelectorItemTwoName;
    public static List<String> serverSelectorItemTwoDescription;
    public static String serverSelectorItemThreeName;
    public static List<String> serverSelectorItemThreeDescription;

    public void onEnable() {

        // Generate config
        saveDefaultConfig();
        reloadDefaultConfig();

        // Enable all listeners
        getServer().getPluginManager().registerEvents(this, this);

        // Create server_selector GUI and corresponding data
        CoreInventories.server_selector = Bukkit.createInventory(null, 9, ChatColor.translateAlternateColorCodes('&', serverSelectorTitle));
        CoreInventories.registerServerSelector();

        // Register Bungeecord as a plugin channel
        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

    }

    public void onDisable() {

    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        switch (label) {
            case "help", "ehelp", "hhelp", "faq", "?" -> {
                CoreCommands.sendHelpMenu(sender);
                return true;
            }
            case "server-selector", "servers", "play", "games", "go" -> {
                CoreCommands.openServerGUI(sender);
                return true;
            }
            case "fakejoin", "fjoin" -> {
                CoreCommands.fakeJoin(sender, args);
                return true;
            }
            case "fakeleave", "fleave" -> {
                CoreCommands.fakeLeave(sender, args);
                return true;
            }
        }

        return false;

    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {

        if (event.getCurrentItem() == null) return;
        if (!((event.getCurrentItem().isSimilar(CoreInventories.survival_item)) || (event.getCurrentItem().isSimilar(CoreInventories.creative_item)) || (event.getCurrentItem().isSimilar(CoreInventories.prototype_item)))) {
            return;
        }

        event.setCancelled(true); // Disallow taking items from GUI

        Player player = (Player) event.getWhoClicked();

        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Connect");

        if (event.getSlot() == 11) {
            // Selected survival server
            out.writeUTF("survival");
            player.sendPluginMessage(this, "BungeeCord", out.toByteArray());
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "Transferring you to the &aSurvival&7 server..."));
        }

        if (event.getSlot() == 13) {
            // Selected creative server
            out.writeUTF("creative");
            player.sendPluginMessage(this, "BungeeCord", out.toByteArray());
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "Transferring you to the &aCreative&7 server..."));
        }

        if (event.getSlot() == 15) {
            // Selected prototype server
            out.writeUTF("prototype");
            player.sendPluginMessage(this, "BungeeCord", out.toByteArray());
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "Transferring you to the &aPrototype&7 lobby..."));
        }

    }

    @EventHandler
    public void onClose(InventoryCloseEvent event) {

        Player player = (Player) event.getPlayer();

        if (!(event.getInventory() == CoreInventories.server_selector)) {
            return;
        }

        PlayerInventory inv = player.getInventory();
        inv.clear();

        PlayerInventoryContents oldInventory = CoreCommands.inventories.remove(player.getUniqueId());

        inv.setArmorContents(oldInventory.armorContents());
        inv.setExtraContents(oldInventory.extraContents());
        inv.setStorageContents(oldInventory.storageContents());

        player.setInvulnerable(false);

    }

    public static void colorList(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, ChatColor.translateAlternateColorCodes('&', list.get(i)));
        }
    }

    public static Plugin getInstance() {
        return Bukkit.getPluginManager().getPlugin("Halara-Core");
    }

    public static void reloadDefaultConfig() {
        getInstance().reloadConfig();
        getInstance().saveDefaultConfig();

        prefix = getInstance().getConfig().getString("prefix");

        serverSelectorTitle = getInstance().getConfig().getString("server-selector.title");

        serverSelectorItemOneName = getInstance().getConfig().getString("server-selector.items.1.name");
        serverSelectorItemOneDescription = getInstance().getConfig().getStringList("server-selector.items.1.description");
        colorList(serverSelectorItemOneDescription);

        serverSelectorItemTwoName = getInstance().getConfig().getString("server-selector.items.2.name");
        serverSelectorItemTwoDescription = getInstance().getConfig().getStringList("server-selector.items.2.description");
        colorList(serverSelectorItemTwoDescription);

        serverSelectorItemThreeName = getInstance().getConfig().getString("server-selector.items.3.name");
        serverSelectorItemThreeDescription = getInstance().getConfig().getStringList("server-selector.items.3.description");
        colorList(serverSelectorItemThreeDescription);

    }

}
