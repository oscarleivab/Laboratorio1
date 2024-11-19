package com.example.practica12

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button = findViewById<Button>(R.id.button)

        val editTextText2 = findViewById<EditText>(R.id.editTextText2)

        button.setOnClickListener{
            val texto = editTextText2.text.toString()
            if (texto.isBlank()) {
                // Mostrar mensaje de error
                Toast.makeText(this, "Por favor, ingrese un texto antes de continuar.", Toast.LENGTH_SHORT).show()
            } else {
                // Continuar con la navegación si hay texto
                val intent = Intent(this, MainActivity2::class.java)
                intent.putExtra("EXTRA_TEXTO", texto)
                startActivity(intent)
            }
        }
    }
}
