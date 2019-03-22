package ru.shabashoff.ui.elements

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.scenes.scene2d.ui.TextField
import ru.shabashoff.ui.UiUtils


class TextEdit : TextField {

    constructor(x: Float, y: Float, width: Float, height: Float, text: String) : super(text, getTextFieldStyle()) {
        this.x = UiUtils.calcX(x, width)
        this.y = UiUtils.calcY(y, height)
        this.width = UiUtils.calcWidth(width)
        this.height = UiUtils.calcHeight(height)
        setBounds(this.x, this.y, this.width, this.height)
        UiUtils.getStage().addActor(this)
    }

    constructor(x: Float, y: Float, text: String) : super(text, getTextFieldStyle()) {
        this.x = UiUtils.calcX(x, 0f)
        this.y = UiUtils.calcY(y, 0f)
        setPosition(this.x, this.y)

    }

    constructor(text: String) : super(text, getTextFieldStyle())

    init {
        UiUtils.getStage().addActor(this)
    }

    companion object {
        fun getTextFieldStyle(): TextFieldStyle {
            val textFieldStyle = TextField.TextFieldStyle()
            textFieldStyle.font = BitmapFont()
            textFieldStyle.fontColor = Color.WHITE
            return textFieldStyle
        }
    }
}
