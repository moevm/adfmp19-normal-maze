package ru.shabashoff

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.scenes.scene2d.Stage
import ru.shabashoff.ui.menu.MenuPainter
import ru.shabashoff.ui.UiUtils

class MyGdxGame : ApplicationAdapter() {
    lateinit var menuPainter: MenuPainter

    override fun create() {
        super.create()

        Gdx.input.inputProcessor = Stage()
        UiUtils.create()
        menuPainter = MenuPainter()
    }

    override fun render() {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        super.render()
        menuPainter.paint()
    }

    override fun dispose() {
        super.dispose()

        menuPainter.dispose()
    }
}
