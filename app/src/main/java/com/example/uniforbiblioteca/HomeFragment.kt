package com.example.uniforbiblioteca

import LivroCardData
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class HomeFragment : Fragment() {

    lateinit var sairBtn: Button

    lateinit var recente1: ImageView
    lateinit var recente2: ImageView
    lateinit var recente3: ImageView
    lateinit var recente4: ImageView
    lateinit var recente5: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerViewHome)

        recente1 = view.findViewById(R.id.recente_1)
        recente2 = view.findViewById(R.id.recente_2)
        recente3 = view.findViewById(R.id.recente_3)
        recente4 = view.findViewById(R.id.recente_4)
        recente5 = view.findViewById(R.id.recente_5)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val livros = listOf(
            LivroCardData(1, "Livro 1", "Autor 1", "Finaliza: 13 de outubro de 2025", "https://placehold.co/200x300/png"),
            LivroCardData(2, "Livro 2", "Autor 2", "Finaliza: 13 de outubro de 2025", "https://placehold.co/200x300/png"),
            LivroCardData(3, "Livro 3", "Autor 3", "Finaliza: 22 de outubro de 2025", "https://placehold.co/200x300/png"),
            LivroCardData(4, "Livro 4", "Autor 4", "Finaliza: 22 de outubro de 2025", "https://placehold.co/200x300/png"),
        )

        //
        val adapter = EmprestadoAdapter(livros) { livro ->
            verLivro()
        }

        recyclerView.adapter = adapter

        sairBtn = view.findViewById(R.id.sairBtn)

        sairBtn.setOnClickListener {
            (activity as? MainActivity)?.sair()
        }

        recente1.setOnClickListener { verLivro() }
        recente2.setOnClickListener { verLivro() }
        recente3.setOnClickListener { verLivro() }
        recente4.setOnClickListener { verLivro() }
        recente5.setOnClickListener { verLivro() }

        return view
    }

    fun verLivro(){
        parentFragmentManager.beginTransaction()
            .replace(R.id.mainFragmentContainer, LivroFragment::class.java, null)
            .addToBackStack(null)
            .commit()
    }





    override fun onResume() {
        super.onResume()
        (activity as? MainActivity)?.changeState("home")
    }
}