package ru.shabashoff.ui

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Pixmap
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Button
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.utils.Drawable

object UiUtils {

    private var width: Float = 0.0f
    private var height: Float = 0.0f

    lateinit var btnExampleStyle: TextButton.TextButtonStyle

    private val routesSkin: Skin = Skin()


    fun init() {
        this.width = Gdx.graphics.width.toFloat()
        this.height = Gdx.graphics.height.toFloat()

        val routesTextureAtlas = TextureAtlas(Gdx.files.internal("routes/routes.atlas"))
        routesSkin.addRegions(routesTextureAtlas)

        val buttonAtlasExample = TextureAtlas(Gdx.files.internal("btns/unnamed.atlas"))
        val btnSkinExample = Skin()
        val buttonExampleFont = BitmapFont()
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

    fun getRouteSprite(name: String): Sprite {
        return Sprite(routesSkin.getSprite(name))
    }

    fun getStage(): Stage {
        return Gdx.input.inputProcessor as Stage
    }
}