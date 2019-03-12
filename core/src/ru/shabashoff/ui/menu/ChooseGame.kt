package ru.shabashoff.ui.menu

import ru.shabashoff.ui.UiUtils
import ru.shabashoff.ui.buttons.DefaultTextButton

class ChooseGame: SelectGameMenu() {
    private val gameWithFriend: DefaultTextButton = DefaultTextButton(0.5f, 0.60f, 0.2f, 0.1f, "Game with friends") { UiUtils.menuPainter?.mainMenu() }
    private val gameWithBot: DefaultTextButton = DefaultTextButton(0.5f, 0.30f, 0.2f, 0.1f, "Game with bot") { UiUtils.menuPainter?.mainMenu() }

    override fun dispose() {
        super.dispose()
        gameWithFriend.remove()
        gameWithBot.remove()
    }

}