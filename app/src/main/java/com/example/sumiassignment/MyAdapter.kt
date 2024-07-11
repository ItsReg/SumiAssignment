package com.example.sumiassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MyAdapter(
    private val data: List<ImageData>,
                private val onItemClick: (ImageData) -> Unit) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    inner class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(imageData: ImageData) {
            view.setOnClickListener {
                onItemClick(imageData)
            }

            val title = view.findViewById<TextView>(R.id.tvTitle)
            val description = view.findViewById<TextView>(R.id.tvDescription)

            title.text = imageData.title
            description.text = imageData.url
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data[position])
        val item = data[position]
    }
}