package com.coding.tasks.gomoku

data class Board(
        val data: List<List<Char>>,
        val length: Int,
        val emptyChar: Char = '.'
) {
    operator fun get(point: Point): Char = data[point.row][point.col]

    fun Point.inBoard(): Boolean = row < data.size
            && row >= 0
            && col < data.size
            && col >= 0
}

data class Point(val row: Int, val col: Int)

sealed class Direction {
    object Right : Direction()
    object RightDown : Direction()
    object Down : Direction()
    object LeftDown : Direction()

    companion object {
        val directions: List<Direction>
            get() = Direction::class.sealedSubclasses.mapNotNull { it.objectInstance }
    }
}