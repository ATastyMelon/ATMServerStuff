package net.atm.commands

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack

class DevMenu : CommandExecutor {
    var inv: Inventory? = null

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {

        if (sender !is Player) {
            sender.sendMessage("Only usable by players")
            return true
        }

        inv = Bukkit.createInventory(sender, 9, ChatColor.RED.toString() + "DEV-MENU")

        // Server Reload Item
        val serverReload = ItemStack(Material.TNT, 1)
        val reloadMeta = serverReload.itemMeta
        reloadMeta!!.setDisplayName(ChatColor.DARK_RED.toString() + "||RELOAD SERVER||")
        serverReload.itemMeta = reloadMeta

        // Server Reload Warning Item
        val warning = ItemStack(Material.CANDLE, 1)
        val warningMeta = warning.itemMeta
        warningMeta!!.setDisplayName(ChatColor.AQUA.toString() + "||Warn users of reload||")
        warning.itemMeta = warningMeta

        // Save Server Item
        val saveItem = ItemStack(Material.DIAMOND_HORSE_ARMOR, 1)
        val saveMeta = saveItem.itemMeta
        saveMeta!!.setDisplayName(ChatColor.AQUA.toString() + "||Save Server||")
        saveItem.itemMeta = saveMeta

        // Fly item
        val flyItem = ItemStack(Material.FEATHER, 1)
        val flyMeta = flyItem.itemMeta
        flyMeta!!.setDisplayName(ChatColor.AQUA.toString() + "||Toggle Flight||")
        flyItem.itemMeta = flyMeta

        // F U Stick Item
        val stickItem = ItemStack(Material.STICK, 1)
        val stickMeta = stickItem.itemMeta
        stickMeta!!.setDisplayName("||F U Stick||")
        val stickLore: MutableList<String> = ArrayList()
        stickLore.add("Gives you the F U Stick")
        stickMeta.lore = stickLore
        stickItem.itemMeta = stickMeta

        // Billy...
        val billyItem = ItemStack(Material.WARDEN_SPAWN_EGG, 1)
        val billyMeta = billyItem.itemMeta
        billyMeta!!.setDisplayName("||Give Billy||")
        val billyLore: MutableList<String> = ArrayList()
        billyLore.add("Gives you access to the")
        billyLore.add("All powerful Billy")
        billyMeta.lore = billyLore
        billyItem.itemMeta = billyMeta

        // Knockback Stick
        val knockGUIItem = ItemStack(Material.CYAN_WOOL, 1)
        val knockGUIMeta = knockGUIItem.itemMeta
        knockGUIMeta!!.setDisplayName("||Knockback Stick||")
        knockGUIItem.itemMeta = knockGUIMeta

        // Set the buttons
        inv!!.setItem(2, serverReload)
        inv!!.setItem(1, warning)
        inv!!.setItem(0, saveItem)
        inv!!.setItem(5, knockGUIItem)
        inv!!.setItem(6, billyItem)
        inv!!.setItem(7, stickItem)
        inv!!.setItem(8, flyItem)
        sender.openInventory(inv!!)
        return true
    }
}