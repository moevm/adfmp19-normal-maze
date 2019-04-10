package ru.shabashoff.game.players

import com.badlogic.gdx.scenes.scene2d.Touchable
import ru.shabashoff.game.GameMap
import ru.shabashoff.game.GameUtils
import ru.shabashoff.game.Gift
import ru.shabashoff.primitives.IntPoint
import ru.shabashoff.primitives.RigidSprite
import ru.shabashoff.ui.UiUtils

abstract class Player(var curPoint: IntPoint) : RigidSprite(UiUtils.getIconSprite("PAUSE")) {

    var searchingGift:Gift? = null

    private val map: GameMap = GameUtils.curGameSession!!.map

    init {
        touchable = Touchable.disabled
    }

    fun moveBy(point: IntPoint) {
        move(map.getNewPlayerPosition(curPoint.add(point)))
    }

    fun move(point: IntPoint) {
        println("PLAYER MOVED")
        curPoint = point

        reBoundSprite()
        zIndex = 100
    }

    abstract fun isBot(): Boolean

    private fun reBoundSprite() {
        setBounds(map.convertX(curPoint.x), map.convertY(curPoint.y), 50f, 50f)
    }
}