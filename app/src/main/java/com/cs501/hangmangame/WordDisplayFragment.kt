package com.cs501.hangmangame

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import java.util.Locale

class LetterDisplayFragment : Fragment() {

    private lateinit var wordLayout: LinearLayout
    private var word: String = ""
    private val letterViews = mutableListOf<TextView>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_word_display, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        wordLayout = view.findViewById(R.id.wordLayout)
    }

    fun setWord(newWord: String) {
        word = newWord.uppercase(Locale.ROOT)
        wordLayout.removeAllViews()
        letterViews.clear()

        for (letter in word) {
            val textView = TextView(context).apply {
                text = "_"
                textSize = 24f
                gravity = Gravity.CENTER
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    marginEnd = 8.dpToPx() // Convert dp to pixel
                }
            }
            wordLayout.addView(textView)
            letterViews.add(textView)
        }
    }

    fun revealLetter(letter: Char) {
        val upperLetter = letter.uppercase(Locale.ROOT)
        for (index in word.indices) {
            if (word[index].toString() == upperLetter) {
                letterViews[index].text = upperLetter
            }
        }
    }

    private fun Int.dpToPx(): Int = (this * resources.displayMetrics.density).toInt()
}