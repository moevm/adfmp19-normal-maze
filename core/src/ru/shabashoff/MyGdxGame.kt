package ru.shabashoff

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.scenes.scene2d.Stage
import ru.shabashoff.game.GameMap
import ru.shabashoff.game.GameSession
import ru.shabashoff.game.GameUtils
import ru.shabashoff.ui.menu.MenuPainter
import ru.shabashoff.ui.UiUtils

class MyGdxGame : ApplicationAdapter() {
    lateinit var menuPainter: MenuPainter

    private lateinit var stage: Stage

    override fun create() {
        super.create()

        stage = Stage()
        Gdx.input.inputProcessor = stage

        UiUtils.init()
        GameUtils.init()

        menuPainter = MenuPainter()

        GameUtils.curGameSession = GameSession()
    }

    override fun render() {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        super.render()
        stage.draw()
    }

    override fun dispose() {
        super.dispose()

        menuPainter.dispose()
    }
}
