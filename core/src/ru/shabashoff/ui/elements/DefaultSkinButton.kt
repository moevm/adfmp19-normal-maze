package ru.shabashoff.ui.elements

import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.ui.Button
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener
import ru.shabashoff.ui.UiUtils


class DefaultSkinButton(x: Float, y: Float, width: Float, height: Float, private val sprite: Sprite, private val onclick: () -> Unit) : Button(getButtonStyle()) {

    init {
        this.x = UiUtils.calcX(x, width)
        this.y = UiUtils.calcY(y, height)
        this.width = UiUtils.calcWidth(width)
        this.height = UiUtils.calcHeight(height)

        sprite.setBounds(this.x, this.y, this.width, this.height)

        addListener(object : ChangeListener() {
            override fun changed(event: ChangeEvent, actor: Actor) {
                onclick.invoke()
            }
        })

        UiUtils.getStage().addActor(this)
    }


    fun makeSquare() {
        val min: Float = minOf(width, height)

        width = min
        height = min
    }


    override fun positionChanged() {
        sprite.setBounds(this.x, this.y, this.width, this.height)
        super.positionChanged()
    }

    @Suppress("UNNECESSARY_SAFE_CALL")
    override fun sizeChanged() {
        sprite?.setBounds(this.x, this.y, this.width, this.height)
        super.sizeChanged()
    }

    override fun draw(batch: Batch?, parentAlpha: Float) {
        super.draw(batch, parentAlpha)
        sprite.draw(batch, parentAlpha)
    }


    companion object {
        fun getButtonStyle(): TextButton.TextButtonStyle {
            return UiUtils.st
        }
    }

}
