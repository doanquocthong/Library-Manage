package com.example.managelibrary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter

class RvAdapter(var list: List<OutData>) : RecyclerView.Adapter<RvAdapter.LibraryViewHolder>(){
    inner class LibraryViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibraryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.libraries_layout, parent, false)
        return LibraryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: LibraryViewHolder, position: Int) {
        holder.itemView.apply {
            val ivSource = findViewById<ImageView>(R.id.ivSource)
            val tvTitle = findViewById<TextView>(R.id.tvTitle)
            val tvAuthor = findViewById<TextView>(R.id.tvAuthor)
            val tvState = findViewById<TextView>(R.id.tvState)

            ivSource.setImageResource(list[position].img)
            tvTitle.text = list[position].title
            tvAuthor.text = list[position].author
            if (list[position].isAvailabe) {
                tvState.text = "Trạng thái sách: Còn"
            }
            else tvState.text = "Trạng thái sách: Hết"
        }
    }
}