package ru.shabashoff.ui.menu

class MenuPainter {

    var curMenu: MenuInterface = StartMenuAbstract()

    fun mainMenu() {
        dispose()
        curMenu = StartMenuAbstract()
    }

    fun testGame() {
        dispose()
        curMenu = GameWithBots()
    }

    fun rules() {
        dispose()
        curMenu = RuleMenuAbstract()
    }

    fun statistic() {
        dispose()
        curMenu = StatisticMenuAbstract()
    }

    fun onClickSetting() {
        println("Show setting")
    }

    fun onClickPause() {
        println("Show pause")
    }

    fun chooseGame() {
        dispose()
        curMenu = ChooseGameMenuAbstract()
    }

    fun dispose() {
        curMenu.dispose()
    }
}