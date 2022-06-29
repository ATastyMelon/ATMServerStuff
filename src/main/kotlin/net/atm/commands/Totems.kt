package net.atm.commands

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class Totems : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        if (sender !is Player) {
            sender.sendMessage("Only usable by players")
            return true
        }
        sender.performCommand("summon minecraft:axolotl ~ ~1 ~ {ArmorItems:[{id:\"minecraft:totem_of_undying\",Count:64b}],ArmorDropChances:[2.0F,0.085F,0.085f,0.085F],NoAI:1}")
        return true
    }
}