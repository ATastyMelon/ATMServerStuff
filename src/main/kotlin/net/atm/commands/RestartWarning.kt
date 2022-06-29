package net.atm.commands

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Sound
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class RestartWarning : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        val title = "||UPDATE WARNING||"
        val subtitle = "||Server restart SOON, please prepare||"
        for (player in Bukkit.getOnlinePlayers()) {
            player.sendTitle(ChatColor.DARK_RED.toString() + title, ChatColor.AQUA.toString() + subtitle, 10, 100, 10)
            player.playSound(player.location, Sound.ENTITY_ENDER_DRAGON_GROWL, 1f, 1f)
        }
        Bukkit.dispatchCommand(sender, "save-all")
        return true
    }
}