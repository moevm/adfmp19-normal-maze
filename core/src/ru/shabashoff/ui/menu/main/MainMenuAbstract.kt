package ru.shabashoff.ui.menu.main

import ru.shabashoff.ui.UiUtils
import ru.shabashoff.ui.elements.DefaultSkinButton
import ru.shabashoff.ui.menu.game.MenuInterface

open class MainMenuAbstract : MenuInterface {
    private val settingButton: DefaultSkinButton = DefaultSkinButton(0.9f, 0.9f, 0.07f, 0.07f, UiUtils.getSprite("PAUSE")) { UiUtils.menuPainter?.onClickSetting() }


    init {
        settingButton.makeSquare()
    }

    override fun dispose() {
        settingButton.remove()
    }
}