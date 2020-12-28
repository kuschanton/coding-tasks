package com.coding.tasks.gomoku

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertFalse
import kotlin.test.assertTrue


internal class SolutionTest {

    @ParameterizedTest
    @MethodSource("withWinner")
    fun `should return true`(board: Board) {
        assertTrue(board.winnerExists(), "Winner should exist: ${board.pretty()}")
    }

    @ParameterizedTest
    @MethodSource("withoutWinner")
    fun `should return false`(board: Board) {
        assertFalse(board.winnerExists(), "Winner should NOT exist: ${board.pretty()}")
    }

    companion object {
        @JvmStatic
        private fun withWinner(): Stream<Arguments?>? = fromFile("/winnerExists.txt")
        @JvmStatic
        private fun withoutWinner(): Stream<Arguments?>? = fromFile("/winnerDoesNotExist.txt")
        private fun fromFile(name: String): Stream<Arguments?>? {
            return readBoardsFromFile(name, 3)
                    .stream()
                    .map { Arguments.of(it) }
        }
    }
}