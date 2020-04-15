package com.example.eco.book

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.eco.R

class RvAdapterChild(private val userList: ArrayList<ModelChild>) : RecyclerView.Adapter<RvAdapterChild.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.child_recycler_books, parent, false)
        return RvAdapterChild.ViewHolder(v);
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.descriptionOfBook?.text = userList[position].description
        holder.imageOfBook?.setImageResource(userList[position].image)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageOfBook = itemView.findViewById<ImageView>(R.id.child_imageView)
        val descriptionOfBook = itemView.findViewById<TextView>(R.id.child_textView)
    }
}