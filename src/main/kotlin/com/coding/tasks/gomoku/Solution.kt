package com.coding.tasks.gomoku

fun Board.winnerExists(): Boolean {
    data.forEachIndexed { rowNumber: Int, row: List<Char> ->
        row.forEachIndexed { colNumber: Int, character: Char ->
            if (character != emptyChar && checkPoint(Point(rowNumber, colNumber))) return true
        }
    }
    return false
}

private fun Board.checkPoint(point: Point): Boolean =
        Direction.directions.any { checkPointInDirection(point, it, length - 1) }


private fun Board.checkPointInDirection(point: Point, direction: Direction, n: Int): Boolean =
        if (n == 0) true
        else {
            val currentSymbol = this[point]
            val nextPoint = point.nextInDirection(direction)
            nextPoint.inBoard()
                    && currentSymbol == this[nextPoint]
                    && checkPointInDirection(nextPoint, direction, n - 1)
        }

private fun Point.nextInDirection(direction: Direction): Point =
        when (direction) {
            is Direction.Right -> Point(row, col + 1)
            Direction.RightDown -> Point(row + 1, col + 1)
            Direction.Down -> Point(row + 1, col)
            Direction.LeftDown -> Point(row + 1, col - 1)
        }