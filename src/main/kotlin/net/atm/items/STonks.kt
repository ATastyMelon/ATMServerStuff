package net.atm.items

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.ShapedRecipe

object STonks {

    var STonk: ItemStack? = null

    fun createSTonk() {
        var item = ItemStack(Material.PAPER, 1)
        var meta = item.itemMeta

        meta!!.setDisplayName(ChatColor.LIGHT_PURPLE.toString() + "Paper of " + ChatColor.GOLD.toString() + "STonks")
        var lore: MutableList<String> = ArrayList()
        lore.add("A strange piece of paper")
        lore.add("Bring to Melon")
        lore.add("for something cool")
        meta.lore = lore
        meta.addEnchant(Enchantment.LUCK, 1, false)
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS)
        item.itemMeta = meta

        STonk = item

        var sr = ShapedRecipe(NamespacedKey.minecraft("stonkpaper"), item)
        sr.shape("###",
                "###",
                "###")
        sr.setIngredient('#', Material.GOLD_BLOCK)
        Bukkit.getServer().addRecipe(sr)
    }
}