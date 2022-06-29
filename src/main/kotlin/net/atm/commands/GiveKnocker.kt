package net.atm.commands

import net.atm.items.KnockStick
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory

class GiveKnocker : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        if (sender !is Player) {
            sender.sendMessage("Only usable for players")
            return true
        }
        val inv: Inventory = sender.inventory
        inv.addItem(KnockStick.knockStick)
        return true
    }
}