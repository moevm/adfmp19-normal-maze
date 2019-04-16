package ru.shabashoff.game.players

import com.badlogic.gdx.scenes.scene2d.Touchable
import ru.shabashoff.game.*
import ru.shabashoff.primitives.IntPoint
import ru.shabashoff.primitives.Point
import ru.shabashoff.primitives.RigidSprite
import ru.shabashoff.ui.PlayerMenu
import ru.shabashoff.ui.UiUtils

abstract class Player(var curPoint: IntPoint, var searchingGift: GiftType) : RigidSprite(UiUtils.getIconSprite("PAUSE")) {

    private val map: GameMap = GameUtils.curGameSession!!.map
    private val sess: GameSession = GameUtils.curGameSession!!

    private val menu: PlayerMenu = PlayerMenu(UiUtils.getIconSprite("PAUSE"), "test", Point(0.10f, 0.80f))

    init {
        touchable = Touchable.disabled
    }

    fun moveBy(point: IntPoint) {
        move(sess.map.getNewPlayerPosition(curPoint.add(point)))
    }

    fun move(point: IntPoint) {
        println("PLAYER MOVED")
        curPoint = point

        reBoundSprite()
        zIndex = 100

        checkGift(point)
    }

    abstract fun isBot(): Boolean

    private fun checkGift(point: IntPoint) {
        val cell = sess.map.getCell(point)!!

        val gift = cell.gift

        if (gift != null && gift.type == searchingGift) {
            cell.gift = null
            sess.giftFounded()
        }
    }

    private fun reBoundSprite() {
        setBounds(sess.map.convertX(curPoint.x), sess.map.convertY(curPoint.y), 50f, 50f)
    }
}