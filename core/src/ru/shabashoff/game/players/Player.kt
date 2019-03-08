package ru.shabashoff.game.players

import com.badlogic.gdx.graphics.g2d.Sprite
import ru.shabashoff.game.GameMap
import ru.shabashoff.game.GameUtils
import ru.shabashoff.ui.UiUtils

abstract class Player(var x: Int, var y: Int) {//TODO extend Actor

    private val sprite: Sprite = UiUtils.getIconSprite("PAUSE")

    private val map: GameMap = GameUtils.curGameSession!!.map


    init {
        sprite.setBounds(map.convertX(x), map.convertY(y), 50f, 50f)



        UiUtils.addSprite(sprite)
    }

    abstract fun move()
    abstract fun isBot(): Boolean

}