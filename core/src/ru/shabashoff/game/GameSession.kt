package ru.shabashoff.game

class GameSession {
    val players: List<Player> = ArrayList()
    val map: GameMap = GameMap(5, 5, 0.0f, 0.0f, 0.0f, 0.0f)
}