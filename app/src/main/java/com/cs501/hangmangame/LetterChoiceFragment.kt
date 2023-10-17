package com.cs501.hangmangame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LetterChoiceFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val letters: List<Char> = ('A'..'Z').toList()
    private lateinit var lettersAdapter: LettersAdapter

    interface OnLetterSelectedListener {
        fun onLetterSelected(letter: Char)
    }

    private var letterSelectedListener: OnLetterSelectedListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_letter_choose, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.lettersRecyclerView)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        lettersAdapter = LettersAdapter(letters) { letter ->
            // Handle letter click here
            letterSelectedListener?.onLetterSelected(letter)
        }

        recyclerView.layoutManager = GridLayoutManager(context, 6) // 6 items in a row
        recyclerView.adapter = lettersAdapter
    }

    fun setOnLetterClickListener(listener: OnLetterSelectedListener) {
        this.letterSelectedListener = listener
    }
}