package ru.shabashoff.ui.menu

class MenuPainter {

    var curMenu: MenuInterface = MainMenu()
    var chMenu: SelectGameMenu = ChooseGame()

    fun mainMenu() {
        dispose()
        curMenu = MainMenu()
    }

    fun testGame() {
        dispose()
        chMenu = ChooseGame()
    }

    fun rules() {
        dispose()
        curMenu = RuleMenu()
    }

    fun statistic() {
        dispose()
        curMenu = StatisticMenu()
    }

    fun onClickSetting() {
        println("Show setting")
    }

    fun onClickPause() {
        println("Show pause")
    }

    fun chooseGame() {
        dispose()
        chMenu = GameMenu()
    }

    fun dispose() {
        curMenu.dispose()
    }
}