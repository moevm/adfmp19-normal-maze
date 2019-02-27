package ru.shabashoff.game

import com.badlogic.gdx.Gdx

object GameUtils {

    private var width: Float = 0.0f
    private var height: Float = 0.0f

    var curGameSession: GameSession? = null

    fun init() {
        this.width = Gdx.graphics.width.toFloat()
        this.height = Gdx.graphics.height.toFloat()
    }
}