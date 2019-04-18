package ru.shabashoff.ui.menu.main

import com.badlogic.gdx.graphics.Color
import ru.shabashoff.ui.UiUtils
import ru.shabashoff.ui.elements.DefaultTextButton
import ru.shabashoff.ui.elements.TextEdit
import ru.shabashoff.ui.elements.TextLabel

class ChooseName : MainMenuAbstract() {
    private val playerText1: TextLabel = TextLabel(0.15f, 0.58f, "player1", Color.WHITE)
    private val playerText2: TextLabel = TextLabel(0.50f, 0.58f, "player2", Color.WHITE)
    private val playerText3: TextLabel = TextLabel(0.15f, 0.38f, "player3", Color.WHITE)
    private val playerText4: TextLabel = TextLabel(0.5f, 0.38f, "player4", Color.WHITE)

    private val player1: TextEdit = TextEdit(0.4f, 0.6f, 0.2f, 0.1f, "PLAYER1")
    private val player2: TextEdit = TextEdit(0.75f, 0.6f, 0.2f, 0.1f, "PLAYER2")
    private val player3: TextEdit = TextEdit(0.4f, 0.4f, 0.2f, 0.1f, "PLAYER3")
    private val player4: TextEdit = TextEdit(0.75f, 0.4f, 0.2f, 0.1f, "PLAYER4")

    private val goToPlay: DefaultTextButton = DefaultTextButton(0.7f, 0.2f, 0.2f, 0.1f, "Gooo!") { UiUtils.menuPainter?.playersGame() }
    init {
        playerText1.setFontScale(1.5f)
        playerText2.setFontScale(1.5f)
        playerText3.setFontScale(1.5f)
        playerText4.setFontScale(1.5f)


    }

    fun getNames(): List<String> {
        return arrayListOf<String>(player1.text, player2.text, player3.text, player4.text)
        println("player1.text, player2.text, player3.text, player4.text")
    }

    override fun dispose() {
        super.dispose()
        playerText1.remove()
        playerText2.remove()
        playerText3.remove()
        playerText4.remove()
        player1.remove()
        player2.remove()
        player3.remove()
        player4.remove()
        goToPlay.remove()
    }
}