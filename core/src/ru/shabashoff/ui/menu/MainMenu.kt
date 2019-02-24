package ru.shabashoff.ui.menu

import ru.shabashoff.ui.buttons.ButtonExample

class MainMenu : MenuInterface {

    private var game: ButtonExample
    private var rules: ButtonExample

    constructor(mp: MenuPainter) {
        game = ButtonExample(0.5f, 0.65f, 0.2f, 0.2f, "Game") {}
        rules = ButtonExample(0.5f, 0.35f, 0.2f, 0.2f, "Rules") { mp.rules() }

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