package ru.shabashoff.game

import ru.shabashoff.game.players.Player
import ru.shabashoff.game.players.RealPlayer
import ru.shabashoff.primitives.IntPoint
import ru.shabashoff.primitives.LineType
import ru.shabashoff.primitives.MoveTo

class GameSession {

    val map: GameMap = GameMap(4, 4, 300.0f, 300.0f, 100.0f, 100.0f)

    private lateinit var players: List<Player>
    private lateinit var curPlayer: Player

    private var curNumPlayer: Int = 0

    private var gameMode: GameMode = GameMode.FIRST

    private val reachableCells: MutableSet<GameCell> = HashSet()

    init {
        map.checkConstraints()
    }

    fun dispose() {
        players.forEach { p -> p.remove() }
        map.dispose()
    }

    fun loadPlayers() {
        players = listOf(RealPlayer(IntPoint(0, 0)), RealPlayer(IntPoint(3, 3)))
        curPlayer = players[0]
    }

    fun onClick(cell: GameCell) {
        println("Onclick sell:$cell")
        if (curPlayer.isBot() || gameMode == GameMode.FIRST || reachableCells.contains(cell).not()) return

        map.checkConstraints()

        val point = cell.getCenter()

        curPlayer.move(IntPoint(map.deConvertX(point.x), map.deConvertY(point.y)))

        gameMode = GameMode.FIRST
        nextPlayer()
        map.onClick(cell)
    }

    fun onDrag(cell: GameCell, x: Float, y: Float) {
        if (curPlayer.isBot() || gameMode == GameMode.SECOND) return
        //TODO: Check permission

        map.onDrag(cell, x, y)
    }

    fun onPut(cell: GameCell) {
        if (curPlayer.isBot() || gameMode == GameMode.SECOND) return
        //TODO: Check permission

        val onPut = map.onPut(cell)
        if (onPut != null) {
            for (player in players) {
                when {
                    onPut.type == LineType.Y && onPut.line == player.curPoint.y -> player.moveBy(IntPoint(if (onPut.moveTo == MoveTo.RIGHT) 1 else -1, 0))
                    onPut.type == LineType.X && onPut.line == player.curPoint.x -> player.moveBy(IntPoint(0, if (onPut.moveTo == MoveTo.UP) 1 else -1))
                }
            }

            afterPut()
        }
    }

    fun afterPut() {
        reachableCells.clear()
        fillReachableCells(map.getCell(curPlayer.curPoint))
        print(reachableCells)

        gameMode = GameMode.SECOND
    }

    private fun fillReachableCells(cell: GameCell?) {
        if (cell == null || reachableCells.contains(cell)) return

        reachableCells.add(cell)

        if (cell.type.bottom) {
            val cl = map.getCell(cell.getIp().add(IntPoint(0, -1)))
            if (cl != null && cl.type.up) fillReachableCells(cl)
        }
        if (cell.type.up) {
            val cl = map.getCell(cell.getIp().add(IntPoint(0, 1)))
            if (cl != null && cl.type.bottom) fillReachableCells(cl)
        }
        if (cell.type.left) {
            val cl = map.getCell(cell.getIp().add(IntPoint(-1, 0)))
            if (cl != null && cl.type.right) fillReachableCells(cl)
        }
        if (cell.type.right) {
            val cl = map.getCell(cell.getIp().add(IntPoint(1, 0)))
            if (cl != null && cl.type.left) fillReachableCells(cl)
        }
    }

    private fun nextPlayer() {
        curNumPlayer = (curNumPlayer + 1) % players.size
        curPlayer = players[curNumPlayer]

        /*if (curPlayer.isBot()) {
            var bot: Bot = curPlayer as Bot


        }*/
    }

    enum class GameMode {
        FIRST, SECOND
    }
}
