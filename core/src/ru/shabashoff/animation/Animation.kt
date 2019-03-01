package ru.shabashoff.animation

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.scenes.scene2d.Actor
import ru.shabashoff.primitives.Point
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicBoolean

class Animation(private val actor: Actor) {
    private val ready: AtomicBoolean = AtomicBoolean(true)
    private val executor: ExecutorService = Executors.newSingleThreadExecutor()

    private val SLEEP_TIME: Long = 3

    fun animateMove(duration: Float, goal: Point) {
        if (!ready.get()) throw IllegalStateException("Animation service isn't ready!")

        executor.execute { executionMoveAnimation(duration, goal) }
    }

    fun animateFlashing(duration: Float, speed: Float) {
        if (!ready.get()) throw IllegalStateException("Animation service isn't ready!")

        executor.execute { executionFlashingAnimation(duration, speed) }
    }


    fun animateAppearance(duration: Float) {
        if (!ready.get()) throw IllegalStateException("Animation service isn't ready!")

        executor.execute { executionAppearanceAnimation(duration) }
    }

    private fun executionFlashingAnimation(duration: Float, speed: Float) {
        ready.set(false)
        var alpha = 1.0f
        var curDuration = 0.0f

        var goDown = true

        while (curDuration < duration) {

            actor.color = Color(1f, 1f, 1f, alpha)

            if (alpha > 1) {
                alpha -= speed
                goDown = true
            } else {
                if (alpha < 0) {
                    alpha += speed
                    goDown = false
                } else {
                    if (goDown) alpha -= speed
                    else alpha += speed
                }
            }

            curDuration += SLEEP_TIME
            Thread.sleep(SLEEP_TIME)
        }

        actor.color = Color(1f, 1f, 1f, 1.0f)

        ready.set(true)
    }

    private fun executionAppearanceAnimation(duration: Float) {
        ready.set(false)

        var alpha = 1.0f
        var curDuration = 0.0f
        val speed: Float = 1.0f / (duration / SLEEP_TIME.toFloat())

        while (curDuration < duration) {

            actor.color = Color(1f, 1f, 1f, alpha)
            alpha += speed

            curDuration += SLEEP_TIME
            Thread.sleep(SLEEP_TIME)
        }

        actor.color = Color(1f, 1f, 1f, 1.0f)

        ready.set(true)
    }


    private fun executionMoveAnimation(duration: Float, goal: Point) {
        ready.set(false)

        var curDuration = 0.0f

        val unitVector = Point(actor.x, actor.y).vectorToPoint(goal)
        val tickLength: Float = unitVector.getLength() / (duration / SLEEP_TIME.toFloat())

        unitVector.setLength(tickLength)

        while (duration > curDuration) {
            actor.moveBy(unitVector.x, unitVector.y)

            Gdx.app.graphics.requestRendering()//TODO: investigate useful of this thing

            curDuration += SLEEP_TIME
            Thread.sleep(SLEEP_TIME)
        }

        ready.set(true)
    }
}