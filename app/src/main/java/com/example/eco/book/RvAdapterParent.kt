package com.example.eco.book

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.eco.R


class RvAdapterParent(private val userList: ArrayList<ModelParent>) : RecyclerView.Adapter<RvAdapterParent.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = LayoutInflater.from(parent?.context).inflate(R.layout.parent_recycler_books, parent, false)
        return ViewHolder(v);
    }

    override fun getItemCount(): Int {

        return userList.size
    }

    override fun onBindViewHolder(holder: RvAdapterParent.ViewHolder, position: Int) {

        holder.name?.text = userList[position].name

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.textView)

    }
}