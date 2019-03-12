package ru.shabashoff.ui.menu

import ru.shabashoff.ui.menu.game.GameWithBots
import ru.shabashoff.ui.menu.game.MenuInterface
import ru.shabashoff.ui.menu.main.ChooseGameMenu
import ru.shabashoff.ui.menu.main.RuleMenuAbstract
import ru.shabashoff.ui.menu.main.StartMenuAbstract
import ru.shabashoff.ui.menu.main.StatisticMenuAbstract
import ru.shabashoff.ui.menu.popup.PopUpMenu

class MenuPainter {

    private var curMenu: MenuInterface = StartMenuAbstract()
    private var popupMenu: PopUpMenu? = null


    fun mainMenu() {
        if (popupMenu != null) return

        dispose()
        curMenu = StartMenuAbstract()
    }

    fun testGame() {
        if (popupMenu != null) return

        dispose()
        curMenu = GameWithBots()
    }

    fun rules() {
        if (popupMenu != null) return

        dispose()
        curMenu = RuleMenuAbstract()
    }

    fun statistic() {
        if (popupMenu != null) return

        dispose()
        curMenu = StatisticMenuAbstract()
    }

    fun onClickSetting() {
        if (popupMenu != null) return

        println("Show setting")
    }

    fun onClickPause() {
        if (popupMenu != null) return

        println("Show pause")
    }

    fun chooseGame() {
        if (popupMenu != null) return

        dispose()
        curMenu = ChooseGameMenu()
    }

    fun dispose() {
        curMenu.dispose()
    }
}