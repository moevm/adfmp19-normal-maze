package ru.shabashoff.ui

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import ru.shabashoff.ui.menu.MenuPainter
import com.badlogic.gdx.Gdx.files
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator


object UiUtils {

    private val textures: Skin = Skin()

    private var width: Float = 0.0f
    private var height: Float = 0.0f

    lateinit var st: TextButton.TextButtonStyle

    var menuPainter: MenuPainter? = null

    fun init() {
        this.width = Gdx.graphics.width.toFloat()
        this.height = Gdx.graphics.height.toFloat()

        textures.addRegions(TextureAtlas(Gdx.files.internal("sprites.atlas")))

        st = TextButton.TextButtonStyle()


        val fnt = BitmapFont()
        val generator = FreeTypeFontGenerator(Gdx.files.internal("wt.ttf"))

        var prm = FreeTypeFontGenerator.FreeTypeFontParameter()

        prm.size = (prm.size * Gdx.graphics.density * 1.2).toInt()
        st.font = generator.generateFont(prm)
        st.up = textures.getDrawable("BUTTON")
        st.down = textures.getDrawable("BUTTON_PRESSED")
    }

    fun calcX(x: Float, w: Float): Float {
        return calcWidth(x - (w / 2.0f))
    }

    fun calcY(y: Float, h: Float): Float {
        return calcHeight(y - (h / 2.0f))
    }

    fun calcWidth(wdt: Float): Float {
        return wdt * width
    }

    fun calcHeight(hgt: Float): Float {
        return hgt * height
    }

    fun getStage(): Stage {
        return Gdx.input.inputProcessor as Stage
    }

    fun getSprite(name: String): Sprite {
        return Sprite(textures.getSprite(name))
    }

    fun setPercentBounds(x: Float, y: Float, w: Float, h: Float, actor: Actor) {
        actor.setBounds(calcX(x, w), calcY(y, h), calcWidth(w), calcHeight(h))
    }

    fun setPercentPosition(x: Float, y: Float, w: Float, h: Float, actor: Actor) {
        actor.setPosition(calcX(x, w), calcY(y, h))
    }
}