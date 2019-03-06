package ru.shabashoff.ui.menu

import ru.shabashoff.ui.UiUtils
import ru.shabashoff.ui.buttons.DefaultTextButton

class MainMenu : MenuInterface() {

    private val game: DefaultTextButton = DefaultTextButton(0.5f, 0.60f, 0.2f, 0.1f, "Game") { UiUtils.menuPainter?.testGame() }
    private val rules: DefaultTextButton = DefaultTextButton(0.5f, 0.4f, 0.2f, 0.1f, "Rules") { UiUtils.menuPainter?.rules() }

    override fun dispose() {
        game.remove()
        rules.remove()
    }
}