package ru.shabashoff.game.players

import ru.shabashoff.game.GameCell
import ru.shabashoff.game.Gift
import ru.shabashoff.primitives.IntPoint
import java.util.*

class Bot(playerInit: InitPlayer, searchingGift: Gift) : Player(playerInit, searchingGift) {

    private val setPlayer: MutableSet<IntPoint> = HashSet()
    private val setCell: MutableSet<IntPoint> = HashSet()


    fun getPointToMove(): IntPoint {
        prepareMove()

        var min: Int = Int.MAX_VALUE
        var pp: IntPoint = IntPoint(-1, -1)

        for (i1 in setPlayer) {
            for (i2 in setCell) {
                val i = Math.abs(i1.x - i2.x) + Math.abs(i1.y - i2.y)
                if (i < min) {
                    min = i
                    pp = i1
                }

            }
        }

        println("MOVE delta $min, pp:$pp")

        if (min == 0) return searchingGift.point
        return pp
    }

    fun prepareMove() {
        setPlayer.clear()
        setCell.clear()

        this.initSet(map.map, curPoint, setPlayer)
        this.initSet(map.map, searchingGift.point, setCell)
    }

    fun getPointToPut(): IntPoint {

        if (setPlayer.contains(searchingGift.point)) {
            val xSet: MutableSet<Int> = HashSet()
            val ySet: MutableSet<Int> = HashSet()

            for (i in 0..(map.w - 1)) xSet.add(i)
            for (i in 0..(map.h - 1)) ySet.add(i)

            for (ip in setPlayer) {
                xSet.remove(ip.x)
                ySet.remove(ip.y)
            }

            if (xSet.size > 0) return IntPoint(xSet.iterator().next(), 0)
            if (ySet.size > 0) return IntPoint(0, ySet.iterator().next())

            return IntPoint(map.w / 2, 0)
        }

        var min: Int = Int.MAX_VALUE
        var pp: IntPoint = IntPoint(-1, -1)

        val mp = map.map
        val oc = map.outerCell

        for (i in 0..(map.w - 1)) {
            var cc = getXLen(mp, oc, i, 0)
            if (cc < min) {
                min = cc
                pp = IntPoint(i, 0)
            }
            if (cc == 0) {
                println("Zero in ${IntPoint(i, 0)}")
            }

            cc = getXLen(mp, oc, i, map.h - 1)
            if (cc < min) {
                min = cc
                pp = IntPoint(i, map.h - 1)
            }

            if (cc == 0) {
                println("Zero in ${IntPoint(i, map.h - 1)}")
            }

        }

        for (i in 1..(map.h - 2)) {
            var cc = getYLen(mp, oc, 0, i)
            if (cc < min) {
                min = cc
                pp = IntPoint(0, i)
            }

            if (cc == 0) {
                println("Zero in ${IntPoint(0, i)}")
            }

            cc = getYLen(mp, oc, map.w - 1, i)
            if (cc < min) {
                min = cc
                pp = IntPoint(map.w - 1, i)
            }

            if (cc == 0) {
                println("Zero in ${IntPoint(map.w - 1, i)}")
            }
        }
        println("PUT delta $min, pp:$pp")
        return pp
    }

    private fun getXLen(mp: MutableList<MutableList<GameCell>>, oc: GameCell, x: Int, y: Int): Int {

        val tst: MutableList<MutableList<GameCell>> = MutableList(mp.size) { i -> MutableList(mp[i].size) { j -> mp[i][j] } }
        moveXLine(tst, oc, x, y, map.w, map.h)

        val sp: MutableSet<IntPoint> = HashSet()
        val sc: MutableSet<IntPoint> = HashSet()

        this.initSet(tst, curPoint, sp)
        this.initSet(tst, searchingGift.point, sc)

        return getMinLen(sp, sc)
    }

    private fun getYLen(mp: MutableList<MutableList<GameCell>>, oc: GameCell, x: Int, y: Int): Int {

        val tst: MutableList<MutableList<GameCell>> = MutableList(mp.size) { i -> MutableList(mp[i].size) { j -> mp[i][j] } }
        moveYLine(tst, oc, x, y, map.w, map.h)

        val sp: MutableSet<IntPoint> = HashSet()
        val sc: MutableSet<IntPoint> = HashSet()

        this.initSet(tst, curPoint, sp)
        this.initSet(tst, searchingGift.point, sc)

        return getMinLen(sp, sc)
    }


