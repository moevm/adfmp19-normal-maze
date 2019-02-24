package ru.shabashoff.ui

import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.TextButton

object UiUtils : Game() {

    private var width: Float = 0.0f
    private var height: Float = 0.0f

    lateinit var btnExampleStyle: TextButton.TextButtonStyle

    override fun create() {
        this.width = Gdx.graphics.width.toFloat()
        this.height = Gdx.graphics.height.toFloat()

        val buttonAtlasExample = TextureAtlas(Gdx.files.internal("btns/unnamed.atlas"))
        val buttonExampleFont = BitmapFont()

        val btnSkinExample = Skin()
        btnSkinExample.addRegions(buttonAtlasExample)

        btnExampleStyle = TextButton.TextButtonStyle()
        btnExampleStyle.font = buttonExampleFont
        btnExampleStyle.up = btnSkinExample.getDrawable("up-button")
        btnExampleStyle.down = btnSkinExample.getDrawable("down-button")
        btnExampleStyle.checked = btnSkinExample.getDrawable("checked-button")
    }

    fun getAbsoluteX(x: Float, w: Float): Float {
        return getAbsoluteWidthPoint(x - (w / 2.0f))
    }

    fun getAbsoluteY(y: Float, h: Float): Float {
        return getAbsoluteHeightPoint(y - (h / 2.0f))
    }

    fun getAbsoluteWidthPoint(wdt: Float): Float {
        return wdt * width
    }

    fun getAbsoluteHeightPoint(hgt: Float): Float {
        return hgt * height
    }
}