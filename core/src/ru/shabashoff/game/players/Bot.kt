package ru.shabashoff.game.players

import ru.shabashoff.game.GameCell
import ru.shabashoff.game.GameUtils
import ru.shabashoff.primitives.IntPoint

class Bot(x: Int, y: Int) : Player(x, y) {

    override fun move() {
        var map = GameUtils.curGameSession!!.map.map



        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isBot(): Boolean {
        return true
    }

    private fun chooseMinWay(map: List<List<GameCell>>, from: IntPoint, to: IntPoint) {
        //TODO choose min way


    }

}