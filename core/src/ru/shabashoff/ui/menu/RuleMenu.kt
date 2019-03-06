package ru.shabashoff.ui.menu

import ru.shabashoff.ui.UiUtils
import ru.shabashoff.ui.buttons.DefaultTextButton

class RuleMenu : MenuInterface() {

    var back: DefaultTextButton = DefaultTextButton(0.5f, 0.5f, 0.2f, 0.1f, "Back") { UiUtils.menuPainter?.mainMenu() }


    override fun dispose() {
        back.remove()
    }
}