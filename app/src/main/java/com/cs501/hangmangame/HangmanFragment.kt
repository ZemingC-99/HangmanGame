package com.cs501.hangmangame

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cs501.hangmangame.databinding.FragmentHangmanDrawingBinding

class HangmanFragment : Fragment() {

    private var _binding: FragmentHangmanDrawingBinding? = null
    private val binding get() = _binding!!

    private var currentHangmanState: Int = 0
    private val hangmanDrawables = listOf(
        R.drawable.hangman_initial,
        R.drawable.hangman_body,
        R.drawable.hangman_body,
        R.drawable.hangman_arm_left,
        R.drawable.hangman_arm_right,
        R.drawable.hangman_leg_left,
        R.drawable.hangman_leg_right
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHangmanDrawingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateHangmanImage()
    }

    private fun updateHangmanImage() {
        if (currentHangmanState < hangmanDrawables.size) {
            binding.hangmanImage.setImageResource(hangmanDrawables[currentHangmanState])
        }
    }

    fun incrementHangmanState() {
        if (currentHangmanState < hangmanDrawables.size - 1) {
            currentHangmanState++
            updateHangmanImage()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}