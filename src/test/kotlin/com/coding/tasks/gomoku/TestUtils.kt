package com.coding.tasks.gomoku

import java.io.File

fun readBoardsFromFile(file: String, winningLength: Int) = File::class.java.getResource(file)
        .readText()
        .split("===")
        .map { it.trim() }
        .map { it.split("\n") }
        .map { it.map { it.toCharArray().toList() } }
        .map {
            Board(it, winningLength)
        }

fun Board.pretty() =
    data.map {
        it.joinToString("")
    }.joinToString("\n")