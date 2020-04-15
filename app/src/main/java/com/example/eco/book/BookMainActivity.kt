package com.example.eco.book

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eco.R

class BookMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_books)

        initParentRV()
    }

    private fun initParentRV() {

        val recyclerView = findViewById<RecyclerView>(R.id.rv_parent)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        val dataListChild = ArrayList<ModelChild>()
        dataListChild.add(ModelChild(R.drawable.aviator, "Book 1"))
        dataListChild.add(ModelChild(R.drawable.aviator, "Book 2"))
        dataListChild.add(ModelChild(R.drawable.aviator, "Book 3"))
        dataListChild.add(ModelChild(R.drawable.aviator, "Book 4"))
        dataListChild.add(ModelChild(R.drawable.aviator, "Book 5"))
        dataListChild.add(ModelChild(R.drawable.aviator, "Book 6"))
        dataListChild.add(ModelChild(R.drawable.aviator, "Book 7"))


        val dataList = ArrayList<ModelParent>()
        dataList.add(ModelParent("Загальна екологія", dataListChild))
        dataList.add(ModelParent("Інженерна екологія", dataListChild))
        dataList.add(ModelParent("Екологічна економіка", dataListChild))

        val rvAdapter = RvAdapterParent(dataList)
        recyclerView.adapter = rvAdapter

    }

}