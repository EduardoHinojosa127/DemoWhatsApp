package com.miempresa.wasapo

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lista_chats.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        lista_chats.layoutManager = LinearLayoutManager(this)

        var llenarLista = ArrayList<Elementos>()
        var imagen_list:MutableList<Bitmap> = mutableListOf(
            BitmapFactory.decodeResource(resources,R.drawable.imgconfiguracion),
            BitmapFactory.decodeResource(resources,R.drawable.descarga1),
            BitmapFactory.decodeResource(resources,R.drawable.descarga2),
            BitmapFactory.decodeResource(resources,R.drawable.descarga3),
            BitmapFactory.decodeResource(resources,R.drawable.descarga4),

        )
        var nombres_list:MutableList<String> = mutableListOf("Eduardo","Juan","Luis","Pepe","Lucia","Andre","Carlos","Pokemon","Pedro","Dario","Webster","Beck","Aila","Frazier","Barrett","Annecorinne","Fabiano","Sheppard","Ag","Hulda","Farlee","Brinna")
        var min = 59
        for (i in 1..12){
            llenarLista.add(
                Elementos(
                    imagen_list[(0..4).random()],
                    nombres_list[(0..nombres_list.size-1).random()],
                    "Mensaje: "+i,
                    "10:"+min+" p.m.",
                    (1..12).random().toString()
                )
            )
            min -= (1..6).random()
        }
        val adapter = AdaptadorElementos(llenarLista)
        lista_chats.adapter = adapter

        registerForContextMenu(lista_chats)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menuprincipal,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.itemId
        if (id == R.id.buscar){
            Toast.makeText(this,"Elegiste Buscar",Toast.LENGTH_LONG).show();
        }
        if (id == R.id.chat) {
            //Toast.makeText(this,"Elegiste Chat",Toast.LENGTH_LONG).show();
            val llamaactividad = Intent(applicationContext,chats::class.java)
            startActivity(llamaactividad)
            return true
        }
        if (id == R.id.ajustes) {
            //Toast.makeText(this, "Elegiste Ajustes", Toast.LENGTH_LONG).show();
            val llamaactividad = Intent(applicationContext,ajustes::class.java)
            startActivity(llamaactividad)
            return true
        }
        if (id == R.id.acerca_de) {
            //Toast.makeText(this, "Elegiste Acerca de", Toast.LENGTH_LONG).show();
            val llamaactividad = Intent(applicationContext,acerca_de::class.java)
            startActivity(llamaactividad)
            return true
        }
        return super.onOptionsItemSelected(item)
    }


}