package ru.shabashoff.ui.menu

import ru.shabashoff.ui.menu.game.GameWithBots
import ru.shabashoff.ui.menu.game.GameWithPlayers
import ru.shabashoff.ui.menu.game.MenuInterface
import ru.shabashoff.ui.menu.main.*
import ru.shabashoff.ui.menu.popup.*
import java.util.*

class MenuPainter {

    private var curMenu: MenuInterface = StartMenu()
    private var popupMenu: Stack<PopUpMenu> = Stack()


    fun mainMenu() {
        if (popupMenu.isNotEmpty()) return

        dispose()
        curMenu = StartMenu()
    }

    fun botGame() {
        if (popupMenu.isNotEmpty()) return

        dispose()
        curMenu = GameWithBots()
    }

    fun playersGame() {
        if (popupMenu.isNotEmpty()) return

        dispose()
        curMenu = GameWithPlayers((curMenu as ChooseName).getNames())
    }

    fun rules() {
        if (popupMenu.isNotEmpty()) return

        dispose()
        curMenu = RuleMenu()

    }

    fun goToRule() {
        popupMenu.push(PopUpRule())
    }

    fun statistic() {
        if (popupMenu.isNotEmpty()) return

        dispose()

        curMenu = StatisticMenu()
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
        curMenu = StartMenu()
    }

    fun dispose() {
        popupMenu.forEach { p -> p.dispose() }
        popupMenu.clear()
        curMenu.dispose()
    }
}