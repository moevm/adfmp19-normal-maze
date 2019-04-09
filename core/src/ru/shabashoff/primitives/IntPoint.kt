package ru.shabashoff.primitives

class IntPoint(var x: Int, var y: Int) {

    fun add(a: IntPoint): IntPoint {
        return IntPoint(x + a.x, y + a.y)
    }


    override fun toString(): String {
        return "Point(x=$x, y=$y)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as IntPoint

        if (x != other.x) return false
        if (y != other.y) return false

        return true
    }

    override fun hashCode(): Int {
        var result = x
        result = 31 * result + y
        return result
    }


}