package net.atm.handlers

import net.atm.ATMServerStuff
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockPlaceEvent

class PickleHandler(plugin: net.atm.ATMServerStuff?) : Listener {
    init {
        Bukkit.getPluginManager().registerEvents(this, plugin!!)
    }

    // Diamond placing logic
    @EventHandler
    fun onPicklePlace_Normal(event: BlockPlaceEvent) {
        val block = event.block
        if (block.type != Material.SEA_PICKLE) {
            return
        }
        if (!event.player.hasPermission("atmutils.sea_pickle.diamond")) {
            return
        }
        block.type = Material.DIAMOND_BLOCK
        Bukkit.getLogger().info("A Pickle was placed!")
    }
}