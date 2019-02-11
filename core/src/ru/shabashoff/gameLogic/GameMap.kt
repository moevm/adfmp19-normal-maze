package ru.shabashoff.gameLogic

import java.util.*

class GameMap {
    val map: List<List<GameCell>> = ArrayList()

    fun getSize(): List<Int> {
        return Arrays.asList(map.size, map[0].size)
    }
}