package ru.shabashoff.ui.menu.popup

import ru.shabashoff.primitives.RigidSprite
import ru.shabashoff.ui.UiUtils
import ru.shabashoff.ui.buttons.DefaultSkinButton
import ru.shabashoff.ui.buttons.DefaultTextButton

class PopUpSettings : PopUpMenu() {

    private val sound: DefaultTextButton
    private val authorization: DefaultTextButton
    private val exitToMainMenu: DefaultTextButton

    init {
        setBounds(UiUtils.calcX(0.5f, 0.6f), UiUtils.calcY(0.5f, 0.8f), UiUtils.calcWidth(0.6f), UiUtils.calcHeight(0.8f))
        print("x:$x y:$y w:$width h:$height")

        UiUtils.getStage().addActor(this)

        sound = DefaultTextButton(0.5f, 0.5f, 0.2f, 0.1f, "Sound") { UiUtils.menuPainter?.sound() }
        exitToMainMenu = DefaultTextButton(0.5f, 0.35f, 0.2f, 0.1f, "Exit to Main Menu") { UiUtils.menuPainter?.exitToMainMenu() }
        authorization = DefaultTextButton(0.5f, 0.65f, 0.2f, 0.1f, "authorization") { UiUtils.menuPainter?.authorization() }

    }

    override fun dispose() {
        super.dispose()
        sound.remove()
        exitToMainMenu.remove()
        authorization.remove()
        remove()
    }
}

