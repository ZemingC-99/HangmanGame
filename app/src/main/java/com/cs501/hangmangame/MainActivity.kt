/**
 * References:
 * 1.https://developer.android.com/reference/android/widget/GridLayout
 * 2.https://developer.android.com/reference/android/widget/FrameLayout
 * 3.https://developer.android.com/topic/libraries/view-binding
 * 4.https://stackoverflow.com/questions/68124726/what-is-the-difference-between-binding-and-binding
 * 5.https://developer.android.com/reference/android/text/Selection
 * 6.https://developer.android.com/guide/topics/large-screens/support-different-screen-sizes
 * 7.https://stackoverflow.com/questions/4185507/layout-for-tablets-in-android
 * 8.https://developer.android.com/guide/fragments/communicate
 */
package com.cs501.hangmangame

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), LetterChoiceFragment.LetterSelectedListener {

    private lateinit var hangmanGame: HangmanGame
    private lateinit var hangmanFragment: HangmanFragment
    private lateinit var wordDisplayFragment: WordDisplayFragment
    private lateinit var hintFragment: HintFragment
    // Add other fragments as needed

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_phone)

        hangmanGame = HangmanGame()
        hangmanFragment = supportFragmentManager.findFragmentById(R.id.hangmanFragment) as HangmanFragment
        wordDisplayFragment = supportFragmentManager.findFragmentById(R.id.wordDisplayFragment) as WordDisplayFragment
        hintFragment = supportFragmentManager.findFragmentById(R.id.hintFragment) as HintFragment
        // Initialize other fragments as needed

        setupGame()
    }

    private fun setupGame() {
        hangmanGame.word = WordProvider.getRandomWord()
        wordDisplayFragment.setWord(hangmanGame.word, hangmanGame.guessedLetters)
    }

    override fun onLetterSelected(letter: Char) {
        val isCorrect = hangmanGame.guessLetter(letter)
        if (isCorrect) {
            wordDisplayFragment.revealLetter(letter)
        } else {
            hangmanFragment.incrementHangmanState()
        }

        checkGameState()
    }

    private fun checkGameState() {
        if (hangmanGame.isGameOver()) {
            // Handle game over state. You can show a dialog or navigate to a different screen.
        }
    }

    // You can also add methods to handle hint interactions and other game mechanics.
}