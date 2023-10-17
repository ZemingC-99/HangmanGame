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
 * 9.https://developer.android.com/develop/ui/views/layout/recyclerview
 */
package com.cs501.hangmangame

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), LetterChoiceFragment.OnLetterSelectedListener {

    private lateinit var hangmanGame: HangmanGame
    private lateinit var hangmanFragment: HangmanFragment
    private lateinit var wordDisplayFragment: WordDisplayFragment
    private lateinit var hintFragment: HintFragment
    private lateinit var letterChoiceFragment: LetterChoiceFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_phone)

        hangmanGame = HangmanGame()

        letterChoiceFragment = supportFragmentManager.findFragmentById(R.id.letterChoiceFragment) as LetterChoiceFragment
        hangmanFragment = supportFragmentManager.findFragmentById(R.id.hangmanFragment) as HangmanFragment
        wordDisplayFragment = supportFragmentManager.findFragmentById(R.id.wordDisplayFragment) as WordDisplayFragment
        hintFragment = supportFragmentManager.findFragmentById(R.id.hintFragment) as HintFragment

        setupGame()
        setupLetterChoiceFragment()
    }

    private fun setupGame() {
        hangmanGame.word = WordProvider.getRandomWord()
        wordDisplayFragment.setWord(hangmanGame.word, hangmanGame.guessedLetters)
    }

    private fun setupLetterChoiceFragment() {
        val letterChoiceFragment = supportFragmentManager.findFragmentById(R.id.letterChoiceFragment) as LetterChoiceFragment
        letterChoiceFragment.setOnLetterClickListener(this)
    }

    private fun checkGameState() {
        if (hangmanGame.isGameOver()) {
        }
    }

    fun onLetterChosen(letter: Any) {
        if (hangmanGame.guessLetter(letter)) {
            wordDisplayFragment.revealLetter(hangmanGame.guessedLetters)
        } else {
            hangmanFragment.updateHangmanImage()
        }
        checkGameState()
    }

    override fun onLetterSelected(letter: Char) {
        onLetterChosen(letter)
    }
}