package ru.shabashoff

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.Stage
import ru.shabashoff.game.GameUtils
import ru.shabashoff.ui.UiUtils
import ru.shabashoff.ui.menu.MenuPainter


class MyGdxGame : ApplicationAdapter() {
    private lateinit var menuPainter: MenuPainter

    private lateinit var stage: Stage

    private lateinit var batch: SpriteBatch


    override fun create() {
        super.create()

        batch = SpriteBatch()

        stage = Stage()
        Gdx.input.inputProcessor = stage

        UiUtils.init()
        GameUtils.init()

        menuPainter = MenuPainter()

        UiUtils.menuPainter = menuPainter
    }

    override fun render() {
        Gdx.gl.glClearColor(0f, 0.2f, 0.2f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        super.render()
        stage.draw()

        batch.begin()

        /*for (sprite in UiUtils.getSprites()) {
            sprite.draw(batch)
        }*/

        batch.end()
    }

    override fun dispose() {
        super.dispose()

        batch.dispose()
        menuPainter.dispose()
    }
}
