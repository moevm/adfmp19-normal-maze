package ru.shabashoff.ui.menu.popup

import ru.shabashoff.ui.UiUtils
import ru.shabashoff.ui.elements.DefaultTextButton

class PopUpPause : PopUpMenu() {

    private val exitToMainMenu: DefaultTextButton
    private val back: DefaultTextButton
    private val statistics: DefaultTextButton
    private val rule: DefaultTextButton


    init {
        setBounds(UiUtils.calcX(0.5f, 0.6f), UiUtils.calcY(0.5f, 0.8f), UiUtils.calcWidth(0.6f), UiUtils.calcHeight(0.8f))
        print("x:$x y:$y w:$width h:$height")

        UiUtils.getStage().addActor(this)
        back = DefaultTextButton(0.5f, 0.7f, 0.4f, 0.1f, "back") { UiUtils.menuPainter?.closePopup() }
        rule = DefaultTextButton(0.5f, 0.55f, 0.4f, 0.1f, "rule") { UiUtils.menuPainter?.goToRule() }
        statistics = DefaultTextButton(0.5f, 0.4f, 0.4f, 0.1f, "statistics") { UiUtils.menuPainter?.goToStatistic() }
        exitToMainMenu = DefaultTextButton(0.5f, 0.25f, 0.4f, 0.1f, "Exit to Main Menu") { UiUtils.menuPainter?.exitToMainMenu() }
    }

    override fun dispose() {
        super.dispose()
        exitToMainMenu.remove()
        back.remove()
        rule.remove()
        statistics.remove()
        remove()
    }
}