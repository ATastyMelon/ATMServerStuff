package net.atm.handlers

import net.atm.ATMServerStuff
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

class JoinLeaveHandler(plugin: ATMServerStuff?) : Listener {
    init {
        Bukkit.getPluginManager().registerEvents(this, plugin!!)
    }

    @EventHandler
    fun onJoin(e: PlayerJoinEvent) {
        val player = e.player
        if (!player.hasPlayedBefore()) {
            e.joinMessage = ChatColor.AQUA.toString() + "Hello " + ChatColor.GOLD + player.displayName + ChatColor.AQUA + ", Welcome to the AT-MC Server!"
            player.sendMessage(ChatColor.AQUA.toString() + " This server is enhanced by Towny, please lookup how to ")
        } else {
            e.joinMessage = ChatColor.AQUA.toString() + "Hello " + ChatColor.GOLD + player.displayName + ChatColor.AQUA + ", Have Fun!"
        }
    }

    @EventHandler
    fun onLeave(e: PlayerQuitEvent) {
        val player = e.player
        e.quitMessage = ChatColor.GOLD.toString() + player.displayName + ChatColor.RED + " has left, hope they come back..."
    }
}