package ru.shabashoff.ui.menu.popup

import com.badlogic.gdx.graphics.Color
import ru.shabashoff.ui.UiUtils
import ru.shabashoff.ui.elements.TextLabel
import java.awt.SystemColor.text


class PopUpRule:PopUpMenu() {

    init {
        setBounds(UiUtils.calcX(0.5f, 0.6f), UiUtils.calcY(0.5f, 0.8f), UiUtils.calcWidth
(0.6f), UiUtils.calcHeight(0.8f))
        print("x:$x y:$y w:$width h:$height")
        val text = TextLabel(0.25f,0.45f, "Purpose: to collect a maximum of secret cards.\n" +
                "How: in his turn, the player inserts a roll-up card on \none of the sides of the field," +
                "while moving \na number. The dropped card remains until the \nnext turn. Next, the player" +
                "makes \na move his chip. He can move the chip to any point \nin the maze that is associated" +
                "with the \nstarting point of a continuous passage. After \nthat, the move goes to the next player.", Color.GRAY)

        UiUtils.getStage().addActor(this)

    }
    override fun dispose() {
        super.dispose()
        //text.dispose()
        remove()
    }
}