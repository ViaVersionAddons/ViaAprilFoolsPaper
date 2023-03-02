package dev.igalaxy.viaaprilfoolspaper

import com.viaversion.viaversion.api.Via
import net.raphimc.viaaprilfools.platform.ViaAprilFoolsPlatform
import java.io.File
import java.util.logging.Logger

class ViaAprilFoolsPlatformImpl : ViaAprilFoolsPlatform {
    init {
        this.init(this.dataFolder)
    }

    override fun getLogger(): Logger {
        return Via.getPlatform().logger
    }

    override fun getDataFolder(): File {
        return Via.getPlatform().dataFolder
    }
}