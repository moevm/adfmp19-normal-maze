package ru.shabashoff.game.players

abstract class Player(var x: Int, var y: Int) {//TODO extend Actor

    abstract fun move()
    abstract fun isBot(): Boolean


}