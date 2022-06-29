package net.atm.commands

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class Fly : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        if (sender !is Player) {
            sender.sendMessage("Only player can run this command.")
            return true
        }
        val player = sender
        if (player.allowFlight) {
            player.allowFlight = false
            player.sendMessage("Flying disabled")
        } else {
            player.allowFlight = true
            player.sendMessage("Flying enabled")
        }
        return true
    }
}