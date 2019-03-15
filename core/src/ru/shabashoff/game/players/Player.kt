package ru.shabashoff.game.players

import ru.shabashoff.game.GameMap
import ru.shabashoff.game.GameUtils
import ru.shabashoff.primitives.IntPoint
import ru.shabashoff.primitives.RigidSprite
import ru.shabashoff.ui.UiUtils

abstract class Player(var curPoint: IntPoint) : RigidSprite(UiUtils.getIconSprite("PAUSE")) {


    private val map: GameMap = GameUtils.curGameSession!!.map

    init {
        reBoundSprite()
    }

    fun move(point: IntPoint) {
        curPoint = point

        reBoundSprite()
    }

    abstract fun isBot(): Boolean

    private fun reBoundSprite() {
        setBounds(map.convertX(curPoint.x), map.convertY(curPoint.y), 50f, 50f)
    }
}