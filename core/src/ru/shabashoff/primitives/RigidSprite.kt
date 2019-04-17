package ru.shabashoff.primitives

import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.Touchable
import ru.shabashoff.ui.UiUtils

open class RigidSprite(sprite: Sprite) : Actor() {
    var sprite: Sprite = sprite
        set(value) {
            field = value
            positionChanged()
            sizeChanged()
        }

    init {
        touchable = Touchable.enabled
        UiUtils.getStage().addActor(this)
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