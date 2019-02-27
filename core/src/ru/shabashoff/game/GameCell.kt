package ru.shabashoff.game

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.scenes.scene2d.Action
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.Touchable
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import ru.shabashoff.primitives.Point


class GameCell(val type: GameCellType, val point: Point, val w: Float, val h: Float) : Actor() {

    private var sprite: Sprite = type.getSprite()

    private var clickTime: Long = 0L

    private var predTouch: Point? = null

    init {
        sprite.setBounds(point.x, point.y, w, h)
        setBounds(sprite.x, sprite.y, sprite.width, sprite.height)

        touchable = Touchable.enabled

        addListener(object : ClickListener() {
            override fun touchDragged(event: InputEvent?, x: Float, y: Float, pointer: Int) {
                println("""DRAG x: $x y: $y predTouch: $predTouch isClick: ${isClick()}""")

                if (predTouch != null && !isClick()) {
                    val dx = x - predTouch!!.x
                    val dy = y - predTouch!!.y

                    moveBy(dx, dy)

                    predTouch = Point(x - dx, y - dy)
                } else {
                    predTouch = Point(x, y)
                }


                super.touchDragged(event, x, y, pointer)
            }

            override fun touchDown(event: InputEvent?, x: Float, y: Float, pointer: Int, button: Int): Boolean {

                if (clickTime != 0L) {
                    Gdx.app.debug("Clicking error", "Click time is: $clickTime")
                }


                println("DOWN")

                clickTime = System.currentTimeMillis()

                return true
            }


            override fun touchUp(event: InputEvent?, x: Float, y: Float, pointer: Int, button: Int) {
                if (isClick()) {
                    println("Is click")
                }
                println("UP")
                predTouch = null
                clickTime = 0L
                super.touchUp(event, x, y, pointer, button)
            }
        })

    }

    fun isClick(): Boolean {
        return System.currentTimeMillis() - clickTime < 250L
    }

    override fun positionChanged() {
        sprite.setPosition(x, y)
    }

    override fun draw(batch: Batch?, parentAlpha: Float) {
        sprite.draw(batch!!)
    }

    override fun addAction(action: Action?) {
        print("Action: $action")
        super.addAction(action)
    }
}