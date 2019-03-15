package ru.shabashoff.ui.menu.main

import ru.shabashoff.ui.UiUtils
import ru.shabashoff.ui.buttons.DefaultTextButton

class ChooseName:MainMenuAbstract() {
    private val player1: DefaultTextButton = DefaultTextButton(0.25f, 0.4f, 0.2f, 0.1f, "player1") {}
    private val player2: DefaultTextButton = DefaultTextButton(0.25f, 0.6f, 0.2f, 0.1f, "player2") {}
    private val player3: DefaultTextButton = DefaultTextButton(0.75f, 0.4f, 0.2f, 0.1f, "player3") {}
    private val player4: DefaultTextButton = DefaultTextButton(0.75f, 0.6f, 0.2f, 0.1f, "player4") {}
    private val goToPlay: DefaultTextButton = DefaultTextButton(0.7f, 0.2f, 0.2f, 0.1f, "Gooo!") { UiUtils.menuPainter?.testGame() }

    override fun dispose() {
        super.dispose()
        player1.remove()
        player2.remove()
        player3.remove()
        player4.remove()
        goToPlay.remove()
    }
}