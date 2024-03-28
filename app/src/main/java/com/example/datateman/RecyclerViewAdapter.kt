package com.example.datateman

import android.annotation.SuppressLint
import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.LinearLayout


class RecyclerViewAdapter (private val dataTeman: ArrayList<data_teman>, context: Context) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){

    private val context: Context

    //view holder digunakan untuk menyimpan referensi dari view-view
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val Nama : TextView
        val Alamat : TextView
        val NoHp : TextView
        val ListItem : LinearLayout


        //menginisialisasi view yang terpasang pada layout recyclerview
        init {
            Nama = itemView.findViewById(R.id.namax)
            Alamat = itemView.findViewById(R.id.alamatx)
            NoHp = itemView.findViewById(R.id.no_hpx)
            ListItem = itemView.findViewById(R.id.list_item)
        }
    }

    //membuat view untuk menyiapkan dan memasang layout yang digunakan pada recycler view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val V: View = LayoutInflater.from(parent.getContext()).inflate(
            R.layout.view_design, parent, false)
        return ViewHolder(V)
    }

    @SuppressLint("SetTextI18n")
    //mengambil nilai atau value oada recycler view berdasarkan posisi tertentu
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val Nama: String? = dataTeman.get(position).nama
        val Alamat: String? = dataTeman.get(position).alamat

        //masukan nilai atau value ke dalam view
        holder.Nama.text = "Nama : $Nama"
        holder.Alamat.text = "Alamat: $Alamat"
        holder.ListItem.setOnLongClickListener (
            object : View.OnLongClickListener {
                override fun onLongClick(v: View?): Boolean {
                    //materi pertemuan selanjutnya untuk edit dan delete
                    return true
                }
            })
    }

    //menghitung ukuran/jumlah data yang akan ditampilkan pada recyclerview
    override fun getItemCount(): Int {
        return dataTeman.size
    }

    //membuat konstruktor, untuk menerima input dari database
    init{
        this.context = context
    }
}