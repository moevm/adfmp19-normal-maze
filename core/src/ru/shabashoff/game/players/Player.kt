package ru.shabashoff.game.players

import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.scenes.scene2d.Touchable
import ru.shabashoff.game.*
import ru.shabashoff.primitives.IntPoint
import ru.shabashoff.primitives.Point
import ru.shabashoff.primitives.RigidSprite
import ru.shabashoff.ui.PlayerMenu
import ru.shabashoff.ui.UiUtils

abstract class Player(var curPoint: IntPoint, var searchingGift: GiftType) : RigidSprite(nextIcon()) {

    private val map: GameMap = GameUtils.curGameSession!!.map
    private val sess: GameSession = GameUtils.curGameSession!!

    private val menu: PlayerMenu = PlayerMenu(searchingGift,Sprite(sprite), "test", Point(0.10f, 0.80f))

    init {
        touchable = Touchable.disabled
        zIndex = 100
        reBoundSprite()
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

    companion object {
        private var cur: Int = 0
        private val len = PlayerIcon.values().size

        fun nextIcon(): Sprite {
            val name = PlayerIcon.values()[cur].toString()
            cur = (cur + 1) % len
            return UiUtils.getSprite(name)
        }
    }
}