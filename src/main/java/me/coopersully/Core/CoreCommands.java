package me.coopersully.Core;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CoreCommands {

    public static Map<UUID, PlayerInventoryContents> inventories = new HashMap<>();

    public static void sendHelpMenu(CommandSender sender) {
        if (!(sender instanceof Player player)) {

            sender.sendMessage(ChatColor.RED + "This command cannot be run through the console.");
            return;

        }

        // Header message

        player.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "Halara Network");
        player.sendMessage(ChatColor.GRAY + "Click an option below to view more information.");
        //player.sendMessage("");


        // Hoverable, Clickable "Change Servers" message

        TextComponent server = new TextComponent(ChatColor.translateAlternateColorCodes('&', "&r     &e* &bChange Servers"));
        server.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/play"));
        server.setHoverEvent(new HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_TEXT, new Text("Click to open the server-select menu.")));
        player.spigot().sendMessage(server);

        // Hoverable, Clickable "User Agreement" message

        TextComponent user_agreement = new TextComponent(ChatColor.translateAlternateColorCodes('&', "&r     &e* &bUser Agreement"));
        user_agreement.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://cursedimpulse.wixsite.com/minecraft/forum/bulletin-board/user-agreement"));
        user_agreement.setHoverEvent(new HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_TEXT, new Text("Click to view the user agreement.")));
        player.spigot().sendMessage(user_agreement);


        // Hoverable, Clickable "Allowed Modifications" message

        TextComponent allowed_mods = new TextComponent(ChatColor.translateAlternateColorCodes('&', "&r     &e* &bAllowed Modifications"));
        allowed_mods.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://cursedimpulse.wixsite.com/minecraft/forum/bulletin-board/allowed-modifications"));
        allowed_mods.setHoverEvent(new HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_TEXT, new Text("Click to view the allowed modifications.")));
        player.spigot().sendMessage(allowed_mods);

        // Hoverable, Clickable "Useful Commands" message

        TextComponent cmds = new TextComponent(ChatColor.translateAlternateColorCodes('&', "&r     &e* &bUseful Commands"));
        cmds.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://cursedimpulse.wixsite.com/minecraft/forum/bulletin-board/useful-commands"));
        cmds.setHoverEvent(new HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_TEXT, new Text("Click to view a list of useful commands.")));
        player.spigot().sendMessage(cmds);

        // Hoverable, Clickable "Server Store" message

        TextComponent store = new TextComponent(ChatColor.translateAlternateColorCodes('&', "&r     &e* &bServer Store"));
        store.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://halara.tebex.io/"));
        store.setHoverEvent(new HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_TEXT, new Text("Click to view the server store.")));
        player.spigot().sendMessage(store);

        // Hoverable, Clickable "Report an Issue" message

        TextComponent issues = new TextComponent(ChatColor.translateAlternateColorCodes('&', "&r     &e* &bReport an Issue"));
        issues.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://docs.google.com/forms/d/e/1FAIpQLSdmp0ysmzxFDT_RnQUt-ZY3A3u26V6AHAVwDehvoUSvPPq9CA/viewform"));
        issues.setHoverEvent(new HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_TEXT, new Text("Click to report an issue.")));
        player.spigot().sendMessage(issues);

        // Hoverable, Clickable "Suggest a Feature" message

        TextComponent sugg = new TextComponent(ChatColor.translateAlternateColorCodes('&', "&r     &e* &bSuggest a Feature"));
        sugg.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://docs.google.com/forms/d/e/1FAIpQLSfeM_Rf9GeJPFsTlOo5ENDO-6RJxovUh_S9npVtAR7Es66cXg/viewform"));
        sugg.setHoverEvent(new HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_TEXT, new Text("Click to suggest a feature.")));
        player.spigot().sendMessage(sugg);

        // Hoverable, Clickable "Join our Discord" message

        TextComponent disc = new TextComponent(ChatColor.translateAlternateColorCodes('&', "&r     &e* &bJoin our Discord"));
        disc.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://discord.com/invite/Q7yjtqGXd2"));
        disc.setHoverEvent(new HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_TEXT, new Text("Click to join our Discord server.")));
        player.spigot().sendMessage(disc);
    }

    public static void fakeJoin(CommandSender sender, String[] args) {

        if (!(sender instanceof Player player)) {

            sender.sendMessage(ChatColor.RED + "This command cannot be run through the console.");
            return;

        }

        if (!(player.hasPermission("group.moderator"))) {

            player.sendMessage(ChatColor.RED + "You do not have permission to perform this command.");
            return;

        }

        if (args.length < 1) {

            player.sendMessage(ChatColor.RED + "Usage: /fjoin <player>");
            return;

        }

        Bukkit.broadcastMessage(ChatColor.YELLOW + "" + ChatColor.ITALIC + args[0] + " joined the game");

    }

    public static void fakeLeave(CommandSender sender, String[] args) {

        if (!(sender instanceof Player player)) {

            sender.sendMessage(ChatColor.RED + "This command cannot be run through the console.");
            return;

        }

        if (!(player.hasPermission("group.moderator"))) {

            player.sendMessage(ChatColor.RED + "You do not have permission to perform this command.");
            return;

        }

        if (args.length < 1) {

            player.sendMessage(ChatColor.RED + "Usage: /fleave <player>");
            return;

        }

        Bukkit.broadcastMessage(ChatColor.YELLOW + "" + ChatColor.ITALIC + args[0] + " left the game");

    }

    public static void openServerGUI(CommandSender sender) {
        if (!(sender instanceof Player player)) {

            sender.sendMessage(ChatColor.RED + "This command cannot be run through the console.");
            return;

        }

        PlayerInventory inv = player.getInventory();

        PlayerInventoryContents inventoryContents = new PlayerInventoryContents(inv.getArmorContents(), inv.getExtraContents(), inv.getStorageContents());
        inventories.put(player.getUniqueId(), inventoryContents);

        // Clear inventory
        inv.clear();

        // Give server icon items
        inv.setItem(11, CoreInventories.survival_item);
        inv.setItem(13, CoreInventories.creative_item);
        inv.setItem(15, CoreInventories.prototype_item);

        // Open the "Server Selector" GUI
        player.openInventory(CoreInventories.server_selector);
        player.setInvulnerable(true);

    }

}

