package ru.shabashoff.ui.menu.main

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.scenes.scene2d.ui.TextField
import ru.shabashoff.ui.UiUtils
import ru.shabashoff.ui.elements.DefaultSkinButton
import ru.shabashoff.ui.elements.DefaultTextButton

class StatisticMenu : MainMenuAbstract() {

    private var back: DefaultTextButton = DefaultTextButton(0.5f, 0.2f, 0.2f, 0.1f, "Back") { UiUtils.menuPainter?.mainMenu() }
    private var statistic: DefaultSkinButton = DefaultSkinButton(0.5f, 0.6f, 0.6f, 0.5f, UiUtils.getSprite("PANEL")) { } //TODO remove button add something
//    private var nameLabel: TextLabel = TextLabel(0.2f, 0.2f,  "Anya durak")

    private var tField: TextField

    init {

        val textFieldStyle = TextField.TextFieldStyle()
        textFieldStyle.font = BitmapFont()
        textFieldStyle.fontColor = Color.WHITE
        tField = TextField("anya durak", textFieldStyle)
        tField.setBounds(10f, 10f, 100f, 100f)
        UiUtils.getStage().addActor(tField)
    }

    override fun dispose() {
        super.dispose()

//        nameLabel.remove()
        back.remove()
        statistic.remove()
    }
}