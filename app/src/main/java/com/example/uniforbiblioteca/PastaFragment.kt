package com.example.uniforbiblioteca

import LivroCardData
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class PastaFragment : Fragment() {

    private lateinit var pastaFab: FloatingActionButton
    private lateinit var pastaVoltar: Button
    private lateinit var pastaTitulo: TextView
    private lateinit var pastaUltimaModificacao: TextView
    private lateinit var pastaEditBtn: Button
    private lateinit var pastaMembrosBtn: Button
    private lateinit var pastaRv: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_pasta, container, false)

        pastaFab = view.findViewById(R.id.pasta_fab)
        pastaVoltar = view.findViewById(R.id.pasta_voltar)
        pastaTitulo = view.findViewById(R.id.pasta_titulo)
        pastaUltimaModificacao = view.findViewById(R.id.pasta_ultima_modificacao)
        pastaEditBtn = view.findViewById(R.id.pasta_edit_btn)
        pastaMembrosBtn = view.findViewById(R.id.pasta_membros_btn)
        pastaRv = view.findViewById(R.id.pasta_rv)

        // Lista de placeholders
        val livros = listOf(
            LivroCardData(1, "Livro 1", "Autor 1", "5 dias atrás", "https://placehold.co/200x300/png"),
            LivroCardData(2, "Livro 2", "Autor 2", "8 dias atrás", "https://placehold.co/200x300/png"),
            LivroCardData(3, "Livro 3", "Autor 3", "8 dias atrás", "https://placehold.co/200x300/png"),
            LivroCardData(4, "Livro 4", "Autor 4", "30 dias atrás", "https://placehold.co/200x300/png"),
            LivroCardData(5, "Livro 5", "Autor 5", "50 dias atrás", "https://placehold.co/200x300/png"),
            LivroCardData(6, "Livro 6", "Autor 6", "50 dias atrás", "https://placehold.co/200x300/png"),
            LivroCardData(7, "Livro 7", "Autor 7", "70 dias atrás", "https://placehold.co/200x300/png"),
            LivroCardData(8, "Livro 8", "Autor 8", "90 dias atrás", "https://placehold.co/200x300/png"),
            LivroCardData(9, "Livro 9", "Autor 9", "90 dias atrás", "https://placehold.co/200x300/png")
        )

        // Adapter
        val adapter = AcervoAdapter(livros) { livro ->
            parentFragmentManager.beginTransaction()
                .replace(R.id.mainFragmentContainer, LivroFragment::class.java, null)
                .addToBackStack(null)
                .commit()
        }

        pastaFab.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.mainFragmentContainer, AcervoFragment::class.java, null)
                .addToBackStack(null)
                .commit()
        }

        pastaEditBtn.setOnClickListener {
            val dialog = DialogEditarPasta()
            dialog.show(parentFragmentManager, "EditarPasta")
        }

        pastaMembrosBtn.setOnClickListener {
            val dialog = NovoMembroPastaDialog()
            dialog.show(parentFragmentManager, "Membros")
        }

        pastaVoltar.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        pastaRv.adapter = adapter
        pastaRv.layoutManager = LinearLayoutManager(requireContext())


        return view
    }


    override fun onResume() {
        super.onResume()
        (activity as? MainActivity)?.changeState("Pasta")
    }
}
