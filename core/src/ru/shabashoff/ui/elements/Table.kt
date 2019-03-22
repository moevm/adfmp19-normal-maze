package ru.shabashoff.ui.elements

import com.badlogic.gdx.scenes.scene2d.ui.Table
import ru.shabashoff.ui.UiUtils


class Table : Table {

    constructor(x: Float, y: Float, width: Float, height: Float) : super() {
        this.x = UiUtils.calcX(x, width)
        this.y = UiUtils.calcY(y, height)
        this.width = UiUtils.calcWidth(width)
        this.height = UiUtils.calcHeight(height)
        setBounds(this.x, this.y, this.width, this.height)
        UiUtils.getStage().addActor(this)
    }

    constructor(x: Float, y: Float) : super() {
        this.x = UiUtils.calcX(x, 0f)
        this.y = UiUtils.calcY(y, 0f)
        setPosition(this.x, this.y)

    }

    init {
        UiUtils.getStage().addActor(this)
    }
}
