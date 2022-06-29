package net.atm.items

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.ShapedRecipe
import org.bukkit.inventory.meta.ItemMeta

object Nerds {
    var nerd: ItemStack? = null
    fun createNerdBook() {
        val item = ItemStack(Material.BOOK, 1)
        val meta = item.itemMeta

        meta!!.setDisplayName("Calculus Textbook")
        val lore: MutableList<String> = ArrayList()
        lore.add(ChatColor.GOLD.toString() +  "A Calulus Textbook")
        lore.add("for nerds")
        meta.lore = lore
        meta.addEnchant(Enchantment.LUCK, 1, false)
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS)
        item.itemMeta = meta

        nerd = item

        val sr = ShapedRecipe(NamespacedKey.minecraft("nerdbook"), item)
        sr.shape("##",
                "#H")
        sr.setIngredient('#', Material.PAPER)
        sr.setIngredient('H', Material.HEART_OF_THE_SEA)
        Bukkit.getServer().addRecipe(sr)
    }
}