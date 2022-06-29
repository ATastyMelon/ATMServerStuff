package net.atm.items

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.ShapedRecipe

object ZevIce {
    var ice: ItemStack? = null
    fun createZevIce() {
        val item = ItemStack(Material.PRISMARINE_SHARD)
        val meta = item.itemMeta

        meta!!.setDisplayName(ChatColor.AQUA.toString() + "Zev's Ice Cube")
        val lore: MutableList<String> = ArrayList()
        lore.add(ChatColor.AQUA.toString() + "Freezes " + ChatColor.GOLD.toString() + "your enemies")
        lore.add(ChatColor.GOLD.toString() + "in their step")
        meta.lore = lore
        meta.addEnchant(Enchantment.LUCK, 1, false)
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS)
        item.itemMeta = meta

        ice = item

        val sr = ShapedRecipe(NamespacedKey.minecraft("zevsice"), item)
        sr.shape("###",
                "###",
                "###")
        sr.setIngredient('#', Material.BLUE_ICE)
        Bukkit.getServer().addRecipe(sr)
    }
}