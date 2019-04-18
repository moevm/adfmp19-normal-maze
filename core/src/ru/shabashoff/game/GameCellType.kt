package ru.shabashoff.game

import com.badlogic.gdx.graphics.g2d.Sprite
import ru.shabashoff.ui.UiUtils

enum class GameCellType(val left: Boolean, val up: Boolean, val right: Boolean, val bottom: Boolean) {
    BL(true, false, false, true),
    BR(false, false, true, true),
    UL(true, true, false, false),
    UR(false, true, true, false),
    CROSSING(true, true, true, true),
    LR(true, false, true, false),
    UB(false, true, false, true),
    SPLIT_E(false, true, true, true),
    SPLIT_N(true, true, true, false),
    SPLIT_S(true, false, true, true),
    SPLIT_W(true, true, false, true);

    fun getNum() {
        //print(toString())
    }

    fun getSprite(): Sprite {
        return UiUtils.getSprite(toString())
    }
}