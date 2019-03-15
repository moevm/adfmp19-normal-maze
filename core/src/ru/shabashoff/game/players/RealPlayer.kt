package ru.shabashoff.game.players

import ru.shabashoff.primitives.IntPoint

class RealPlayer(curPoint:IntPoint) : Player(curPoint) {



    override fun isBot(): Boolean {
        return false
    }
}