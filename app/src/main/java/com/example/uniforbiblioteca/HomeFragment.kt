package com.example.uniforbiblioteca

import LivroCardData
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class HomeFragment : Fragment() {

    lateinit var sairBtn: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerViewHome)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val livros = listOf(
            LivroCardData(1, "Livro 1", "Autor 1", "Finaliza: 13 de outubro de 2025", "https://placehold.co/200x300/png"),
            LivroCardData(2, "Livro 2", "Autor 2", "Finaliza: 13 de outubro de 2025", "https://placehold.co/200x300/png"),
            LivroCardData(3, "Livro 3", "Autor 3", "Finaliza: 22 de outubro de 2025", "https://placehold.co/200x300/png"),
            LivroCardData(4, "Livro 4", "Autor 4", "Finaliza: 22 de outubro de 2025", "https://placehold.co/200x300/png"),
        )

        //
        val adapter = EmprestadoAdapter(livros) { livro ->
            Toast.makeText(requireContext(), "Clicou em: ${livro.titulo}", Toast.LENGTH_SHORT).show()
        }

        recyclerView.adapter = adapter

        sairBtn = view.findViewById(R.id.sairBtn)

        sairBtn.setOnClickListener {
            (activity as? MainActivity)?.sair()
        }

        return view
    }





    override fun onResume() {
        super.onResume()
        (activity as? MainActivity)?.changeState("home")
    }
}