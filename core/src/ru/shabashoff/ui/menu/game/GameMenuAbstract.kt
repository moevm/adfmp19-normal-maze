package ru.shabashoff.ui.menu.game

import ru.shabashoff.ui.UiUtils
import ru.shabashoff.ui.elements.DefaultSkinButton

open class GameMenuAbstract : MenuInterface {
    private val pauseButton: DefaultSkinButton = DefaultSkinButton(0.9f, 0.9f, 0.07f, 0.07f, UiUtils.getSprite("PAUSE")) { UiUtils.menuPainter?.onClickPause() }

    init {
        pauseButton.makeSquare()
    }

    override fun dispose() {
        pauseButton.remove()
    }
}