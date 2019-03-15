package ru.shabashoff.ui.menu

import ru.shabashoff.ui.menu.game.GameWithBots
import ru.shabashoff.ui.menu.game.MenuInterface
import ru.shabashoff.ui.menu.main.*
import ru.shabashoff.ui.menu.popup.*
import java.util.*

class MenuPainter {

    private var curMenu: MenuInterface = StartMenuAbstract()
    private var popupMenu: Stack<PopUpMenu> = Stack()


    fun mainMenu() {
        if (popupMenu.isNotEmpty()) return

        dispose()
        curMenu = StartMenuAbstract()
    }

    fun testGame() {
        if (popupMenu.isNotEmpty()) return

        dispose()
        curMenu = GameWithBots()
    }

    fun rules() {
        if (popupMenu.isNotEmpty()) return

        dispose()
        curMenu = RuleMenuAbstract()

    }

    fun goToRule() {
        popupMenu.push(PopUpRule())
    }

    fun statistic() {
        if (popupMenu.isNotEmpty()) return

        dispose()

        curMenu = StatisticMenuAbstract()
    }

    fun goToStatistic() {
        popupMenu.push(PopUpStatistic())
    }

    fun onClickSetting() {
        if (popupMenu.isNotEmpty()) return

        popupMenu.push(PopUpSettings())
    }

    fun onClickPause() {
        if (popupMenu.isNotEmpty()) return
        popupMenu.push(PopUpPause())

        println("Show pause")
    }

    fun closePopup() {
        popupMenu.pop()!!.dispose()
    }

    fun chooseGame() {
        if (popupMenu.isNotEmpty()) return

        dispose()
        curMenu = ChooseGameMenu()
    }

    fun chooseName() {
        dispose()
        curMenu = ChooseName()
    }

    fun authorization() {
        println("authorization")
    }

    fun sound() {
        println("Sound on/off")
    }

    fun exitToMainMenu() {
        dispose()
        curMenu = StartMenuAbstract()
    }

    fun dispose() {
        popupMenu.forEach { p -> p.dispose() }
        popupMenu.clear()
        curMenu.dispose()
    }
}