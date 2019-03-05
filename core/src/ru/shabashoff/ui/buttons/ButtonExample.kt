package ru.shabashoff.ui.buttons

import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener
import ru.shabashoff.ui.UiUtils


class ButtonExample : Game {

    private lateinit var stage: Stage
    private lateinit var button: TextButton

    private var x: Float
    private var y: Float

    private var width: Float
    private var height: Float

    private var text: String
    private var onclick: () -> Unit

    constructor(x: Float, y: Float, width: Float, height: Float, text: String, onclick: () -> Unit) : super() {
        this.x = UiUtils.getAbsoluteX(x, width)
        this.y = UiUtils.getAbsoluteY(y, height)
        this.width = UiUtils.getAbsoluteWidthPoint(width)
        this.height = UiUtils.getAbsoluteHeightPoint(height)

        this.text = text
        this.onclick = onclick
    }


    @Override
    override fun create() {
        stage = Gdx.input.inputProcessor as Stage

        button = TextButton(text, UiUtils.btnDefaultStyle)

        button.x = x
        button.y = y
        button.width = width
        button.height = height

        stage.addActor(button)
        button.addListener(object : ChangeListener() {
            override fun changed(event: ChangeEvent, actor: Actor) {
                onclick.invoke()
            }
        })
    }

    override fun dispose() {
        super.dispose()
        button.remove()
    }

}
