package ru.shabashoff.game.players

import com.badlogic.gdx.graphics.g2d.Sprite
import ru.shabashoff.game.GameMap
import ru.shabashoff.game.GameUtils
import ru.shabashoff.primitives.IntPoint
import ru.shabashoff.ui.UiUtils

abstract class Player(var x: Int, var y: Int) {

    private val sprite: Sprite = UiUtils.getIconSprite("PAUSE")//TODO fix icon

    protected val map: GameMap = GameUtils.curGameSession!!.map

    init {
        reBoundSprite()

        UiUtils.addSprite(sprite)
    }

    fun move(point: IntPoint) {
        x = point.x
        y = point.y

        reBoundSprite()
    }

    abstract fun isBot(): Boolean

    private fun reBoundSprite() {
        sprite.setBounds(map.convertX(x), map.convertY(y), 50f, 50f)
    }
}