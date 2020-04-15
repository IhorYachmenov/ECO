package com.example.eco.book

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eco.R

import kotlinx.android.synthetic.main.activity_main_books.*

class BookMainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_books)

        initParentRV()

    }

    private fun initParentRV() {

        val recyclerView = findViewById<RecyclerView>(R.id.rv_parent)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        val dataList = ArrayList<ModelParent>()
        dataList.add(ModelParent("Загальна екологія"))
        dataList.add(ModelParent("Інженерна екологія"))
        dataList.add(ModelParent("Екологічна економіка"))

        val rvAdapter = RvAdapterParent(dataList)

        recyclerView.adapter = rvAdapter

    }


}