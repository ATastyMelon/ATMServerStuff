package net.atm.items

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.ShapedRecipe

object FUStick {
    var wand: ItemStack? = null
    fun createFUStick() {
        val item = ItemStack(Material.STICK, 1)
        val meta = item.itemMeta
        meta!!.setDisplayName("F U Stick")
        val lore: MutableList<String> = ArrayList()
        lore.add("This stick is to absolutely")
        lore.add("destroy all enemies that come your way")
        meta.lore = lore
        meta.addEnchant(Enchantment.DAMAGE_ALL, 255, true)
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS)
        item.itemMeta = meta

        wand = item

        val sr = ShapedRecipe(NamespacedKey.minecraft("fustick"), item)
        sr.shape(" D ",
                " D ",
                " D ")
        sr.setIngredient('D', Material.DRAGON_EGG)
        Bukkit.getServer().addRecipe(sr)
    }
}