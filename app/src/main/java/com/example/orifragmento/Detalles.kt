package com.example.orifragmento

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Detalles : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalles)

        val index = intent.getIntExtra("INDEX", 0)

        val foto = findViewById<ImageView>(R.id.ivFoto)

        foto.setImageResource(ListaPeliculas.peliculas?.get(index)?.imagen!!)
    }
}
