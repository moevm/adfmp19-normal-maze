package ru.shabashoff.ui.menu.main

import com.badlogic.gdx.graphics.Color
import ru.shabashoff.ui.UiUtils
import ru.shabashoff.ui.elements.DefaultTextButton
import ru.shabashoff.ui.elements.TextLabel

class MenuEnd: MainMenuAbstract() {
    private val exitToMainMenu: DefaultTextButton = DefaultTextButton(0.5f, 0.25f, 0.4f, 0.1f, "Exit to Main Menu") { UiUtils.menuPainter?.exitToMainMenu() }
    private val rules: TextLabel = TextLabel(0.25f,0.45f, "", Color.BLACK)


    override fun dispose() {
        super.dispose()
        rules.remove()
        exitToMainMenu.remove()
    }
}