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

        hintButton = view.findViewById(R.id.btnHint)
        hintButton.setOnClickListener {
            provideHint()
        }
    }

    private fun provideHint() {
        hintCounter++
        when (hintCounter) {
            1 -> {
                // Display a hint message.
                // This can be a Toast message or an update to some TextView.
                Toast.makeText(context, "Hint: Some hint here.", Toast.LENGTH_SHORT).show()
            }
            2 -> {
                // Disable half of the remaining letters that are not part of the word.
                // Inform the main activity or controlling fragment to do so.
                // We can also decrease the turn count.
            }
            3 -> {
                // Show all the vowels and disable all vowel buttons.
                // Inform the main activity or controlling fragment to update letter choices.
            }
            else -> {
                // If clicking the hint button would cause the user to lose the game,
                // show a toast, "Hint not available".
                Toast.makeText(context, "Hint not available", Toast.LENGTH_SHORT).show()
            }
        }
    }
}