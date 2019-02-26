package ru.shabashoff

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.scenes.scene2d.Stage
import ru.shabashoff.game.GameCell
import ru.shabashoff.game.GameCellType
import ru.shabashoff.game.GameMap
import ru.shabashoff.game.GameUtils
import ru.shabashoff.primitives.Point
import ru.shabashoff.ui.menu.MenuPainter
import ru.shabashoff.ui.UiUtils

class MyGdxGame : ApplicationAdapter() {
    lateinit var menuPainter: MenuPainter

    private lateinit var cells: List<GameCell>
    private lateinit var stage: Stage
    private lateinit var map: GameMap

    override fun create() {
        super.create()

        stage = Stage()
        Gdx.input.inputProcessor = stage

        UiUtils.init()
        GameUtils.init()

        menuPainter = MenuPainter()

        cells = arrayListOf(GameCell(GameCellType.UL, Point(1.0f, 20.0f)), GameCell(GameCellType.CROSSING, Point(100.0f, 200.0f)))

        for (cell in cells) {
            stage.addActor(cell)
        }

        map = GameMap(5, 5, 500.0f, 500.0f, 100.0f, 100.0f)
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
