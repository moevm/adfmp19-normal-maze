package ru.shabashoff.primitives

class MoveLine(val line: Int, val type: LineType, val moveTo: MoveTo)

enum class MoveTo {
    UP, DOWN, LEFT, RIGHT
}

enum class LineType {
    X, Y
}