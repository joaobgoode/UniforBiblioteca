package com.example.uniforbiblioteca

import PastaCardData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class SelecionarPastaAdapter(
    private val pastas: List<PastaCardData>,
) : RecyclerView.Adapter<SelecionarPastaAdapter.PastaViewHolder>() {

    private var selectedPosition: Int = RecyclerView.NO_POSITION

    inner class PastaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleView: TextView = itemView.findViewById(R.id.titulo_card_pasta)
        private val tempoView: TextView = itemView.findViewById(R.id.card_ultima_modificacao)
        private val frame: ConstraintLayout = itemView.findViewById(R.id.frame_card)

        fun bind(pasta: PastaCardData, isSelected: Boolean) {
            titleView.text = pasta.titulo
            tempoView.text = pasta.lastModified

            val backgroundRes = if (isSelected)
                R.drawable.frame_card_selected
            else
                R.drawable.frame_card_default

            frame.setBackgroundResource(backgroundRes)

            itemView.setOnClickListener {
                val previousPosition = selectedPosition
                selectedPosition = adapterPosition

                notifyItemChanged(previousPosition)
                notifyItemChanged(selectedPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PastaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_pasta, parent, false)
        return PastaViewHolder(view)
    }

    override fun onBindViewHolder(holder: PastaViewHolder, position: Int) {
        holder.bind(pastas[position], position == selectedPosition)
    }

    override fun getItemCount() = pastas.size
}
