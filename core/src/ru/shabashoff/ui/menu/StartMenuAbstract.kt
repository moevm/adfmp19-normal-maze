package ru.shabashoff.ui.menu

import ru.shabashoff.ui.UiUtils
import ru.shabashoff.ui.buttons.DefaultSkinButton
import ru.shabashoff.ui.buttons.DefaultTextButton

class StartMenuAbstract: MainMenuAbstract() {
    private val settingButton: DefaultSkinButton = DefaultSkinButton(0.9f, 0.9f, 0.07f, 0.07f, UiUtils.getIconSprite("SETTINGS")) { UiUtils.menuPainter?.onClickSetting() }

    private val game: DefaultTextButton = DefaultTextButton(0.5f, 0.60f, 0.2f, 0.1f, "Game") { UiUtils.menuPainter?.chooseGame() }
    private val rules: DefaultTextButton = DefaultTextButton(0.5f, 0.4f, 0.2f, 0.1f, "Rules") { UiUtils.menuPainter?.rules() }
    private val statistic: DefaultTextButton = DefaultTextButton(0.5f, 0.2f, 0.2f, 0.1f, "Statistic") { UiUtils.menuPainter?.statistic() }
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