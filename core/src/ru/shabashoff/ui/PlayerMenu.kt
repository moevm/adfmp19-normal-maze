package ru.shabashoff.ui

import com.badlogic.gdx.graphics.g2d.Sprite
import ru.shabashoff.game.Gift
import ru.shabashoff.game.GiftType
import ru.shabashoff.primitives.Point
import ru.shabashoff.primitives.RigidSprite
import ru.shabashoff.ui.elements.TextLabel

class PlayerMenu(gft: GiftType, playerIcon: Sprite, name: String, point: Point) {

    private var score: Int = 0


    init {
        val playerName = TextLabel(point.x, point.y, "Name: $name")
        val playerPoints = TextLabel(point.x, point.y - 0.05f, "Score: $score")
        val userIcon = RigidSprite(playerIcon)
        userIcon.setPosition(UiUtils.calcX(point.x, 0f), UiUtils.calcY(point.y + 0.05f, 0f))

        val giftIcon = RigidSprite(Gift(gft).sprite)
        giftIcon.setPosition(UiUtils.calcX(point.x, 0f), UiUtils.calcY(point.y - 0.15f, 0f))
    }


}