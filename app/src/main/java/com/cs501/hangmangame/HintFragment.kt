package com.cs501.hangmangame

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment

class HintFragment : Fragment() {
    private var hintCounter = 0
    private lateinit var hintButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hint_button, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        hintCounter = savedInstanceState?.getInt("hintCounter") ?: 0

        hintButton = view.findViewById(R.id.btnHint)
        hintButton.setOnClickListener {
            provideHint()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("hintCounter", hintCounter)
    }

    private fun provideHint() {
        hintCounter++
        when (hintCounter) {
            1 -> {
                Toast.makeText(context, "Hint: Some hint here.", Toast.LENGTH_SHORT).show()
            }
            2 -> {
                (activity as? HintActionListener)?.disableHalfOfTheLetters()
            }
            3 -> {
                (activity as? HintActionListener)?.showAllVowels()
                hintButton.isEnabled = false
            }
            else -> {
                Toast.makeText(context, "Hint not available", Toast.LENGTH_SHORT).show()
                hintButton.isEnabled = false
            }
        }
    }

    interface HintActionListener {
        fun disableHalfOfTheLetters()
        fun showAllVowels()
    }

    interface HintSelectedListener {
        fun onHintSelected(): Int
    }
}