package ru.shabashoff.ui.menu

import ru.shabashoff.ui.buttons.DefaultButton

class MainMenu : MenuInterface {

    private val game: DefaultButton
    private val rules: DefaultButton

    constructor(mp: MenuPainter) {
        game = DefaultButton(0.5f, 0.60f, 0.2f, 0.1f, "Game") { mp.testGame() }
        rules = DefaultButton(0.5f, 0.4f, 0.2f, 0.1f, "Rules") { mp.rules() }

        rules.create()
        game.create()

    }

    override fun paint() {
        game.render()
        rules.render()
    }

    override fun dispose() {
        game.dispose()
        rules.dispose()
    }
}