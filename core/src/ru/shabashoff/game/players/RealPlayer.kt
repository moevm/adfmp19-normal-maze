package ru.shabashoff.game.players

class RealPlayer(x: Int, y: Int) : Player(x, y) {



    override fun isBot(): Boolean {
        return false
    }
}