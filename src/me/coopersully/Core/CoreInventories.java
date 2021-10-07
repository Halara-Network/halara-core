package me.coopersully.Core;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class CoreInventories {

    public static Inventory server_selector;

    public static ItemStack survival_item;
    public static ItemMeta survival_meta;
    public static ItemStack creative_item;
    public static ItemMeta creative_meta;
    public static ItemStack prototype_item;
    public static ItemMeta prototype_meta;


    // Create data for public ItemStacks under server_selector
    public static void registerServerSelector() {

        // Initialize variables
        survival_item = new ItemStack(Material.OAK_LOG);
        survival_meta = survival_item.getItemMeta();
        creative_item = new ItemStack(Material.DIAMOND_BLOCK);
        creative_meta = creative_item.getItemMeta();
        prototype_item = new ItemStack(Material.AMETHYST_BLOCK);
        prototype_meta = prototype_item.getItemMeta();

        // Create ItemStack data for the Survival server icon

        survival_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&e&lEnhanced Survival &a[1.17+]"));
        survival_meta.setCustomModelData(1);

        List<String> survival_lore = new ArrayList<>();
        survival_lore.add(ChatColor.GRAY + "" + ChatColor.ITALIC + "An enhanced version of the survival");
        survival_lore.add(ChatColor.GRAY + "" + ChatColor.ITALIC + "experience; collect, combat, and build.");
        survival_lore.add("");
        survival_lore.add(ChatColor.DARK_GRAY + "» Click to select this server");
        survival_meta.setLore(survival_lore);

        survival_item.setItemMeta(survival_meta);

        // Create ItemStack data for the Creative server icon

        creative_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&e&lCreative &a[1.17+]"));
        creative_meta.setCustomModelData(2);

        List<String> creative_lore = new ArrayList<>();
        creative_lore.add(ChatColor.GRAY + "" + ChatColor.ITALIC + "A freestyle, sandbox gamemode in which");
        creative_lore.add(ChatColor.GRAY + "" + ChatColor.ITALIC + "players build to their heart's content.");
        creative_lore.add("");
        creative_lore.add(ChatColor.DARK_GRAY + "» Click to select this server");
        creative_meta.setLore(creative_lore);

        creative_item.setItemMeta(creative_meta);

        // Create ItemStack data for the Prototype server icon

        prototype_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&e&lPrototype &a[1.17+]"));
        prototype_meta.setCustomModelData(3);

        List<String> prototype_lore = new ArrayList<>();
        prototype_lore.add(ChatColor.GRAY + "" + ChatColor.ITALIC + "This gamemode is currently undergoing");
        prototype_lore.add(ChatColor.GRAY + "" + ChatColor.ITALIC + "maintenance; please check back later.");
        prototype_lore.add("");
        prototype_lore.add(ChatColor.DARK_GRAY + "» Click to select this server");
        prototype_meta.setLore(prototype_lore);

        prototype_item.setItemMeta(prototype_meta);

    }

}
