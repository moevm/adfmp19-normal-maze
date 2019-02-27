package ru.shabashoff.game

import com.badlogic.gdx.math.MathUtils.random
import ru.shabashoff.primitives.Point
import ru.shabashoff.ui.UiUtils

class GameMap {
    private val map: Array<Array<GameCell>>

    private val outerCell: GameCell

    private val widthMap: Float
    private val heightMap: Float

    private val widthElem: Float
    private val heightElem: Float

    private val paddingX: Float
    private val paddingY: Float

    private val w: Int
    private val h: Int

    private val padding: Float = 1.0f

    constructor(w: Int, h: Int, widthMap: Float, heightMap: Float, paddingX: Float, paddingY: Float) {
        this.w = w
        this.h = h
        this.paddingX = paddingX
        this.paddingY = paddingY
        this.heightMap = heightMap
        this.widthMap = widthMap

        this.widthElem = (widthMap / w.toFloat()) - padding
        this.heightElem = (heightMap / h.toFloat()) - padding

        map = Array(h) { i -> Array(w) { j -> GameCell(getRandType(), Point(convertX(i), convertY(j)), widthElem, heightElem) } }
        map.forEach { arr -> arr.forEach { c -> UiUtils.getStage().addActor(c) } }

        outerCell = GameCell(getRandType(), Point(0f, 0f), widthElem, heightElem)
        UiUtils.getStage().addActor(outerCell)
        outerCell.isDraggable = true
    }

    private fun convertX(x: Int): Float {
        return paddingX + (widthElem + padding) * x.toFloat()
    }

    private fun convertY(y: Int): Float {
        return paddingY + (heightElem + padding) * y.toFloat()
    }


    private fun getRandType(): GameCellType {
        val i = random.nextInt(GameCellType.values().size)
        return GameCellType.values()[i]
    }

    fun onDrag(cell: GameCell) {
        val center = cell.getCenter()

        TODO("Add implementation")
    }

}