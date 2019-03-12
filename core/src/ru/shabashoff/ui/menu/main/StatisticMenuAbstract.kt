package ru.shabashoff.ui.menu.main

import ru.shabashoff.ui.UiUtils
import ru.shabashoff.ui.buttons.DefaultTextButton

class StatisticMenuAbstract : MainMenuAbstract() {

    var back: DefaultTextButton = DefaultTextButton(0.5f, 0.4f, 0.2f, 0.1f, "Back") { UiUtils.menuPainter?.mainMenu() }
    var statistic: DefaultTextButton = DefaultTextButton(0.5f, 0.6f, 0.5f, 0.1f, "Player statistic") { } //TODO remove button add something

    override fun dispose() {
        super.dispose()

        back.remove()
        statistic.remove()
    }
}