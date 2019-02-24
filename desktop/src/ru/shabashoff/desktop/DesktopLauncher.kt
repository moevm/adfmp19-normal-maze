package ru.shabashoff.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import ru.shabashoff.MyGdxGame
import java.lang.Exception
import java.util.*

object DesktopLauncher {
    @JvmStatic
    fun main(arg: Array<String>) {
        val config = LwjglApplicationConfiguration()
        LwjglApplication(MyGdxGame(), config)
    }
}
