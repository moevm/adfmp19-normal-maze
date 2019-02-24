package ru.shabashoff.ui.menu

class MenuPainter {

    var curMenu: MenuInterface = MainMenu(this)

    fun paint() {
        curMenu.paint()
    }

    fun mainMenu() {
        dispose()
        curMenu = MainMenu(this)
        paint()
    }

    fun rules() {
        dispose()
        curMenu = RuleMenu(this)
        paint()
    }

    fun dispose() {
        curMenu.dispose()
    }
}