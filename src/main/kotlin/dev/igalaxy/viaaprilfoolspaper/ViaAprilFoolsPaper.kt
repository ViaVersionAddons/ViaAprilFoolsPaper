package dev.igalaxy.viaaprilfoolspaper

import com.viaversion.viaversion.ViaVersionPlugin
import com.viaversion.viaversion.api.Via
import net.axay.kspigot.main.KSpigot

class ViaAprilFoolsPaper : KSpigot() {
    companion object {
        lateinit var INSTANCE: ViaAprilFoolsPaper
        lateinit var PLATFORM: ViaAprilFoolsPlatformImpl
    }

    override fun load() {
        INSTANCE = this
        if (!ViaVersionPlugin.getInstance().isLateBind) {
            init()
        }
    }

    override fun startup() {
        if (ViaVersionPlugin.getInstance().isLateBind) {
            init()
        }
    }

    override fun shutdown() { }

    private fun init() {
        PLATFORM = ViaAprilFoolsPlatformImpl()
    }
}