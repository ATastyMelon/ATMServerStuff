package net.atm.commands

import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack

class RobinHood : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        if (sender !is Player) {
            sender.sendMessage("Only players can use that command")
            return true
        }
        val inv: Inventory = sender.inventory
        val items = ItemStack(Material.DIAMOND_BLOCK, 64)
        inv.addItem(items)
        return true
    }
}