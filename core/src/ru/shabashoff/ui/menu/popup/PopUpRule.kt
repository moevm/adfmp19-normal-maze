package ru.shabashoff.ui.menu.popup

import ru.shabashoff.ui.UiUtils
import ru.shabashoff.ui.elements.TextLabel


class PopUpRule:PopUpMenu() {


    init {
        setBounds(UiUtils.calcX(0.5f, 0.6f), UiUtils.calcY(0.5f, 0.8f), UiUtils.calcWidth(0.6f), UiUtils.calcHeight(0.8f))
        print("x:$x y:$y w:$width h:$height")
        val rules = TextLabel(0.23f,0.15f, "The player inserts an additional card on one of the\n"+
                "sides of the playing field,while moving a number \nof cards." +
                "As a result, on the opposite side. The extreme \ncard" +
                "is being extended. Card dropped out \nof the maze remains lying" +
                "next to \nthe playing field until the turn \nmoves to the next player. After the"+
                "player has\nchanged the location of the moves\nin the maze, he makes his move his chip. He can \n"+
                "move the chip to any point in the maze \nthat is associated with the starting point of \n"+
                "a continuous passage. Chip can move at any \ndistance. The number of steps taken does not matter.\n" +
                "Those places in which you can insert an additional \ncard into the maze," +
                "marked by arrows at \nthe edges of the field. The card that is currently\n" +
                "superfluous, the player can insert into \nthe maze in any of these places." +
                "The player \nwho managed to open all secret cards, should \ntry as quickly as possible to return his "+
                "chip to\nits starting position in the corner of the playing field.")

        UiUtils.getStage().addActor(this)

    }
    override fun dispose() {
        super.dispose()
        remove()
    }
}