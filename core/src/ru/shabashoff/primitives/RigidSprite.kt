package ru.shabashoff.primitives

import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.Touchable
import ru.shabashoff.ui.UiUtils

open class RigidSprite(val sprite: Sprite) : Actor() {

    init {
        touchable = Touchable.enabled
        UiUtils.getStage().addActor(this)
    }

    override fun positionChanged() {
        println("Set position x:$x y:$y")
        sprite.setPosition(x, y)
    }

    override fun sizeChanged() {
        println("Set pos and size x:$x y:$y w:$width h:$height")
        sprite.setBounds(x, y, width, height)
    }

    override fun draw(batch: Batch?, parentAlpha: Float) {
        sprite.draw(batch!!)
    }
}