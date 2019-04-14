package ru.shabashoff.game.players

import ru.shabashoff.game.GameCell
import ru.shabashoff.game.GiftType
import ru.shabashoff.primitives.IntPoint

class Bot(curPoint: IntPoint, searchingGift: GiftType) : Player(curPoint, searchingGift) {

    val setPlayer: MutableSet<IntPoint> = HashSet()
    val setCell: MutableSet<IntPoint> = HashSet()


    fun getPointToPut(): IntPoint {

        /*initSet(map.map, IntPoint(x, y), setPlayer)
        initSet(map.map, IntPoint(2, 2), setPlayer) // TODO going to search point*/


        return IntPoint(2, 2)
    }


    fun getPointToMove(): IntPoint {
        return IntPoint(0, 0)
    }


    override fun isBot(): Boolean {
        return true
    }

    private fun initSet(map: List<List<GameCell>>, curPoint: IntPoint, vis: MutableSet<IntPoint>) {
        println(curPoint)

        vis.add(curPoint)

        val curCell: GameCell = map[curPoint.x][curPoint.y]
        var nextCell: GameCell
        var nextPoint: IntPoint

        if (curCell.type.up && curPoint.y + 1 < map[0].size) {
            nextPoint = IntPoint(curPoint.x, curPoint.y + 1)
            nextCell = map[nextPoint.x][nextPoint.y]
            if (nextCell.type.bottom && !vis.contains(nextPoint)) {
                initSet(map, nextPoint, vis)
            }
        }

        if (curCell.type.bottom && curPoint.y > 0) {
            nextPoint = IntPoint(curPoint.x, curPoint.y - 1)
            nextCell = map[nextPoint.x][nextPoint.y]
            if (nextCell.type.up && !vis.contains(nextPoint)) {
                initSet(map, nextPoint, vis)
            }
        }

        if (curCell.type.left && curPoint.x > 0) {
            nextPoint = IntPoint(curPoint.x - 1, curPoint.y)
            nextCell = map[nextPoint.x][nextPoint.y]
            if (nextCell.type.right && !vis.contains(nextPoint)) {
                initSet(map, nextPoint, vis)
            }
        }

        if (curCell.type.right && curPoint.x + 1 < map.size) {
            nextPoint = IntPoint(curPoint.x + 1, curPoint.y)
            nextCell = map[nextPoint.x][nextPoint.y]
            if (nextCell.type.left && !vis.contains(nextPoint)) {
                initSet(map, nextPoint, vis)
            }
        }
    }

    private fun chooseMinWay(map: List<List<GameCell>>, from: IntPoint, to: IntPoint) {
        //TODO choose min way


    }
}