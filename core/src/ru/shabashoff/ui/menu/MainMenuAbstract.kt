package ru.shabashoff.ui.menu

import ru.shabashoff.ui.UiUtils
import ru.shabashoff.ui.buttons.DefaultSkinButton

open class MainMenuAbstract : MenuInterface {
    private val settingButton: DefaultSkinButton = DefaultSkinButton(0.9f, 0.9f, 0.07f, 0.07f, UiUtils.getIconSprite("SETTINGS")) { UiUtils.menuPainter?.onClickSetting() }


    init {
        settingButton.makeSquare()
    }

    override fun dispose() {
        super.dispose()
        settingButton.remove()
    }
}