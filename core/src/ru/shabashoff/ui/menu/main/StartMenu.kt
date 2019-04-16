package ru.shabashoff.ui.menu.main

import ru.shabashoff.ui.UiUtils
import ru.shabashoff.ui.elements.DefaultSkinButton
import ru.shabashoff.ui.elements.DefaultTextButton

class StartMenu : MainMenuAbstract() {

    private val settingButton: DefaultSkinButton = DefaultSkinButton(0.9f, 0.9f, 0.07f, 0.07f, UiUtils.getSprite("PAUSE")) { UiUtils.menuPainter?.onClickSetting() }

    private val game: DefaultTextButton = DefaultTextButton(0.5f, 0.70f, 0.2f, 0.1f, "Game") { UiUtils.menuPainter?.chooseGame() }
    private val rules: DefaultTextButton = DefaultTextButton(0.5f, 0.5f, 0.2f, 0.1f, "Rules") { UiUtils.menuPainter?.rules() }
    private val statistic: DefaultTextButton = DefaultTextButton(0.5f, 0.3f, 0.2f, 0.1f, "Statistic") { UiUtils.menuPainter?.statistic() }

    init {
        settingButton.makeSquare()
    }

    override fun dispose() {
        super.dispose()
        game.remove()
        rules.remove()
        statistic.remove()
    }
}