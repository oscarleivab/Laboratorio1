package com.example.practica12

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val eleccion = intent.getStringExtra("EXTRA_ELECCION") ?: "No se recibió ninguna elección."

        // Actualiza el TextView con el mensaje
        val textView3 = findViewById<TextView>(R.id.textView3)
        textView3.text = eleccion

        val button = findViewById<Button>(R.id.button3)

        button.setOnClickListener {
            finishAffinity()
        }



    }
}