package ru.shabashoff.primitives

import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.Touchable

open class RigidSprite(val sprite: Sprite) : Actor() {

    init {
        touchable = Touchable.enabled
    }

    override fun positionChanged() {
        sprite.setPosition(x, y)
    }

    override fun sizeChanged() {
        sprite.setBounds(x, y, width, height)
    }

    override fun draw(batch: Batch?, parentAlpha: Float) {
        sprite.draw(batch!!)
    }

}