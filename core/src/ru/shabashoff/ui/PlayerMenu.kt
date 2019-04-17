package ru.shabashoff.ui

import com.badlogic.gdx.graphics.g2d.Sprite
import ru.shabashoff.game.Gift
import ru.shabashoff.game.GiftType
import ru.shabashoff.primitives.Point
import ru.shabashoff.primitives.RigidSprite
import ru.shabashoff.ui.elements.TextLabel
import ru.shabashoff.ui.menu.game.MenuInterface

class PlayerMenu(gft: Gift, playerIcon: Sprite, name: String, point: Point) : MenuInterface {

    val playerName = TextLabel(point.x, point.y, "Name: $name")
    val playerScore = TextLabel(point.x, point.y - 0.05f, "Score: 0")
    val userIcon = RigidSprite(playerIcon)
    val giftIcon = RigidSprite(Sprite(gft.sprite))

    init {
        userIcon.setPosition(UiUtils.calcX(point.x, 0f), UiUtils.calcY(point.y + 0.05f, 0f))
        giftIcon.setPosition(UiUtils.calcX(point.x, 0f), UiUtils.calcY(point.y - 0.15f, 0f))
    }

    fun newScore(score: Int) {
        playerScore.setText("Score: $score")
    }

    fun changeGift(sprite: Sprite) {
        giftIcon.sprite = sprite
    }

    override fun dispose() {
        playerName.remove()
        playerScore.remove()
        userIcon.remove()
        giftIcon.remove()
    }
}