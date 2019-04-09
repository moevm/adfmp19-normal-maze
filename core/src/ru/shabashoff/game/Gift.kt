package ru.shabashoff.game

import com.badlogic.gdx.graphics.g2d.Sprite
import ru.shabashoff.ui.UiUtils

class Gift(val type: GiftType) {
    val sprite: Sprite = UiUtils.getIconSprite(type.path)
}

enum class GiftType(val path: String) {
    STAR("CLOSE"), KEY("SETTINGS")
}