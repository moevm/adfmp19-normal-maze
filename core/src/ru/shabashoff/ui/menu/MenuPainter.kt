package ru.shabashoff.ui.menu

import ru.shabashoff.ui.menu.game.GameWithBots
import ru.shabashoff.ui.menu.game.MenuInterface
import ru.shabashoff.ui.menu.main.*
import ru.shabashoff.ui.menu.popup.*

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

    fun goToRule(){
        popupMenu = PopUpRule()
    }

    fun statistic() {
        if (popupMenu != null) return

        dispose()

        curMenu = StatisticMenuAbstract()
    }

    fun goToStatistic(){
        popupMenu = PopUpStatistic()
    }

    fun onClickSetting() {
        if (popupMenu != null) return

        popupMenu = PopUpSettings()
    }

    fun onClickPause() {
        if (popupMenu != null) return
        popupMenu = PopUpPause()

        println("Show pause")
    }

    fun closePopup() {
        popupMenu?.dispose()
        popupMenu = null
    }

    fun chooseGame() {
        if (popupMenu != null) return

        dispose()
        curMenu = ChooseGameMenu()
    }

    fun chooseName(){
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
        popupMenu?.dispose()
        popupMenu = null
        curMenu.dispose()
    }
}