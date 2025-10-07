package com.example.uniforbiblioteca

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {

    lateinit var homeBtn: Button
    lateinit var historicoBtn: Button
    lateinit var pastasBtn: Button
    lateinit var menuBtn: Button
    lateinit var fm: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        homeBtn = findViewById(R.id.homeBtn)
        historicoBtn = findViewById(R.id.historicoBtn)
        pastasBtn = findViewById(R.id.pastasBtn)
        menuBtn = findViewById(R.id.menuBtn)
        fm = supportFragmentManager
    }

    override fun onStart() {
        super.onStart()

        homeBtn.setOnClickListener {
            fm.beginTransaction()
                .replace(R.id.mainFragmentContainer, HomeFragment::class.java, null)
                .commit()
        }


        historicoBtn.setOnClickListener {
            fm.beginTransaction()
                .replace(R.id.mainFragmentContainer, HistoricoFragment::class.java, null)
                .commit()
        }
        pastasBtn.setOnClickListener {
            fm.beginTransaction()
                .replace(R.id.mainFragmentContainer, PastasFragment::class.java, null)
                .commit()
        }
        menuBtn.setOnClickListener {
            fm.beginTransaction()
                .replace(R.id.mainFragmentContainer, MenuFragment::class.java, null)
                .commit()
        }
    }
}