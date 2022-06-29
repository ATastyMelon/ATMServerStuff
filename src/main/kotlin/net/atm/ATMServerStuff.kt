package net.atm

import net.atm.commands.*
import net.atm.events.NerdBook
import net.atm.events.STonksEvents
import net.atm.events.ZevIceEvents
import net.atm.handlers.DevMenuHandler
import net.atm.handlers.JoinLeaveHandler
import net.atm.handlers.PickleHandler
import net.atm.handlers.PlayerHandler
import net.atm.items.ItemManager
import net.atm.items.STonks
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class ATMServerStuff : JavaPlugin() {
    override fun onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("ATMServerStuff Started")
        saveDefaultConfig()
        getCommand("fly")!!.setExecutor(Fly())
        getCommand("robinhood")!!.setExecutor(RobinHood())
        getCommand("restartwarning")!!.setExecutor(RestartWarning())
        getCommand("knocker")!!.setExecutor(GiveKnocker())
        getCommand("totems")!!.setExecutor(Totems())

        // ItemManager initialization
        ItemManager.init()

        // Player Join/Leave messages
        JoinLeaveHandler(this)
        // Pickle to diamond
        PickleHandler(this)
        // Gives player steak when they join for the first time
        PlayerHandler(this)

        // DEBUG MENU FOR ADMINS
        getCommand("devmenu")!!.setExecutor(DevMenu())
        DevMenuHandler(this)

        // Events
        NerdBook(this)
        ZevIceEvents(this)
        STonksEvents(this)
    }

    override fun onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("Shutting down")
    }
}