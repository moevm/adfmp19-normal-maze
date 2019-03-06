package ru.shabashoff.ui.menu

import ru.shabashoff.ui.buttons.DefaultTextButton

class RuleMenu : MenuInterface {

    var back: DefaultTextButton


    constructor(mp: MenuPainter) {
        back = DefaultTextButton(0.5f, 0.5f, 0.2f, 0.1f, "Back") { mp.mainMenu() }
    }

    override fun dispose() {
        back.remove()
    }
}