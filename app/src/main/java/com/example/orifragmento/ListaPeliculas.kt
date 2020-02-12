package com.example.orifragmento


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.Pelicula


class ListaPeliculas : Fragment() {
    companion object {
        var peliculas:ArrayList<Pelicula>?  = null
    }

    var nombrePeliculas:ArrayList<String>? = null

    var lista:ListView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         val vista = inflater.inflate(R.layout.fragment_lista_peliculas, container, false)

        peliculas = arrayListOf()
        peliculas?.add(Pelicula("AVES DE PRESA", R.drawable.images1))
        peliculas?.add(Pelicula("BAD BOYS 3", R.drawable.images2))
        peliculas?.add(Pelicula("GRETEL & HANSEL", R.drawable.images3))
        peliculas?.add(Pelicula("DOLITTLE", R.drawable.images4))

        nombrePeliculas = obtenerNombrePeliculas(peliculas!!)

        val adaptador = ArrayAdapter(vista.context, android.R.layout.simple_list_item_1,
            nombrePeliculas!!
        )

        lista = vista.findViewById(R.id.lista)
        lista?.adapter = adaptador

        lista?.setOnItemClickListener { adapterView, view, i, l ->
            // Toast.makeText(vista.context, nombrePeliculas?.get(i), Toast.LENGTH_SHORT).show()}
            val intent = Intent(vista.context, Detalles::class.java)
            intent.putExtra("INDEX", i)
            startActivity(intent)
        }


        return  vista
    }

    fun obtenerNombrePeliculas(peliculas:ArrayList<Pelicula>):ArrayList<String>{
        val nombres = ArrayList<String>()

        for (pelicula in peliculas){
            nombres.add(pelicula.nombre)
        }

        return nombres
    }


}
