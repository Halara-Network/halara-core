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

        survival_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', HalaraCorePlugin.serverSelectorItemOneName));
        survival_meta.setCustomModelData(1);

        survival_meta.setLore(HalaraCorePlugin.serverSelectorItemOneDescription);

        survival_item.setItemMeta(survival_meta);

        // Create ItemStack data for the Creative server icon

        creative_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', HalaraCorePlugin.serverSelectorItemTwoName));
        creative_meta.setCustomModelData(2);

        creative_meta.setLore(HalaraCorePlugin.serverSelectorItemTwoDescription);

        creative_item.setItemMeta(creative_meta);

        // Create ItemStack data for the Prototype server icon

        prototype_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', HalaraCorePlugin.serverSelectorItemThreeName));
        prototype_meta.setCustomModelData(3);

        prototype_meta.setLore(HalaraCorePlugin.serverSelectorItemThreeDescription);

        prototype_item.setItemMeta(prototype_meta);

    }

}
