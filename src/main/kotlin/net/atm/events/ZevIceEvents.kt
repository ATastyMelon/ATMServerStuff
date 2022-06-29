package net.atm.events

import net.atm.ATMServerStuff
import net.atm.items.ZevIce
import org.bukkit.Bukkit
import org.bukkit.entity.Entity
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

class ZevIceEvents(plugin: ATMServerStuff?) : Listener{
    init {
        Bukkit.getPluginManager().registerEvents(this, plugin!!)
    }

    @EventHandler
    fun onHit(e: EntityDamageByEntityEvent) {
        var entity: Entity = e.entity
        var attacker: Entity = e.damager

        if (entity is LivingEntity) {
            if (attacker is Player) {
                if (attacker.inventory.itemInMainHand.itemMeta?.lore == ZevIce.ice?.itemMeta?.lore) {
                    entity.addPotionEffect(PotionEffect(PotionEffectType.SLOW, 10 * 20, 1000))
                }
            }
        }
    }
}