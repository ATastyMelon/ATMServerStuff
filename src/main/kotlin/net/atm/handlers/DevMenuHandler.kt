package net.atm.handlers

import net.atm.ATMServerStuff
import net.atm.items.FUStick
import net.atm.items.KnockStick
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryDragEvent
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack

class DevMenuHandler(plugin: ATMServerStuff?) : Listener {
    init {
        Bukkit.getPluginManager().registerEvents(this, plugin!!)
    }

    @EventHandler
    fun onMenuClick(e: InventoryClickEvent) {
        val p = e.whoClicked as Player
        val invPlayer: Inventory = p.inventory
        if (e.view.title == ChatColor.RED.toString() + "DEV-MENU") {
            if (e.currentItem == null || e.currentItem!!.type.isAir) {
                return
            }

            when (e.currentItem!!.type) {
                Material.TNT -> p.performCommand("stop")
                Material.CANDLE -> p.performCommand("restartwarning")
                Material.DIAMOND_HORSE_ARMOR -> p.performCommand("save-all")
                Material.FEATHER -> p.performCommand("fly")
                Material.STICK -> {
                    invPlayer.addItem(FUStick.wand)
                }
                Material.WARDEN_SPAWN_EGG -> {
                    val billyItem = ItemStack(Material.WARDEN_SPAWN_EGG, 1)
                    val billyMeta = billyItem.itemMeta
                    billyMeta!!.setDisplayName(ChatColor.DARK_RED.toString() + ChatColor.BOLD.toString() + "Billy")
                    billyItem.itemMeta = billyMeta
                    invPlayer.addItem(billyItem)
                }
                Material.CYAN_WOOL -> invPlayer.addItem(KnockStick.knockStick)
                else -> {}
            }

            // NO CLICK BROHAM
            e.isCancelled = true
        }
    }
}