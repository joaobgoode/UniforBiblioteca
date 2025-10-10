package com.example.uniforbiblioteca

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MenuFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MenuFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var contatoBtn: TextView
    lateinit var chatBtn: TextView
    lateinit var configBtn: TextView
    lateinit var acervoBtn: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MenuFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MenuFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onResume() {
        super.onResume()
        (activity as? MainActivity)?.changeState("menu")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        contatoBtn = view.findViewById(R.id.menuContatoBtn)
        chatBtn = view.findViewById(R.id.menuChatBtn)
        configBtn = view.findViewById(R.id.menuConfigButton)
        acervoBtn = view.findViewById(R.id.menuAcervoButton)

        contatoBtn.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.mainFragmentContainer, ContatoFragment::class.java, null)
                .addToBackStack("menu")
                .commit()
        }

        configBtn.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.mainFragmentContainer, ConfigFragment::class.java, null)
                .addToBackStack("menu")
                .commit()
        }

        acervoBtn.setOnClickListener {
            (activity as? MainActivity)?.changeState("acervo")
            parentFragmentManager.beginTransaction()
                .replace(R.id.mainFragmentContainer, AcervoFragment::class.java, null)
                .addToBackStack("menu")
                .commit()
        }
    }
}