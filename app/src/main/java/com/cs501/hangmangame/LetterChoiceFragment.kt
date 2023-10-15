package com.cs501.hangmangame

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.TextView
import androidx.fragment.app.Fragment

class LetterChoiceFragment : Fragment() {

    private lateinit var gridLetters: GridLayout
    private val letters = ('A'..'Z').toList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_letter_choose, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        gridLetters = view.findViewById(R.id.gridLetters)

        // Populate the GridLayout with letters
        for (letter in letters) {
            val textView = TextView(context).apply {
                text = letter.toString()
                textSize = 24f // You can adjust the size to your preference
                gravity = Gravity.CENTER
                layoutParams = GridLayout.LayoutParams().apply {
                    width = 0
                    height = GridLayout.LayoutParams.WRAP_CONTENT
                    //weight = 1f
                }
                setOnClickListener {
                    it.isEnabled = false // Disable after being clicked
                    (activity as? LetterSelectedListener)?.onLetterSelected(letter)
                }
            }
            gridLetters.addView(textView)
        }
    }

    interface LetterSelectedListener {
        fun onLetterSelected(letter: Char)
    }
}