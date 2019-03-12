package ru.shabashoff.ui.menu

import ru.shabashoff.ui.UiUtils
import ru.shabashoff.ui.buttons.DefaultTextButton

class RuleMenu : MenuInterface {

    var ruleMenu: DefaultTextButton = DefaultTextButton(0.5f, 0.6f, 0.5f, 0.1f, "Rules menu") { } //TODO remove button add something
    var back: DefaultTextButton = DefaultTextButton(0.5f, 0.4f, 0.2f, 0.1f, "Back") { UiUtils.menuPainter?.mainMenu() }


    override fun dispose() {
        super.dispose()

        ruleMenu.remove()
        back.remove()
    }
}