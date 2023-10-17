package com.cs501.hangmangame

class HangmanGame {
    var word: String = WordProvider.getRandomWord()
    var guessedLetters: MutableSet<Char> = mutableSetOf()
    var incorrectGuesses: Int = 0
    var hintState: Int = 0

    fun guessLetter(letter: Any): Boolean {
        guessedLetters.add(letter as Char)
        return word.contains(letter)
    }

    fun isGameOver(): Boolean {
        return incorrectGuesses >= MAX_INCORRECT || getMaskedWord() == word
    }

    fun getMaskedWord(): String {
        return word.map { if (guessedLetters.contains(it)) it else '_' }.joinToString(" ")
    }

    companion object {
        const val MAX_INCORRECT = 6
    }
}