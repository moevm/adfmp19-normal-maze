package ru.shabashoff.ui.menu.popup

import ru.shabashoff.ui.UiUtils

class PopUpStatistic:PopUpMenu() {

    init {
        setBounds(UiUtils.calcX(0.5f, 0.6f), UiUtils.calcY(0.5f, 0.8f), UiUtils.calcWidth(0.6f), UiUtils.calcHeight(0.8f))
        print("x:$x y:$y w:$width h:$height")

        UiUtils.getStage().addActor(this)

    }

}