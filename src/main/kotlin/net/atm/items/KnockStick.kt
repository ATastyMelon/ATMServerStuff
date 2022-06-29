package net.atm.items

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.ShapedRecipe

object KnockStick {
    var knockStick: ItemStack? = null
    fun createKnockStick() {
        val item = ItemStack(Material.STICK, 1)
        val meta = item.itemMeta
        meta!!.setDisplayName("Knockback Stick")
        meta.addEnchant(Enchantment.KNOCKBACK, 1000, true)
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS)
        item.itemMeta = meta
        knockStick = item
        val sr = ShapedRecipe(NamespacedKey.minecraft("knockbackstick"), item)
        sr.shape(" D ",
                " N ",
                " D ")
        sr.setIngredient('D', Material.STICK)
        sr.setIngredient('N', Material.DIAMOND)
        Bukkit.getServer().addRecipe(sr)
    }
}