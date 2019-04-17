package ru.shabashoff.ui.elements

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.scenes.scene2d.ui.Label
import ru.shabashoff.ui.UiUtils


class TextLabel : Label {

    constructor(x: Float, y: Float, width: Float, height: Float, text: String) : super(text, getLabelStyle()) {
        this.x = UiUtils.calcX(x, width)
        this.y = UiUtils.calcY(y, height)
        this.width = UiUtils.calcWidth(width)
        this.height = UiUtils.calcHeight(height)
        setBounds(this.x, this.y, this.width, this.height)
        UiUtils.getStage().addActor(this)
    }

    constructor(x: Float, y: Float, text: String, color: Color) : super(text, getLabelStyle()) {
        this.x = UiUtils.calcX(x, 0f)
        this.y = UiUtils.calcY(y, 0f)
        setPosition(this.x, this.y)
        this.color = color
    }

    constructor(text: String) : super(text, getLabelStyle())

    init {
        UiUtils.getStage().addActor(this)
    }

    companion object {
        fun getLabelStyle(): Label.LabelStyle {

            var labelStyle = Label.LabelStyle()
            labelStyle.background = null

            labelStyle.font = BitmapFont()

            return Label.LabelStyle(BitmapFont(), Color.GRAY)
        }
    }

}
