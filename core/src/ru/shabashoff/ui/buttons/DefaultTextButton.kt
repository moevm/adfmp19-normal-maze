package ru.shabashoff.ui.buttons

import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener
import ru.shabashoff.ui.UiUtils


class DefaultTextButton(x: Float, y: Float, width: Float, height: Float, text: String, private var onclick: () -> Unit) : TextButton(text, getButtonStyle()) {//TODO EXTEND TextButton !!!!

    init {
        this.x = UiUtils.getAbsoluteX(x, width)
        this.y = UiUtils.getAbsoluteY(y, height)
        this.width = UiUtils.getAbsoluteWidthPoint(width)
        this.height = UiUtils.getAbsoluteHeightPoint(height)

        addListener(object : ChangeListener() {
            override fun changed(event: ChangeEvent, actor: Actor) {
                onclick.invoke()
            }
        })

        UiUtils.getStage().addActor(this)
    }

    companion object {
        fun getButtonStyle(): TextButton.TextButtonStyle {
            return UiUtils.btnDefaultStyle
        }
    }

}
