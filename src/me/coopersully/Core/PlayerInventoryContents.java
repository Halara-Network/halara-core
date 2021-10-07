package me.coopersully.Core;

import org.bukkit.inventory.ItemStack;

public record PlayerInventoryContents(ItemStack[] armorContents, ItemStack[] extraContents, ItemStack[] storageContents) {

}
