package ru.shabashoff.ui.elements

import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener
import ru.shabashoff.ui.UiUtils


class DefaultTextButton(x: Float, y: Float, width: Float, height: Float, text: String, private var onclick: () -> Unit) : TextButton(text, getButtonStyle()) {

    init {
        this.x = UiUtils.calcX(x, width)
        this.y = UiUtils.calcY(y, height)
        this.width = UiUtils.calcWidth(width)
        this.height = UiUtils.calcHeight(height)

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
