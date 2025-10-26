package com.example.uniforbiblioteca

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button



class AdminLivroFragment : Fragment() {

    lateinit var editar: Button
    lateinit var exemplares: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_admin_livro, container, false)


        editar = view.findViewById(R.id.admin_livro_editar)
        exemplares = view.findViewById(R.id.admin_livro_ver_exemplares)

        exemplares.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.adminFragmentContainer, AdminExemplaresFragment::class.java, null)
                .addToBackStack(null)
                .commit()
        }


        editar.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.adminFragmentContainer, AdminEditLivroFragment::class.java, null)
                .addToBackStack(null)
                .commit()        }



        return view
    }

    override fun onResume() {
        super.onResume()
        (activity as? AdminActivity)?.changeState("livro")
    }

}