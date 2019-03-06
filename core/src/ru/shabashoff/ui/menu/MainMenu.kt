package ru.shabashoff.ui.menu

import ru.shabashoff.ui.buttons.DefaultTextButton

class MainMenu(mp: MenuPainter) : MenuInterface() {

    private val game: DefaultTextButton = DefaultTextButton(0.5f, 0.60f, 0.2f, 0.1f, "Game") { mp.testGame() }
    private val rules: DefaultTextButton = DefaultTextButton(0.5f, 0.4f, 0.2f, 0.1f, "Rules") { mp.rules() }

    override fun dispose() {
        game.remove()
        rules.remove()
    }
}