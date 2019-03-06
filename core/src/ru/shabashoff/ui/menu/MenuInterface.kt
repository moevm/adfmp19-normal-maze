package ru.shabashoff.ui.menu

import ru.shabashoff.ui.buttons.DefaultTextButton

abstract class MenuInterface {
    val settingDefaultTextButton: DefaultTextButton? = null

    constructor()

    abstract fun dispose()
}