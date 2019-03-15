package ru.shabashoff.ui.menu.main

import ru.shabashoff.ui.UiUtils
import ru.shabashoff.ui.buttons.DefaultSkinButton
import ru.shabashoff.ui.menu.game.MenuInterface

open class MainMenuAbstract : MenuInterface {
    private val settingButton: DefaultSkinButton = DefaultSkinButton(0.9f, 0.9f, 0.07f, 0.07f, UiUtils.getIconSprite("SETTINGS")) { UiUtils.menuPainter?.onClickSetting() }


    init {
        settingButton.makeSquare()
    }

    override fun dispose() {
        settingButton.remove()
    }
}