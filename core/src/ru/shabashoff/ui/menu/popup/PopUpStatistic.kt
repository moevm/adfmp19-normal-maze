package ru.shabashoff.ui.menu.popup

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.scenes.scene2d.ui.TextField
import ru.shabashoff.statistic.StatisticService
import ru.shabashoff.ui.UiUtils
import ru.shabashoff.ui.elements.TextLabel

class PopUpStatistic:PopUpMenu() {

    init {
        setBounds(UiUtils.calcX(0.5f, 0.6f), UiUtils.calcY(0.5f, 0.8f), UiUtils.calcWidth(0.6f), UiUtils.calcHeight(0.8f))
        print("x:$x y:$y w:$width h:$height")

        UiUtils.getStage().addActor(this)
    }
    private var labels: MutableList<TextLabel> = ArrayList()
    private var tField: TextField
    private val head: TextLabel = TextLabel(0.35f, 0.75f,"PLAYER                    SCORE", Color.BLACK )

    init {

        val textFieldStyle = TextField.TextFieldStyle()
        textFieldStyle.font = BitmapFont()
        textFieldStyle.fontColor = Color.WHITE
        tField = TextField("", textFieldStyle)
        tField.setBounds(10f, 10f, 100f, 100f)
        UiUtils.getStage().addActor(tField)


        for ((i, player) in StatisticService.players.withIndex()) {
            labels.add(TextLabel(0.35f, 0.6f - (i * 0.05f), "${player.name}                      ${player.score}", Color.GRAY))
        }

    }

    override fun dispose() {
        super.dispose()
        head.remove()
        labels.forEach { a->a.remove()}

    }

}