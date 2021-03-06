package com.example.eco.book

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eco.R
import kotlinx.android.synthetic.main.parent_recycler_books.view.*


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
        holder.recyclerView.apply { layoutManager = LinearLayoutManager(holder.recyclerView.context, LinearLayout.HORIZONTAL, false)
        adapter = RvAdapterChild(userList[position].children)

        }

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val name: TextView = itemView.findViewById(R.id.textView)
        val recyclerView : RecyclerView = itemView.rv_child

        //, View.OnClickListener
//        init {
//            name.setOnClickListener(this)
//        }
//
//        override fun onClick(v: View) {
//            TODO("Not yet implemented")
//
//        }

    }



}
