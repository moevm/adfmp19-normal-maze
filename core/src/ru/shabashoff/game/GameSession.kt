package ru.shabashoff.game

import ru.shabashoff.game.players.Player
import ru.shabashoff.game.players.RealPlayer
import ru.shabashoff.primitives.IntPoint

class GameSession {

    val map: GameMap = GameMap(4, 4, 300.0f, 300.0f, 100.0f, 100.0f)

    private lateinit var players: List<Player>
    private lateinit var curPlayer: Player

    private var curNumPlayer: Int = 0

    private var gameMode: GameMode = GameMode.FIRST

    fun loadPlayers() {
        players = listOf(RealPlayer(0, 0), RealPlayer(3, 3))
        curPlayer = players[0]
    }

    fun onClick(cell: GameCell) {
        if (curPlayer.isBot() || gameMode == GameMode.FIRST) return

        val point = cell.getCenter()

        curPlayer.move(IntPoint(map.deConvertX(point.x), map.deConvertY(point.y)))

        gameMode = GameMode.FIRST
        nextPlayer()
        //map.onClick(cell)
    }

    fun onDrag(cell: GameCell, x: Float, y: Float) {
        if (curPlayer.isBot() || gameMode == GameMode.SECOND) return
        //TODO: Check permission

        map.onDrag(cell, x, y)
    }

    fun onPut(cell: GameCell) {
        if (curPlayer.isBot() || gameMode == GameMode.SECOND) return
        //TODO: Check permission

        map.onPut(cell)
    }

    fun afterPut() {
        //nextPlayer()
        gameMode = GameMode.SECOND
    }

    private fun nextPlayer() {
        curNumPlayer = (curNumPlayer + 1) % players.size
        curPlayer = players[curNumPlayer]

        /*if (curPlayer.isBot()) {
            var bot: Bot = curPlayer as Bot


        }*/
    }
}

private enum class GameMode {
    FIRST, SECOND
}