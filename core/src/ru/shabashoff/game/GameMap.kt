package ru.shabashoff.game

import com.badlogic.gdx.math.MathUtils.random
import ru.shabashoff.primitives.Point
import ru.shabashoff.ui.UiUtils

class GameMap {
    private val map: Array<Array<GameCell>>

    private val widthMap: Float
    private val heightMap: Float

    private val widthElem: Float
    private val heightElem: Float

    private val paddingX: Float
    private val paddingY: Float

    private val w: Int
    private val h: Int


    constructor(w: Int, h: Int, widthMap: Float, heightMap: Float, paddingX: Float, paddingY: Float) {
        this.w = w
        this.h = h
        this.paddingX = paddingX
        this.paddingY = paddingY
        this.heightMap = heightMap
        this.widthMap = widthMap

        this.widthElem = widthMap / w.toFloat()
        this.heightElem = heightMap / h.toFloat()

        map = Array(h) { i -> Array(w) { j -> GameCell(getRandType(), Point(convertX(i), convertY(j))) } }
        map.forEach { arr -> arr.forEach { c -> UiUtils.getStage().addActor(c) } }
    }

    private fun convertX(x: Int): Float {
        return paddingX + widthElem * x.toFloat()
    }

    private fun convertY(y: Int): Float {
        return paddingY + heightElem * y.toFloat()
    }


    private fun getRandType(): GameCellType {
        val i = random.nextInt(GameCellType.values().size)
        return GameCellType.values()[i]
    }
}