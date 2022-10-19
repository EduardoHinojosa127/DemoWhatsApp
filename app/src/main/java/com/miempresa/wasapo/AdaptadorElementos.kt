package com.miempresa.wasapo

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

import java.util.*

class AdaptadorElementos (val ListaElementos: ArrayList<Elementos>): RecyclerView.Adapter<AdaptadorElementos.ViewHolder>(){
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val fImagen = itemView.findViewById<ImageView>(R.id.imagen)
        val fnombre = itemView.findViewById<TextView>(R.id.nombre)
        val fmensaje = itemView.findViewById<TextView>(R.id.mensaje)
        val fhora = itemView.findViewById<TextView>(R.id.hora)
        val fcant_msj = itemView.findViewById<TextView>(R.id.cant_msj)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdaptadorElementos.ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.listachats,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: AdaptadorElementos.ViewHolder, position: Int) {
        holder?.fImagen?.setImageBitmap(ListaElementos[position].imagen)
        holder?.fnombre?.text=ListaElementos[position].nombre
        holder?.fmensaje?.text=ListaElementos[position].mensaje
        holder?.fhora?.text=ListaElementos[position].hora
        holder?.fcant_msj?.text=ListaElementos[position].cant_msj
    }

    override fun getItemCount(): Int {
        return ListaElementos.size;
    }

}
