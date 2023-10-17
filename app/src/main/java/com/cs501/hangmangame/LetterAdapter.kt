package com.cs501.hangmangame

import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LettersAdapter(
    private val letters: List<Char>,
    private val onLetterClick: (Char) -> Unit) : RecyclerView.Adapter<LettersAdapter.LetterViewHolder>() {

    var onLetterClickListener: OnLetterClickListener? = null

    interface OnLetterClickListener {
        fun onLetterClick(letter: Char)
    }

    inner class LetterViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        private val letterButton: Button = view.findViewById(R.id.letterButton)

        fun bind(letter: Char) {
            letterButton.text = letter.toString()
            letterButton.setOnClickListener {
                onLetterClickListener?.onLetterClick(letter)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.letter_item, parent, false)
        return LetterViewHolder(view)
    }

    override fun onBindViewHolder(holder: LetterViewHolder, position: Int) {
        holder.bind(letters[position])
    }

    override fun getItemCount() = letters.size
}