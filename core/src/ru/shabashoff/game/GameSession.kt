package ru.shabashoff.game

import ru.shabashoff.game.players.Bot
import ru.shabashoff.game.players.Player
import ru.shabashoff.game.players.RealPlayer

class GameSession {

    val map: GameMap = GameMap(4, 4, 300.0f, 300.0f, 100.0f, 100.0f)

    private lateinit var players: List<Player>
    private lateinit var curPlayer: Player

    private var curNumPlayer: Int = 0

    fun loadPlayers() {
        players = listOf(RealPlayer(0, 0), Bot(3, 3))
        curPlayer = players[0]
    }

    fun onClick(cell: GameCell) {
        //if (curPlayer.isBot()) return

        map.onClick(cell)
    }

    fun onDrag(cell: GameCell, x: Float, y: Float) {
        if (curPlayer.isBot()) return
        //TODO: Check permission

        map.onDrag(cell, x, y)
    }

    fun onPut(cell: GameCell) {
        if (curPlayer.isBot()) return
        //TODO: Check permission

        map.onPut(cell)
    }

    fun afterPut() {
        nextPlayer()
    }

    private fun nextPlayer() {
        curNumPlayer = (curNumPlayer + 1) % players.size
        curPlayer = players[curNumPlayer]

        if (curPlayer.isBot()) {
            var bot: Bot = curPlayer as Bot

            bot.move()
        }
    }
}