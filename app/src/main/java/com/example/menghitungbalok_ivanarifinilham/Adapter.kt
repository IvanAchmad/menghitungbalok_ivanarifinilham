package com.example.menghitungbalok_ivanarifinilham

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter (private val dataset : MutableList<Data>):
    RecyclerView.Adapter<Adapter.DataHolder>(){
    class DataHolder(view : View):RecyclerView.ViewHolder(view){
        val hasil = view.findViewById<TextView>(R.id.hasil)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.activity_adapter,parent,false
        )
        return DataHolder(view)
    }


    override fun onBindViewHolder(holder: DataHolder, position: Int) {
        val data = dataset[position]
        holder.hasil.text = data.hasil.toString()

        }

    override fun getItemCount(): Int = dataset.size

}
