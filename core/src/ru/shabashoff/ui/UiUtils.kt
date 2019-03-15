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

object UiUtils {

    private val routesSkin: Skin = Skin()
    private val btnDefaultSkin: Skin = Skin()

    private val sprites: MutableList<Sprite> = ArrayList()

    private var width: Float = 0.0f
    private var height: Float = 0.0f

    lateinit var btnDefaultStyle: TextButton.TextButtonStyle


    var menuPainter: MenuPainter? = null


    fun init() {
        this.width = Gdx.graphics.width.toFloat()
        this.height = Gdx.graphics.height.toFloat()

        val routesTextureAtlas = TextureAtlas(Gdx.files.internal("routes.atlas"))
        routesSkin.addRegions(routesTextureAtlas)

        val buttonDefaultAtlas = TextureAtlas(Gdx.files.internal("btns.atlas"))
        btnDefaultSkin.addRegions(buttonDefaultAtlas)

        btnDefaultStyle = TextButton.TextButtonStyle()

        val buttonDefaultFont = BitmapFont()
        btnDefaultStyle.font = buttonDefaultFont
        btnDefaultStyle.up = btnDefaultSkin.getDrawable("BUTTON")
        btnDefaultStyle.down = btnDefaultSkin.getDrawable("BUTTON_PRESSED")
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

    fun getRouteSprite(name: String): Sprite {
        return Sprite(routesSkin.getSprite(name))
    }

    fun getStage(): Stage {
        return Gdx.input.inputProcessor as Stage
    }

    fun getIconSprite(name: String): Sprite {
        return Sprite(btnDefaultSkin.getSprite(name))
    }

    fun addSprite(sprite: Sprite) {
        sprites.add(sprite)
    }

    fun removeSprite(sprite: Sprite){
        sprites.remove(sprite)
    }
    fun getSprites(): List<Sprite> {
        return sprites
    }

    fun setPercentBounds(x: Float, y: Float, w: Float, h: Float, actor: Actor) {
        actor.setBounds(calcX(x, w), calcY(y, h), calcWidth(w), calcHeight(h))
    }

    fun setPercentPosition(x: Float, y: Float, w: Float, h: Float, actor: Actor) {
        actor.setPosition(calcX(x, w), calcY(y, h))
    }
}