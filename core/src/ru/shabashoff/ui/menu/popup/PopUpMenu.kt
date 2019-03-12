package ru.shabashoff.ui.menu.popup

import ru.shabashoff.primitives.RigidSprite
import ru.shabashoff.ui.UiUtils
import ru.shabashoff.ui.buttons.DefaultSkinButton

class PopUpMenu : RigidSprite(UiUtils.getIconSprite("BUTTON")) {

    private val closeButton: DefaultSkinButton

    init {
        setBounds(UiUtils.calcX(0.5f, 0.6f), UiUtils.calcY(0.5f, 0.8f), UiUtils.calcWidth(0.6f), UiUtils.calcHeight(0.8f))
        print("x:$x y:$y w:$width h:$height")

        UiUtils.getStage().addActor(this)

        closeButton = DefaultSkinButton(0.7f, 0.7f, 0.07f, 0.07f, UiUtils.getIconSprite("PAUSE")) { UiUtils.menuPainter?.closePopup() }

    }

    fun dispose() {
        closeButton.remove()
        remove()
    }
}

