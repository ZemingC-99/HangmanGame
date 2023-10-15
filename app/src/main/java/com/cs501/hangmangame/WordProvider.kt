package com.cs501.hangmangame

object WordProvider {
    private val words = listOf("apple", "banana", "cherry", "mango", "hello", "fig", "grape")

    fun getRandomWord(): String {
        return words.random()
    }
}