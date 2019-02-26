package ru.shabashoff.game

import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.scenes.scene2d.Action
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.Touchable
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import ru.shabashoff.primitives.Point


class GameCell(val type: GameCellType, var point: Point) : Actor() {

    private var sprite: Sprite = type.getSprite()

    init {
        sprite.setBounds(point.x, point.y, 100f, 100f)

        print("x " + sprite.x + " y " + sprite.y + " w " + sprite.width + " h " + sprite.height)

        setBounds(sprite.x, sprite.y, sprite.width, sprite.height)

        touchable = Touchable.enabled

        addListener(object : ClickListener() {
            override fun touchDown(event: InputEvent?, x: Float, y: Float, pointer: Int, button: Int): Boolean {
                println("DOWN")

                return true
            }

            override fun touchUp(event: InputEvent?, x: Float, y: Float, pointer: Int, button: Int) {
                println("UP")
                super.touchUp(event, x, y, pointer, button)
            }
        })

    }

    override fun positionChanged() {
        sprite.setPosition(x, y)
        super.positionChanged()
    }

    override fun draw(batch: Batch?, parentAlpha: Float) {
        sprite.draw(batch!!)
    }

    override fun addAction(action: Action?) {
        print("Action: $action")
        super.addAction(action)
    }
}