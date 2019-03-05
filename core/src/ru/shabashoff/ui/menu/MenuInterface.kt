package ru.shabashoff.ui.menu

import ru.shabashoff.ui.buttons.ButtonExample

abstract class MenuInterface {
    val settingButton: ButtonExample? = null

    constructor()

    abstract fun paint()
    abstract fun dispose()

}