package ru.shabashoff.ui.menu.main

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.TextField
import ru.shabashoff.statistic.StatisticService
import ru.shabashoff.ui.UiUtils
import ru.shabashoff.ui.elements.DefaultSkinButton
import ru.shabashoff.ui.elements.DefaultTextButton
import ru.shabashoff.ui.elements.TextLabel

class StatisticMenu : MainMenuAbstract() {

    private var back: DefaultTextButton = DefaultTextButton(0.5f, 0.2f, 0.4f, 0.1f, "Back") { UiUtils.menuPainter?.mainMenu() }
    private var statistic: DefaultSkinButton = DefaultSkinButton(0.5f, 0.6f, 0.6f, 0.5f, UiUtils.getSprite("PANEL")) { } //TODO remove button add something
    private var labels: MutableList<TextLabel> = ArrayList()
    private var tField: TextField
    private val head:TextLabel = TextLabel(0.35f, 0.75f,"PLAYER                    SCORE", Color.BLACK )

    init {

        val textFieldStyle = TextField.TextFieldStyle()
        textFieldStyle.font = BitmapFont()
        textFieldStyle.fontColor = Color.WHITE
        tField = TextField("", textFieldStyle)
        tField.setBounds(10f, 10f, 100f, 100f)
        UiUtils.getStage().addActor(tField)


        for ((i, player) in StatisticService.players.withIndex()) {
            labels.add(TextLabel(0.35f, 0.7f - (i * 0.05f), "${player.name}                      ${player.score}", Color.GRAY))
        }

    }

    override fun dispose() {
        super.dispose()
        head.remove()
        labels.forEach { a->a.remove()}
        back.remove()
        statistic.remove()
    }
}