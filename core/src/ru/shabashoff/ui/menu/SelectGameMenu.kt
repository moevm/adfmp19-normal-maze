package ru.shabashoff.ui.menu

import ru.shabashoff.ui.UiUtils
import ru.shabashoff.ui.buttons.DefaultSkinButton

abstract class SelectGameMenu {
    private val pauseButton: DefaultSkinButton = DefaultSkinButton(0.9f, 0.9f, 0.07f, 0.07f, UiUtils.getIconSprite("PAUSE")) { UiUtils.menuPainter?.onClickPause() }

    init {
        pauseButton.makeSquare()
    }

    open fun dispose(){
        pauseButton.remove()
    }
}