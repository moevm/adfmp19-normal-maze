package ru.shabashoff.ui.menu.game

import ru.shabashoff.game.GameSession
import ru.shabashoff.game.GameUtils

class GameWithBots : GameMenuAbstract() {

    init {
        GameUtils.curGameSession = GameSession()
        GameUtils.curGameSession!!.loadPlayers()
    }


    override fun dispose(){
        GameUtils.curGameSession!!.dispose()

    }
}
