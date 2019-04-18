package ru.shabashoff.game.players

import ru.shabashoff.game.Gift

class RealPlayer(playerInit: InitPlayer, searchingGift: Gift) : Player(playerInit, searchingGift) {

    override fun isBot(): Boolean {
        return false
    }
}