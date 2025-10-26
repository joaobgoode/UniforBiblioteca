package com.example.uniforbiblioteca

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class ContatoFragment : Fragment() {


    lateinit var voltar: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =inflater.inflate(R.layout.fragment_contato, container, false)

        voltar = view.findViewById(R.id.voltar_contato)

        voltar.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        return view
    }

    override fun onResume() {
        super.onResume()
        (activity as? MainActivity)?.changeState("Contato")
    }
}