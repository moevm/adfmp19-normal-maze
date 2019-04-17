package ru.shabashoff.game

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.math.MathUtils.random
import ru.shabashoff.primitives.*
import java.lang.IllegalArgumentException

class GameMap {
    private val map: MutableList<MutableList<GameCell>>
    private var outerCell: GameCell

    private val prizes: MutableList<Gift> = ArrayList()
    private val playerPrizes: MutableList<Gift> = ArrayList()

    private val widthMap: Float
    private val heightMap: Float

    private val widthElem: Float
    private val heightElem: Float

    private val paddingX: Float
    private val paddingY: Float

    private val w: Int
    private val h: Int

    private val padding: Float = 1.0f

    constructor(prizeCount: Int, w: Int, h: Int, widthMap: Float, heightMap: Float, paddingX: Float, paddingY: Float) {
        if (prizeCount > GiftType.values().size) {
            throw IllegalArgumentException("Cant create map with $prizeCount gifts, because gifts only ${GiftType.values().size}")
        }

        this.w = w
        this.h = h
        this.paddingX = paddingX
        this.paddingY = paddingY
        this.heightMap = heightMap
        this.widthMap = widthMap

        val wEl = (widthMap / w.toFloat()) - padding
        val hEl = (heightMap / h.toFloat()) - padding

        if (wEl < hEl) {
            widthElem = wEl
            heightElem = wEl
        } else {
            widthElem = hEl
            heightElem = hEl
        }

        map = MutableList(w) { i -> MutableList(h) { j -> GameCell(getRandType(), IntPoint(i, j), Point(convertX(i), convertY(j)), widthElem, heightElem) } }
        outerCell = GameCell(getRandType(), IntPoint(-1, -1), Point(0f, 0f), widthElem, heightElem)
        outerCell.isDraggable = true

        fillPrizes(prizeCount)
    }

    fun convertX(x: Int): Float {
        return paddingX + (widthElem + padding) * x.toFloat()
    }

    fun convertY(y: Int): Float {
        return paddingY + (heightElem + padding) * y.toFloat()
    }


    fun onDrag(cell: GameCell, x: Float, y: Float) {
        /*val center = cell.getCenter()

        if (isPointOnMap(center)) {
            /*println("Cell out of the map: $cell")
            println("Expected cell (${deConvertX(center.x)},${deConvertY(center.y)})")*/
        }*/

        cell.onDrag(x, y)

        //TODO Add implementation
    }

    fun deConvertX(x: Float): Int {
        return ((x - paddingX) / (widthElem + padding)).toInt()
    }

    fun deConvertY(y: Float): Int {
        return ((y - paddingY) / (heightElem + padding)).toInt()
    }

    fun onClick(cell: GameCell) {
        var center = cell.getCenter()

        //println(IntPoint(deConvertX(center.x), deConvertY(center.y)))
    }

    fun onPut(cell: GameCell): MoveLine? {
        val center = cell.getCenter()

        if (!isPointOnMap(center)) return null

        val xi = deConvertX(center.x)
        val yi = deConvertY(center.y)

        if (yi == 0 || yi == h - 1) {
            moveYLine(xi, yi)
            return MoveLine(xi, LineType.X, if (yi == 0) MoveTo.UP else MoveTo.DOWN)
        }

        if (xi == 0 || xi == w - 1) {
            moveXLine(xi, yi)
            return MoveLine(yi, LineType.Y, if (xi == 0) MoveTo.RIGHT else MoveTo.LEFT)
        }

        return null
    }

    fun dispose() {
        map.forEach { l -> l.forEach { c -> c.remove() } }
        outerCell.remove()
    }

    fun getCell(pp: IntPoint): GameCell? {
        if (isValidPoint(pp)) return map[pp.x][pp.y]

        return null
    }

    fun checkConstraints() {
        for ((i, mutableList) in map.withIndex()) {
            for ((j, cl) in mutableList.withIndex()) {
                if (!cl.getIp().equals(IntPoint(i, j))) {
                    println("Error constraints!!!")
                    println("i:$i j:$j")
                    println("x:${cl.getIp().x} y:${cl.getIp().y}")
                }
            }
        }

        println("End check")
    }

    fun getNewPlayerPosition(point: IntPoint): IntPoint {
        if (isValidPoint(point)) return point

        while (point.x < 0) point.x += w
        while (point.y < 0) point.y += h

        while (point.x >= w) point.x %= w
        while (point.y >= h) point.y %= h

        return point
    }

    fun getGift(): Gift {
        var pr = prizes.removeAt(prizes.size - 1)

        playerPrizes.add(pr)

        return pr
    }

    private fun isPointOnMap(p: Point): Boolean {
        return !(p.x < paddingX || p.y < paddingY || p.x > paddingX + widthMap || p.y > paddingY + heightMap)
    }

    private fun getRandType(): GameCellType {
        val i = random.nextInt(GameCellType.values().size)
        return GameCellType.values()[i]
    }

    private fun moveXLine(x: Int, y: Int) {
        if (x != 0 && x != w - 1) {
            Gdx.app.error("Error", "Y line doesn't front line")
            return
        }

        outerCell.isDraggable = false
        val newOuter: GameCell?

        if (x == 0) {
            newOuter = map[w - 1][y]

            var nextCell: GameCell = outerCell

            for (i in 0 until w) {
                val hl = map[i][y]
                map[i][y] = nextCell
                nextCell = hl
            }
        } else {
            newOuter = map[0][y]

            var nextCell: GameCell = outerCell
            for (i in w - 1 downTo 0) {
                val hl = map[i][y]
                map[i][y] = nextCell
                nextCell = hl
            }
        }

        outerCell = newOuter

        for (i in 0 until w) {
            map[i][y].moveWithAnimation(Point(convertX(i), convertY(y)))
            map[i][y].setIp(IntPoint(i, y))
            //map[i][y].animateFlashing()
        }
        afterMove()
    }

    private fun moveYLine(x: Int, y: Int) {
        if (y != 0 && y != h - 1) {
            Gdx.app.error("Error", "X line doesn't front line")
            return
        }

        val line = map[x]

        outerCell.isDraggable = false

        outerCell = if (y == 0) {
            line.add(0, outerCell)
            line.removeAt(h)
        } else {
            line.add(outerCell)
            line.removeAt(0)
        }

        for (i in 0 until h) {
            line[i].moveWithAnimation(Point(convertX(x), convertY(i)))
            line[i].setIp(IntPoint(x, i))
            //line[i].animateFlashing()
        }

        afterMove()
    }

    private fun isValidPoint(point: IntPoint): Boolean {
        return ((point.x < 0 || point.x >= w) || (point.y < 0 || point.y >= h)).not()
    }

    private fun afterMove() {
        outerToPoint()
//        GameUtils.curGameSession?.afterPut()
    }

    private fun fillPrizes(count: Int) {
        var types = GiftType.values().copyOfRange(0, count)

        for (pr in types) {
            prizes.add(Gift(pr))
        }

        var x: Int
        var y: Int

        for (pr in prizes) {
            do {
                x = random.nextInt(map.size)
                y = random.nextInt(map[x].size)
            } while (map[x][y].gift != null)
            map[x][y].gift = pr
            //map[x][y].moveBy(0f, 0f)//Set position to gift
        }
    }

    private fun outerToPoint() {
        outerCell.zIndex = 1000
        outerCell.moveWithAnimation(Point(0f, 0f))
        outerCell.isDraggable = true
    }
}