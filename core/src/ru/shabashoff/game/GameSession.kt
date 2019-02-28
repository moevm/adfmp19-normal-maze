package ru.shabashoff.game

class GameSession {
    private val players: List<Player> = ArrayList()
    private val map: GameMap = GameMap(4, 4, 300.0f, 300.0f, 100.0f, 100.0f)

    fun onDrag(cell: GameCell) {
        //TODO: Check permission

        map.onDrag(cell)
    }

    fun onPut(cell: GameCell) {
        //TODO: Check permission

        map.onPut(cell)
    }
}