package net.atm.handlers

import net.atm.ATMServerStuff
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack

class PlayerHandler(plugin: net.atm.ATMServerStuff?) : Listener {
    init {
        Bukkit.getPluginManager().registerEvents(this, plugin!!)
    }

    // Steak giving logic
    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        val player = event.player
        val item = ItemStack(Material.COOKED_BEEF, 64)
        val inv: Inventory = player.inventory
        if (!player.hasPlayedBefore()) {
            inv.setItem(8, item)
            player.sendMessage("Hello maybe smelly, welcome to Factions SMP, here is some steak to help out")
        }
    }
}