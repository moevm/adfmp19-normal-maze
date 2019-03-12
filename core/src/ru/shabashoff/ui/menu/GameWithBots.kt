package ru.shabashoff.ui.menu

import ru.shabashoff.game.GameSession
import ru.shabashoff.game.GameUtils

class GameWithBots : GameMenuAbstract() {

    init {
        GameUtils.curGameSession = GameSession()
        GameUtils.curGameSession!!.loadPlayers()
    }
}
