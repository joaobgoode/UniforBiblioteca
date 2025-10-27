package com.example.uniforbiblioteca

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AdminAcervoAdapter(
    private val books: List<LivroCardData>,
    private val onItemClick: (LivroCardData) -> Unit,
    private val onDeleteClicked: (LivroCardData) -> Unit,
    private val onEditClicked: (LivroCardData) -> Unit
) : RecyclerView.Adapter<AdminAcervoAdapter.AdminAcervoViewHolder>() {

    inner class AdminAcervoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleView: TextView = itemView.findViewById(R.id.titulo_admin_acervo)
        private val autorView: TextView = itemView.findViewById(R.id.autor_admin_acervo)
        private val coverView: ImageView = itemView.findViewById(R.id.imagem_admin_acervo)

        private val delBtn: Button = itemView.findViewById(R.id.del_acervo_card)
        private val editBtn: Button = itemView.findViewById(R.id.edit_cervo_card)
        fun bind(livro: LivroCardData) {
            titleView.text = livro.titulo
            autorView.text = livro.autor

            Glide.with(itemView.context)
                .load(livro.image)
                .into(coverView)

            itemView.setOnClickListener {
                onItemClick(livro)
            }

            delBtn.setOnClickListener {
                onDeleteClicked(livro)
            }
            editBtn.setOnClickListener {
                onEditClicked(livro)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdminAcervoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.admin_acervo_card, parent, false)
        return AdminAcervoViewHolder(view)
    }


    override fun onBindViewHolder(holder: AdminAcervoViewHolder, position: Int) {
        holder.bind(books[position])
    }

    override fun getItemCount() = books.size
}
