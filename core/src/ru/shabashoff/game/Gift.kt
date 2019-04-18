package ru.shabashoff.game

import com.badlogic.gdx.graphics.g2d.Sprite
import ru.shabashoff.primitives.IntPoint
import ru.shabashoff.ui.UiUtils

class Gift(val type: GiftType, var point: IntPoint) {
    val sprite: Sprite = UiUtils.getSprite(type.toString())

    init {
        sprite.setSize(50f, 50f)
    }
}

enum class GiftType {
    BANK, CAKE, CANDLE, CARROT, CLOCK, CLOVER, COMPASS, COPTER, CROWN, DRUM, DUCK, GIFT, GLASS, HEMLET, HOME, KEY, LOUPE, MONEY, NLO, ORIGAMI, PRINT, SHOP, STRAWBERRY, SUN, TOY, MEDAL
}