package ru.shabashoff.ui

import com.badlogic.gdx.graphics.g2d.Sprite
import ru.shabashoff.primitives.Point
import ru.shabashoff.primitives.RigidSprite
import ru.shabashoff.ui.elements.TextLabel

class PlayerMenu(val playerIcon: Sprite, name: String, point: Point) {

    private var score: Int = 0


    init {
        val playerName: TextLabel = TextLabel(point.x, point.y, "Name: $name")
        val playerPoints: TextLabel = TextLabel(point.x, point.y - 0.05f, "Score: $score")
        val icon: RigidSprite = RigidSprite(playerIcon)
        icon.setPosition(UiUtils.calcX(point.x, 0f), UiUtils.calcY(point.y + 0.05f, 0f))
    }


}