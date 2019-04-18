package ru.shabashoff.ui.menu.main

import com.badlogic.gdx.graphics.Color
import ru.shabashoff.ui.UiUtils
import ru.shabashoff.ui.elements.DefaultTextButton
import ru.shabashoff.ui.elements.TextLabel

class MenuEnd(var playerName: String, var count: Int) : MainMenuAbstract() {
    private val exitToMainMenu: DefaultTextButton = DefaultTextButton(0.5f, 0.25f, 0.4f, 0.1f, "Exit to Main Menu") { UiUtils.menuPainter?.exitToMainMenu() }
    private val namePlayer: TextLabel = TextLabel(0.45f, 0.5f, "${playerName} WIN!", Color.WHITE)
    private val countPlayer: TextLabel = TextLabel(0.45f, 0.4f, "SCORE: ${count}", Color.WHITE)
    init {
        namePlayer.setFontScale(2.5f)
        countPlayer.setFontScale(2.5f)
    }



    override fun dispose() {
        super.dispose()
        namePlayer.remove()
        countPlayer.remove()
        exitToMainMenu.remove()
    }
}