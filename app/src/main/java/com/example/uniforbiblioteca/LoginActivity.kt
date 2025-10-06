package com.example.uniforbiblioteca

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    lateinit var entrar: Button
    lateinit var regristrar: TextView
    lateinit var recuperar: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        entrar = findViewById(R.id.entrarBtn)
        recuperar = findViewById(R.id.esqueciSenha)
        regristrar = findViewById(R.id.paraRegistroBtn)
    }

    override fun onStart() {
        super.onStart()

        entrar.setOnClickListener {
            val intencao = Intent(this, Placeholder::class.java)
            intencao.putExtra("origem", "entrar")
            startActivity(intencao)
        }

        recuperar.setOnClickListener {
            val intencao = Intent(this, Placeholder::class.java)
            intencao.putExtra("origem", "recuperar")
            startActivity(intencao)
        }

        regristrar.setOnClickListener {
            val intencao = Intent(this, Placeholder::class.java)
            intencao.putExtra("origem", "regristrar")
            startActivity(intencao)
        }
    }
}