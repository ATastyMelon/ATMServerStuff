package net.atm.items

object ItemManager {
    fun init() {
        FUStick.createFUStick()
        KnockStick.createKnockStick()
        Nerds.createNerdBook()
        ZevIce.createZevIce()
        STonks.createSTonk()
    }
}