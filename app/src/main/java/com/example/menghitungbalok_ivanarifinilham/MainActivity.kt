package com.example.menghitungbalok_ivanarifinilham

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var panjang : EditText
    private lateinit var lebar : EditText
    private lateinit var tinggi : EditText
    private lateinit var luas : RadioButton
    private lateinit var volume : RadioButton
    private lateinit var hitung : Button
    private lateinit var hasil: TextView

    private var rumus : Int =0
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter : RecyclerView.Adapter<*>
    private lateinit var viewManager : RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        panjang = findViewById(R.id.panjang)
        lebar = findViewById(R.id.lebar)
        tinggi = findViewById(R.id.tinggi)
        luas = findViewById(R.id.luas)
        volume = findViewById(R.id.volume)
        hitung = findViewById(R.id.hitung)
        hasil = findViewById(R.id.hasil)


        val data = ArrayList<Data>()
        recyclerView = findViewById(R.id.listdata)
        viewManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerAdapter = Adapter(data)
        recyclerView.adapter = recyclerAdapter
        recyclerView.layoutManager = viewManager


        hitung.setOnClickListener {

            var panjang= panjang.text.toString().toInt()
            var lebar= lebar.text.toString().toInt()
            var tinggi= tinggi.text.toString().toInt()

            if(luas.isChecked)
            {
                rumus= (2 * (panjang * lebar + panjang * tinggi + lebar * tinggi))
                hasil.setText(rumus.toString())

                val tampil = Data(rumus)
                data.add(tampil)
                recyclerAdapter.notifyDataSetChanged()

            } else
            {
                rumus = (panjang * lebar * tinggi)
                hasil.setText(rumus.toString())

                val tampil = Data(rumus)
                data.add(tampil)
                recyclerAdapter.notifyDataSetChanged()

            }
        }

    }
}