package ru.shabashoff.game.players

import ru.shabashoff.game.Gift
import ru.shabashoff.game.GiftType
import ru.shabashoff.primitives.IntPoint

class RealPlayer(curPoint: IntPoint, searchingGift: Gift) : Player(curPoint, searchingGift) {

    override fun isBot(): Boolean {
        return false
    }
}