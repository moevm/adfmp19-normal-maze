package ru.shabashoff.game.players

import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.scenes.scene2d.Touchable
import ru.shabashoff.game.*
import ru.shabashoff.primitives.IntPoint
import ru.shabashoff.primitives.Point
import ru.shabashoff.primitives.RigidSprite
import ru.shabashoff.ui.PlayerMenu
import ru.shabashoff.ui.UiUtils

abstract class Player(val playerInit: InitPlayer, searchingGift: Gift) : RigidSprite(nextIcon()) {

    var searchingGift: Gift = searchingGift
        set(value) {
            field = value
            menu.changeGift(Sprite(value.sprite))
        }

    protected val map: GameMap = GameUtils.curGameSession!!.map
    private val sess: GameSession = GameUtils.curGameSession!!

    var curPoint: IntPoint = playerInit.startPosition.getPoint(map.w, map.h)

    private var score: Int = 0
        set(value) {
            field = value
            menu.newScore(value)
        }

    private val menu: PlayerMenu = generateMenu(playerInit.name, playerInit.playerMenuPosition, searchingGift, Sprite(sprite))

    init {
        touchable = Touchable.disabled
        zIndex = 100

        val cell = map.getCell(IntPoint(0, 0))!!
        width = cell.w * 0.75f
        height = cell.h * 0.75f

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
        setPosition(sess.map.convertX(curPoint.x), sess.map.convertY(curPoint.y))
    }

    companion object {
        private val poss: Array<Point> = arrayOf(Point(0.10f, 0.50f), Point(0.80f, 0.50f), Point(0.10f, 0.80f), Point(0.10f, 0.30f), Point(0.80f, 0.80f), Point(0.80f, 0.30f))


        private var cur: Int = 0
        private val len = PlayerIcon.values().size

        fun nextIcon(): Sprite {
            val name = PlayerIcon.values()[cur].toString()
            cur = (cur + 1) % len
            return UiUtils.getSprite(name)
        }

        fun generateMenu(name: String, playerMenuPosition: PlayerMenuPosition, gift: Gift, sprite: Sprite): PlayerMenu {
            return PlayerMenu(gift, sprite, name, poss[playerMenuPosition.n])
        }

        fun clear() {
            cur = 0
        }
    }

    override fun remove(): Boolean {
        Player.clear()
        menu.dispose()
        return super.remove()
    }
}