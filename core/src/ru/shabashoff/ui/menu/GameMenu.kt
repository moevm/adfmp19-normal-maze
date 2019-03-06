package ru.shabashoff.ui.menu

import ru.shabashoff.game.GameSession
import ru.shabashoff.game.GameUtils

class GameMenu : MenuInterface() {

    init {
        GameUtils.curGameSession = GameSession()
    }


    override fun dispose() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
