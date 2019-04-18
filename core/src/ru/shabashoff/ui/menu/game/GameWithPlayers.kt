package ru.shabashoff.ui.menu.game

import ru.shabashoff.game.GameSession
import ru.shabashoff.game.GameUtils
import ru.shabashoff.game.players.InitPlayer
import ru.shabashoff.game.players.PlayerMenuPosition
import ru.shabashoff.game.players.PlayerType
import ru.shabashoff.game.players.StartPosition

class GameWithPlayers(names: List<String>) : GameMenuAbstract() {

    init {
        GameUtils.curGameSession = GameSession(listOf(
                InitPlayer(names[0], PlayerType.PLAYER, PlayerMenuPosition.LEFT_TOP, StartPosition.LEFT_TOP),
                InitPlayer(names[1], PlayerType.PLAYER, PlayerMenuPosition.LEFT_BOTTOM, StartPosition.LEFT_BOTTOM),
                InitPlayer(names[2], PlayerType.PLAYER, PlayerMenuPosition.RIGHT_BOTTOM, StartPosition.RIGHT_BOTTOM),
                InitPlayer(names[3], PlayerType.PLAYER, PlayerMenuPosition.RIGHT_TOP, StartPosition.RIGHT_TOP)
        ))
        
        GameUtils.curGameSession!!.loadPlayers()
    }


    override fun dispose() {
        GameUtils.curGameSession!!.dispose()
    }
}
