package com.example.uniforbiblioteca

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class LivroFragment : Fragment() {


    lateinit var addACesta: Button
    lateinit var addAPasta: Button
    lateinit var voltar: Button



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_livro, container, false)


        addACesta = view.findViewById(R.id.addaCesta)
        addAPasta = view.findViewById(R.id.addaPasta)
        voltar = view.findViewById(R.id.livro_voltar)

        addACesta.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }


        addAPasta.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        voltar.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }



        return view
    }


    override fun onResume() {
        super.onResume()
        (activity as? MainActivity)?.changeState("livro")
    }

}