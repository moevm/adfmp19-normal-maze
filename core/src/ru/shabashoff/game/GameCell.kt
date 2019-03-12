package ru.shabashoff.game

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.scenes.scene2d.Action
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.Touchable
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import ru.shabashoff.primitives.Point
import ru.shabashoff.primitives.RigidSprite


class GameCell(val type: GameCellType, point: Point, private val w: Float, private val h: Float) : RigidSprite(type.getSprite()) {

    private val ANIMATE_DURATION = 500f

    internal var isDraggable: Boolean = false

    private var clickTime: Long = 0L

    private var lastTouch: Point? = null

    private val animation: ru.shabashoff.animation.Animation = ru.shabashoff.animation.Animation(this)

    init {
        setBounds(point.x, point.y, w, h)

        touchable = Touchable.enabled

        addListener(object : ClickListener() {
            override fun touchDragged(event: InputEvent?, x: Float, y: Float, pointer: Int) {
                if (!isDraggable) return

                GameUtils.curGameSession?.onDrag(this@GameCell, x, y)
            }

            override fun touchDown(event: InputEvent?, x: Float, y: Float, pointer: Int, button: Int): Boolean {
                clickTime = System.currentTimeMillis()
                return true
            }


            override fun touchUp(event: InputEvent?, x: Float, y: Float, pointer: Int, button: Int) {
                if (!isDraggable && isClick()) {
                    GameUtils.curGameSession?.onClick(this@GameCell)
                }

                if (lastTouch != null) {
                    GameUtils.curGameSession?.onPut(this@GameCell)
                }

                lastTouch = null
                clickTime = 0L

                super.touchUp(event, x, y, pointer, button)
            }
        })

    }

    fun onDrag(x: Float, y: Float) {
        if (!isDraggable) return

        lastTouch = if (lastTouch != null) {
            val dx = x - lastTouch!!.x
            val dy = y - lastTouch!!.y

            moveBy(dx, dy)

            Point(x - dx, y - dy)
        } else {
            Point(x, y)
        }
    }

    fun isClick(): Boolean {
        return System.currentTimeMillis() - clickTime < 250L
    }

    override fun draw(batch: Batch?, parentAlpha: Float) {
        sprite.draw(batch!!)
    }

    override fun addAction(action: Action?) {
        print("Action: $action")
        super.addAction(action)
    }

    fun getCenter(): Point {
        return Point(x + w / 2f, y + h / 2f)
    }

    fun moveWithAnimation(point: Point) {
        animation.animateMove(ANIMATE_DURATION, point)
    }

    fun animateFlashing() {
        animation.animateFlashing(ANIMATE_DURATION, 0.012f)
    }

    fun animateAppearance() {
        animation.animateAppearance(ANIMATE_DURATION)
    }

    override fun setColor(color: Color?) {
        sprite.color = color
    }

    override fun setColor(r: Float, g: Float, b: Float, a: Float) {
        sprite.color = color
    }

    override fun toString(): String {
        return "GameCell(type=$type, point=($x,$y), w=$w, h=$h, isDraggable=$isDraggable)"
    }
}