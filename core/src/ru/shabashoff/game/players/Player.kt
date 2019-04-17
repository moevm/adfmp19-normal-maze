package ru.shabashoff.game.players

import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.scenes.scene2d.Touchable
import ru.shabashoff.game.*
import ru.shabashoff.primitives.IntPoint
import ru.shabashoff.primitives.Point
import ru.shabashoff.primitives.RigidSprite
import ru.shabashoff.ui.PlayerMenu
import ru.shabashoff.ui.UiUtils

abstract class Player(var curPoint: IntPoint, searchingGift: Gift) : RigidSprite(nextIcon()) {

    var searchingGift: Gift = searchingGift
        set(value) {
            field = value
            menu.changeGift(Sprite(value.sprite))
        }
    private var score: Int = 0
        set(value) {
            field = value
            menu.newScore(value)
        }

    private val menu: PlayerMenu = generateMenu(searchingGift, Sprite(sprite))

    private val map: GameMap = GameUtils.curGameSession!!.map
    private val sess: GameSession = GameUtils.curGameSession!!

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

        if (gift != null && gift.type == searchingGift.type) {
            cell.gift = null
            sess.giftFounded()
            score++
        }
    }

    private fun reBoundSprite() {
        setBounds(sess.map.convertX(curPoint.x), sess.map.convertY(curPoint.y), 50f, 50f)
    }

    companion object {
        private val poss: Array<Point> = arrayOf(Point(0.10f, 0.80f), Point(0.10f, 0.30f), Point(0.90f, 0.80f), Point(0.90f, 0.30f))
        private var curMenuPos: Int = 0


        private var cur: Int = 0
        private val len = PlayerIcon.values().size

        fun nextIcon(): Sprite {
            val name = PlayerIcon.values()[cur].toString()
            cur = (cur + 1) % len
            return UiUtils.getSprite(name)
        }

        fun generateMenu(gift: Gift, sprite: Sprite): PlayerMenu {
            var playerMenu = PlayerMenu(gift, sprite, "test", poss[curMenuPos])
            curMenuPos = (curMenuPos + 1) % poss.size
            return playerMenu
        }

        fun clear() {
            cur = 0
            curMenuPos = 0
        }
    }

    override fun remove(): Boolean {
        Player.clear()
        menu.dispose()
        return super.remove()
    }
}