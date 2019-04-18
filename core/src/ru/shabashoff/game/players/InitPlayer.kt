package ru.shabashoff.game.players

import ru.shabashoff.primitives.IntPoint

class InitPlayer(val name: String, val playerType: PlayerType, val playerMenuPosition: PlayerMenuPosition, val startPosition: StartPosition)

enum class PlayerType {
    BOT, PLAYER
}

enum class PlayerMenuPosition(val n: Int) {
    LEFT(0), RIGHT(1), LEFT_TOP(2), LEFT_BOTTOM(3), RIGHT_TOP(4), RIGHT_BOTTOM(5)
}

enum class StartPosition {
    LEFT_TOP, RIGHT_TOP, RIGHT_BOTTOM, LEFT_BOTTOM;

    fun getPoint(w: Int, h: Int): IntPoint {
        return when (this) {
            LEFT_TOP -> IntPoint(0, h - 1)
            RIGHT_TOP -> IntPoint(w - 1, h - 1)
            RIGHT_BOTTOM -> IntPoint(w - 1, 0)
            LEFT_BOTTOM -> IntPoint(0, 0)
        }
    }
}