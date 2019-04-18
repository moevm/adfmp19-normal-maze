package ru.shabashoff.ui.menu.main

import com.badlogic.gdx.graphics.Color
import com.sun.org.apache.xerces.internal.impl.xs.opti.DefaultText
import ru.shabashoff.ui.UiUtils
import ru.shabashoff.ui.elements.DefaultSkinButton
import ru.shabashoff.ui.elements.DefaultTextButton
import ru.shabashoff.ui.elements.TextLabel

class RuleMenu : MainMenuAbstract() {


    var ruleMenu: DefaultSkinButton = DefaultSkinButton(0.5f, 0.6f, 0.6f, 0.5f, UiUtils.getSprite("PANEL")) { } //TODO remove button add something
    var back: DefaultTextButton = DefaultTextButton(0.5f, 0.2f, 0.4f, 0.1f, "Back") { UiUtils.menuPainter?.mainMenu() }
    private val rules: TextLabel = TextLabel(0.25f,0.52f, "Purpose: to collect a maximum of secret cards.\n" +
    "How: in his turn, the player inserts a roll-up card on \none of the sides of the field,"+
    "while moving \na number. The dropped card remains until the \nnext turn. Next, the player "+
    "makes \na move his chip. He can move the chip to any point \nin the maze that is associated "+
    "with the \nstarting point of a continuous passage. After \nthat, the move goes to the next player.", Color.GRAY)

    override fun dispose() {
        super.dispose()
        rules.remove()
        ruleMenu.remove()
        back.remove()
    }
}