package net.atm.events

import net.atm.ATMServerStuff
import net.atm.items.Nerds
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Sound
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent

class NerdBook(plugin: ATMServerStuff?) : Listener {
    init {
        Bukkit.getPluginManager().registerEvents(this, plugin!!)
    }

    @EventHandler
    fun onRightClick(e: PlayerInteractEvent) {
        if (e.action == Action.RIGHT_CLICK_AIR || e.action == Action.RIGHT_CLICK_BLOCK) {
            if (e.item != null) {
                if (e.item!!.itemMeta?.lore == Nerds.nerd!!.itemMeta?.lore) {
                    val p = e.player
                    p.sendMessage(ChatColor.DARK_PURPLE.toString() + "You are now a " + ChatColor.DARK_RED.toString() + "NERD!!!")
                    p.playSound(p.location, Sound.AMBIENT_CAVE, 1.0f, 1.0f)
                    p.playSound(p.location, Sound.ENTITY_GENERIC_EXPLODE, 1.0f, 1.0f)
                }
            }
        }
    }
}