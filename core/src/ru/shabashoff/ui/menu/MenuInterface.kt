package ru.shabashoff.ui.menu

import ru.shabashoff.ui.buttons.DefaultButton

abstract class MenuInterface {
    val settingDefaultButton: DefaultButton? = null

    constructor()

    abstract fun paint()
    abstract fun dispose()

}