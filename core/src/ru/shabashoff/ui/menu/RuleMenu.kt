package ru.shabashoff.ui.menu

import ru.shabashoff.ui.buttons.ButtonExample

class RuleMenu : MenuInterface {

    var back: ButtonExample


    constructor(mp: MenuPainter) {
        back = ButtonExample(0.5f, 0.5f, 0.2f, 0.1f, "Back") { mp.mainMenu() }
        back.create()
    }

    override fun paint() {
        back.render()
    }


    override fun dispose() {
        back.dispose()
    }
}