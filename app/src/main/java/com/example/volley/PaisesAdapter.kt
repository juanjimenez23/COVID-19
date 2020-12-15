package com.example.volley

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.pais_item.view.*

class PaisesAdapter(paises:ArrayList<Pais>,contexto:Context):RecyclerView.Adapter<PaisesAdapter.ViewHolder>(){
    var listaPaises:ArrayList<Pais>?=null
    var contexto:Context?=null

    init {
        this.listaPaises = paises
        this.contexto = contexto
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaisesAdapter.ViewHolder {
        val vistaPais:View=LayoutInflater.from(contexto).inflate(R.layout.pais_item,parent,false)
        val paisViewHolder = ViewHolder(vistaPais)
        vistaPais.tag = paisViewHolder
        return paisViewHolder
    }


    override fun getItemCount(): Int {
        return listaPaises!!.count()
    }

    override fun onBindViewHolder(holder: PaisesAdapter.ViewHolder, position: Int) {
        holder.nombrePais!!.text=listaPaises!![position].nombre
        holder.numeroConfirmados!!.text="${listaPaises!![position].confirmados}"
        holder.numeroMuertos!!.text="${listaPaises!![position].muertos}"
        holder.numeroRecuperados!!.text="${listaPaises!![position].recuperados}"
        Picasso.get().load("https://www.countryflags.io/${listaPaises!![position].codigosPais}/flat/64.png").into(holder.bandera)

    }

    class ViewHolder(vista: View):RecyclerView.ViewHolder(vista){
        var nombrePais:TextView?=null
        var numeroConfirmados:TextView?=null
        var numeroMuertos:TextView?=null
        var numeroRecuperados:TextView?=null
        var bandera:ImageView?=null

        init {
            nombrePais = vista.tvNombrePais
            numeroConfirmados = vista.tvConfirmados
            numeroMuertos = vista.tvMuertos
            numeroRecuperados = vista.tvRecuperados
            bandera = vista.ivBandera
        }

    }

}