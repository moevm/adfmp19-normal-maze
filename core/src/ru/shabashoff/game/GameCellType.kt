package ru.shabashoff.game

import com.badlogic.gdx.graphics.g2d.Sprite
import ru.shabashoff.ui.UiUtils

enum class GameCellType(val left: Int, val up: Int, val right: Int, val bottom: Int) {
    BL(1, 0, 0, 1),
    BR(0, 0, 1, 1),
    UL(1, 1, 0, 0),
    UR(0, 1, 1, 0),
    CROSSING(1, 1, 1, 1),
    LR(1, 0, 1, 0),
    UB(0, 1, 0, 1),
    SPLIT_E(0, 1, 1, 1),
    SPLIT_N(1, 1, 1, 0),
    SPLIT_S(1, 0, 1, 1),
    SPLIT_W(1, 1, 0, 1);

    fun getNum() {
        print(toString())
    }

    fun getSprite(): Sprite {
        return UiUtils.getRouteSprite(toString())
    }
}