    private fun getMinLen(f1: MutableSet<IntPoint>, f2: MutableSet<IntPoint>): Int {
        var min: Int = Int.MAX_VALUE
        for (i1 in f1) {
            for (i2 in f2) {
                val i = Math.abs(i1.x - i2.x) + Math.abs(i1.y - i2.y)
                if (i == 0) {
                    min = i;
                }
                if (i < min) {
                    min = i
                }

            }
        }
        return min
    }

    private fun moveXLine(map: MutableList<MutableList<GameCell>>, outerCell: GameCell, x: Int, y: Int, w: Int, h: Int) {
        if (x == 0) {
            var nextCell: GameCell = outerCell

            for (i in 0 until w) {
                val hl = map[i][y]
                map[i][y] = nextCell
                nextCell = hl
            }
        } else {

            var nextCell: GameCell = outerCell
            for (i in w - 1 downTo 0) {
                val hl = map[i][y]
                map[i][y] = nextCell
                nextCell = hl
            }
        }
    }


    private fun moveYLine(map: MutableList<MutableList<GameCell>>, outerCell: GameCell, x: Int, y: Int, w: Int, h: Int) {
        val line = map[x]

        if (y == 0) {
            line.add(0, outerCell)
            line.removeAt(h)
        } else {
            line.add(outerCell)
            line.removeAt(0)
        }
    }


    override fun isBot(): Boolean {
        return true
    }


    private fun initSet(map: List<List<GameCell>>, cp: IntPoint, rc: MutableSet<IntPoint>) {
        if (rc.contains(cp)) return

        rc.add(cp)

        val cell = map[cp.x][cp.y]

        if (cell.type.bottom && cp.y > 0) {
            val cl = map[cp.x][cp.y - 1]
            if (cl.type.up) this.initSet(map, IntPoint(cp.x, cp.y - 1), rc)
        }

        if (cell.type.up && cp.y + 1 < map[0].size) {
            val cl = map[cp.x][cp.y + 1]
            if (cl.type.bottom) this.initSet(map, IntPoint(cp.x, cp.y + 1), rc)
        }

        if (cell.type.left && cp.x > 0) {
            val cl = map[cp.x - 1][cp.y]
            if (cl.type.right) this.initSet(map, IntPoint(cp.x - 1, cp.y), rc)
        }
        if (cell.type.right && cp.x + 1 < map.size) {
            val cl = map[cp.x + 1][cp.y]
            if (cl.type.left) this.initSet(map, IntPoint(cp.x + 1, cp.y), rc)
        }
    }
/*
    private fun initSet(map: List<List<GameCell>>, curPoint: IntPoint, vis: MutableSet<IntPoint>) {
        //println(curPoint)

        vis.add(curPoint)

        val curCell: GameCell = map[curPoint.x][curPoint.y]
        var nextCell: GameCell
        var nextPoint: IntPoint

        if (curCell.type.up && curPoint.y + 1 < map[0].size) {
            nextPoint = IntPoint(curPoint.x, curPoint.y + 1)
            nextCell = map[nextPoint.x][nextPoint.y]
            if (nextCell.type.bottom && !vis.contains(nextPoint)) {
                this.initSet(map, nextPoint, vis)
            }
        }

        if (curCell.type.bottom && curPoint.y > 0) {
            nextPoint = IntPoint(curPoint.x, curPoint.y - 1)
            nextCell = map[nextPoint.x][nextPoint.y]
            if (nextCell.type.up && !vis.contains(nextPoint)) {
                this.initSet(map, nextPoint, vis)
            }
        }

        if (curCell.type.left && curPoint.x > 0) {
            nextPoint = IntPoint(curPoint.x - 1, curPoint.y)
            nextCell = map[nextPoint.x][nextPoint.y]
            if (nextCell.type.right && !vis.contains(nextPoint)) {
                this.initSet(map, nextPoint, vis)
            }
        }

        if (curCell.type.right && curPoint.x + 1 < map.size) {
            nextPoint = IntPoint(curPoint.x + 1, curPoint.y)
            nextCell = map[nextPoint.x][nextPoint.y]
            if (nextCell.type.left && !vis.contains(nextPoint)) {
                this.initSet(map, nextPoint, vis)
            }
        }
    }*/

    private fun chooseMinWay(map: List<List<GameCell>>, from: IntPoint, to: IntPoint) {
        //TODO choose min way


    }
}