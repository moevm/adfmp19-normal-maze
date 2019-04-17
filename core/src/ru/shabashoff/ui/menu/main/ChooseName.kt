package ru.shabashoff.ui.menu.main

import com.sun.org.apache.xerces.internal.impl.xs.opti.DefaultText
import ru.shabashoff.ui.UiUtils
import ru.shabashoff.ui.elements.DefaultTextButton
import ru.shabashoff.ui.elements.TextEdit
import ru.shabashoff.ui.elements.TextLabel

class ChooseName:MainMenuAbstract() {
    private val player1_text:TextLabel = TextLabel(0.2f,0.58f,"player1")
    private val player2_text:TextLabel = TextLabel(0.550f,0.58f,"player2")
    private val player3_text:TextLabel = TextLabel(0.20f,0.38f,"player3")
    private val player4_text:TextLabel = TextLabel(0.55f,0.38f,"player4")

    private val player1:TextEdit = TextEdit(0.4f, 0.6f, 0.2f, 0.1f, "player1")
    private val player2:TextEdit = TextEdit(0.75f, 0.6f, 0.2f, 0.1f, "player2")
    private val player3:TextEdit = TextEdit(0.4f, 0.4f, 0.2f, 0.1f, "player3")
    private val player4:TextEdit = TextEdit(0.75f, 0.4f, 0.2f, 0.1f, "player4")

    private val goToPlay: DefaultTextButton = DefaultTextButton(0.7f, 0.2f, 0.2f, 0.1f, "Gooo!") { UiUtils.menuPainter?.testGame() }

    override fun dispose() {
        super.dispose()
        player1_text.remove()
        player2_text.remove()
        player3_text.remove()
        player4_text.remove()
        player1.remove()
        player2.remove()
        player3.remove()
        player4.remove()
        goToPlay.remove()
    }
}