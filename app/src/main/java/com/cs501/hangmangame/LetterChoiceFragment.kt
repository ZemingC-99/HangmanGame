package com.cs501.hangmangame

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.GridLayout
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
            val button = Button(context).apply {
                text = letter.toString()
                textSize = 24f
                gravity = Gravity.CENTER
                layoutParams = GridLayout.LayoutParams().apply {
                    width = GridLayout.LayoutParams.WRAP_CONTENT
                    height = GridLayout.LayoutParams.WRAP_CONTENT
                }
                setOnClickListener {
                    it.isEnabled = false // Disable after being clicked
                    (activity as? LetterSelectedListener)?.onLetterSelected(letter)
                }
                contentDescription = "Button for letter $letter"
            }
            gridLetters.addView(button)
        }
    }

    interface LetterSelectedListener {
        fun onLetterSelected(letter: Char)
    }
}