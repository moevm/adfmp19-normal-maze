package ru.shabashoff.ui.menu

import ru.shabashoff.ui.buttons.DefaultButton

class RuleMenu : MenuInterface {

    var back: DefaultButton


    constructor(mp: MenuPainter) {
        back = DefaultButton(0.5f, 0.5f, 0.2f, 0.1f, "Back") { mp.mainMenu() }
        back.create()
    }

    override fun paint() {
        back.render()
    }


    override fun dispose() {
        back.dispose()
    }
}