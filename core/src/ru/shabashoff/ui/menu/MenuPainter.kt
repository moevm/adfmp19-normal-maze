package ru.shabashoff.ui.menu

class MenuPainter {

    var curMenu: MenuInterface = MainMenu()

    fun mainMenu() {
        dispose()
        curMenu = MainMenu()
    }

    fun testGame() {
        dispose()
        curMenu = GameMenu()
    }

    fun rules() {
        dispose()
        curMenu = RuleMenu()
    }

    fun onClickSetting() {
        println("Show setting")
    }


    fun dispose() {
        curMenu.dispose()
    }
}