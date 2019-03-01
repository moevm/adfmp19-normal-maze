package ru.shabashoff.primitives

import kotlin.math.sqrt

class Point(var x: Float, var y: Float) {
    private var length = sqrt(x * x + y * y)

    override fun toString(): String {
        return "Point(x=$x, y=$y)"
    }

    fun getLength(): Float {
        return length
    }

    fun setLength(len: Float) {
        val r = length / len

        x /= r
        y /= r
        length = len
    }

    fun vectorToPoint(p: Point): Point {
        return Point(p.x - x, p.y - y)
    }
}