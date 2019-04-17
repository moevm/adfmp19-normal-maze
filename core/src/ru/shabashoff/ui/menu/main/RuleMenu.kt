package ru.shabashoff.ui.menu.main

import com.sun.org.apache.xerces.internal.impl.xs.opti.DefaultText
import ru.shabashoff.ui.UiUtils
import ru.shabashoff.ui.elements.DefaultSkinButton
import ru.shabashoff.ui.elements.DefaultTextButton
import ru.shabashoff.ui.elements.TextLabel

class RuleMenu : MainMenuAbstract() {


    var ruleMenu: DefaultSkinButton = DefaultSkinButton(0.5f, 0.6f, 0.6f, 0.5f, UiUtils.getSprite("PANEL")) { } //TODO remove button add something
    var back: DefaultTextButton = DefaultTextButton(0.5f, 0.2f, 0.2f, 0.1f, "Back") { UiUtils.menuPainter?.mainMenu() }
    private val rules: TextLabel = TextLabel(0.25f,0.38f, "The player inserts an additional card on one of the\n"+" sides of the playing field,while moving a number of cards.\n" +
            "As a result, on the opposite side. The extreme card\n" +
            "is being extended. Card dropped out of the maze\n remains lying" +
            "next to the playing field\n until the turn moves to the next player. After the\n player has changed the location of the moves\n in the maze, he makes his move his chip. He can \nmove the chip to any point in the maze \nthat is associated with the starting point of \na continuous passage. Chip can move at any \ndistance. The number of steps taken does not matter.\n" +
            "Those places in which you can insert an additional \ncard into the maze," +
            "marked by arrows at \nthe edges of the field. The card that is currently\n" +
            "superfluous, the player can insert into \nthe maze in any of these places." +
            "The player \nwho managed to open all secret cards, should \ntry as quickly as possible to return his \nchip to its starting position in the corner \nof the playing field.")

    override fun dispose() {
        super.dispose()
        rules.remove()
        ruleMenu.remove()
        back.remove()
    }
}