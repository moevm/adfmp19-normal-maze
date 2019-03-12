package ru.shabashoff.ui.menu

import ru.shabashoff.ui.UiUtils
import ru.shabashoff.ui.buttons.DefaultTextButton

class MainMenu : MenuInterface() {

    private val game: DefaultTextButton = DefaultTextButton(0.5f, 0.60f, 0.2f, 0.1f, "Game") { UiUtils.menuPainter?.chooseGame() }
    private val rules: DefaultTextButton = DefaultTextButton(0.5f, 0.4f, 0.2f, 0.1f, "Rules") { UiUtils.menuPainter?.rules() }
    private val statistic: DefaultTextButton = DefaultTextButton(0.5f, 0.2f, 0.2f, 0.1f, "Statistic") { UiUtils.menuPainter?.statistic() }


    override fun dispose() {
        super.dispose()

        game.remove()
        rules.remove()
        statistic.remove()
    }
}