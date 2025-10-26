package com.example.uniforbiblioteca

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import PastaCardData
import android.widget.Button
import com.google.android.material.floatingactionbutton.FloatingActionButton

class PastasFragment : Fragment() {


    lateinit var addFAB: FloatingActionButton



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_pastas, container, false)

        //
        val recyclerView: RecyclerView = view.findViewById(R.id.pastasRecyclerView) // Ajuste o id para o seu XML
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Pastas de placeholders
        val pastas = listOf(
            PastaCardData(1, "Estrutura de Dados", "Ultima Modificação: 2025-10-08", "https://placehold.co/200x300/png"),
            PastaCardData(2, "Java", "Ultima Modificação: 2025-10-07", "https://placehold.co/200x300/png"),
            PastaCardData(3, "Redes", "Ultima Modificação: 2025-10-06", "https://placehold.co/200x300/png"),
            PastaCardData(4, "Integração", "Ultima Modificação: 2025-10-05", "https://placehold.co/200x300/png"),
        )
        // Adapter
        val adapter = PastaAdapter(pastas) { pasta ->
            parentFragmentManager.beginTransaction()
                .replace(R.id.mainFragmentContainer, PastaFragment::class.java, null)
                .addToBackStack(null)
                .commit()
        }

        recyclerView.adapter = adapter

        addFAB = view.findViewById(R.id.novaPasta)

        addFAB.setOnClickListener {
            val dialog = DialogCriarPasta()
            dialog.show(parentFragmentManager, "CriarPasta")
        }

        return view
    }



    override fun onResume() {
        super.onResume()
        (activity as? MainActivity)?.changeState("pastas")
    }
}