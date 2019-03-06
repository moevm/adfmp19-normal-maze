package ru.shabashoff.ui.menu

class MenuPainter {

    var curMenu: MenuInterface = MainMenu(this)

    fun mainMenu() {
        dispose()
        curMenu = MainMenu(this)
    }

    fun testGame() {
        dispose()
        curMenu = GameMenu()
    }

    fun rules() {
        dispose()
        curMenu = RuleMenu(this)
    }

    fun dispose() {
        curMenu.dispose()
    }
}