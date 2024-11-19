package com.example.practica12

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        val nombre = intent.getStringExtra("EXTRA_TEXTO") ?: "Desconocido"

        val textView4 = findViewById<TextView>(R.id.textView4)

        textView4.text = "Sir $nombre, es el momento de que tomes un dificil elección..."

        val textView1 = findViewById<TextView>(R.id.textView2)
        val checkBox1 = findViewById<CheckBox>(R.id.checkBox)
        val checkBox2 = findViewById<CheckBox>(R.id.checkBox2)


        checkBox1.setOnCheckedChangeListener { _, isChecked ->
            Log.d("CHECKBOXES", "Raenira Targaryen: $isChecked")
            updateText(textView1, checkBox1, checkBox2)
        }


        checkBox2.setOnCheckedChangeListener { _, isChecked ->
            Log.d("CHECKBOXES", "Aegon Targaryen: $isChecked")
            updateText(textView1, checkBox1, checkBox2)
        }

        val button = findViewById<Button>(R.id.button2)

        button.setOnClickListener{
            val intent = Intent(this,MainActivity3::class.java)

            val eleccion = when {
                checkBox1.isChecked && checkBox2.isChecked -> {
                    "Has elegido a ambos, pero jugar a dos bandas es peligroso."
                }
                checkBox1.isChecked -> {
                    "Has elegido a Raenira Targaryen como sucesora."
                }
                checkBox2.isChecked -> {
                    "Has elegido a Aegon Targaryen como sucesor."
                }
                else -> {
                    "No has elegido a nadie como sucesor."
                }
            }

            intent.putExtra("EXTRA_ELECCION", eleccion)

            startActivity(intent)
        }
    }


    private fun updateText(textView: TextView, checkBox1: CheckBox, checkBox2: CheckBox) {
        when {
            checkBox1.isChecked && checkBox2.isChecked -> {
                textView.text = "Jugar a dos bandas es muy peligroso... Tu cabeza podrá rodar en cualquier momento."
            }
            checkBox1.isChecked -> {
                textView.text = "Has decidido apoyar a una mujer por encima del primogénito varón... Lo pagarás con sangre."
            }
            checkBox2.isChecked -> {
                textView.text = "Has elegido a Aegon contra la voluntad del difunto rey... Arderás por tu elección... Dracarys!"
            }
            else -> {
                textView.text = "Elige a tu sucesor entre Raenira y Aegon Targaryen."
            }
        }
    }


}
