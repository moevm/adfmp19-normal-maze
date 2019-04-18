package ru.shabashoff.ui.menu.game

import ru.shabashoff.game.GameSession
import ru.shabashoff.game.GameUtils
import ru.shabashoff.game.players.InitPlayer
import ru.shabashoff.game.players.PlayerMenuPosition
import ru.shabashoff.game.players.PlayerType
import ru.shabashoff.game.players.StartPosition

class GameWithBots : GameMenuAbstract() {

    init {
        GameUtils.curGameSession = GameSession(listOf(
                InitPlayer("You", PlayerType.PLAYER, PlayerMenuPosition.LEFT, StartPosition.LEFT_BOTTOM),
                InitPlayer("Bot", PlayerType.BOT, PlayerMenuPosition.RIGHT, StartPosition.RIGHT_TOP)
        ))
        GameUtils.curGameSession!!.loadPlayers()
    }


    override fun dispose() {
        GameUtils.curGameSession!!.dispose()

    }
}
