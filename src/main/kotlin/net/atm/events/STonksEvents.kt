package net.atm.events

import net.atm.ATMServerStuff
import net.atm.items.STonks
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent

class STonksEvents(plugin: ATMServerStuff?) : Listener {

    init {
        Bukkit.getPluginManager().registerEvents(this, plugin!!)
    }

    @EventHandler
    fun onRightClick(e: PlayerInteractEvent) {
        if (e.action == Action.RIGHT_CLICK_AIR || e.action == Action.RIGHT_CLICK_BLOCK) {
            if (e.item != null) {
                if (e.item!!.itemMeta!!.lore == STonks.STonk!!.itemMeta!!.lore) {
                    val p = e.player
                    p.sendMessage(ChatColor.GOLD.toString() + "Bring to Melon for a " + ChatColor.GOLD.toString() + "reward!")
                    p.sendMessage(ChatColor.GOLD.toString() + "Or brag to your friends if he isn't online")
                }
            }
        }
    }
}