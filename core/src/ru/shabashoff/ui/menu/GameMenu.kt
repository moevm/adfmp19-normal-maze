package ru.shabashoff.ui.menu

import ru.shabashoff.game.GameSession
import ru.shabashoff.game.GameUtils

class GameMenu : SelectGameMenu() {

    init {
        GameUtils.curGameSession = GameSession()
        GameUtils.curGameSession!!.loadPlayers()
    }


    override fun dispose() {
        super.dispose()

    }

}
