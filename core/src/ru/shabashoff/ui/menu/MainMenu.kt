package ru.shabashoff.ui.menu

import ru.shabashoff.ui.buttons.DefaultTextButton

class MainMenu : MenuInterface {

    private val game: DefaultTextButton
    private val rules: DefaultTextButton

    constructor(mp: MenuPainter) {
        game = DefaultTextButton(0.5f, 0.60f, 0.2f, 0.1f, "Game") { mp.testGame() }
        rules = DefaultTextButton(0.5f, 0.4f, 0.2f, 0.1f, "Rules") { mp.rules() }
    }

    override fun dispose() {
        game.remove()
        rules.remove()
    }
}