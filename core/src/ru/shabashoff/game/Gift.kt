package ru.shabashoff.game

import com.badlogic.gdx.graphics.g2d.Sprite
import ru.shabashoff.primitives.IntPoint
import ru.shabashoff.ui.UiUtils

class Gift(var point: IntPoint, val type: GiftType) {
    val sprite: Sprite = UiUtils.getIconSprite(type.toString())

}

enum class GiftType {
    CLOSE, SETTINGS
}