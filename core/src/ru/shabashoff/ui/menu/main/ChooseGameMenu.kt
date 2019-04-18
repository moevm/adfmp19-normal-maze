package ru.shabashoff.ui.menu.main

import ru.shabashoff.ui.UiUtils
import ru.shabashoff.ui.elements.DefaultTextButton

class ChooseGameMenu: MainMenuAbstract() {
    private val gameWithFriend: DefaultTextButton = DefaultTextButton(0.5f, 0.70f, 0.2f, 0.1f, "Game with friends") { UiUtils.menuPainter?.chooseName() }
    private val gameWithBot: DefaultTextButton = DefaultTextButton(0.5f, 0.50f, 0.2f, 0.1f, "Game with bot") { UiUtils.menuPainter?.botGame() }

    override fun dispose() {
        super.dispose()
        gameWithFriend.remove()
        gameWithBot.remove()
    }

}