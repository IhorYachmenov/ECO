package com.example.eco.book

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eco.R
import com.example.eco.main_category.CategoryActivity
import kotlinx.android.synthetic.main.parent_recycler_books.*
import org.w3c.dom.Text


class BookMainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_books)

        initParentRV()




    }

    private fun initParentRV() {

        val recyclerView = findViewById<RecyclerView>(R.id.rv_parent)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        val dataListChildSectionOne = ArrayList<ModelChild>()
        dataListChildSectionOne.add(ModelChild(R.drawable.section_one_book_one, "Загальна екологія. Навчальний посібник"))
        dataListChildSectionOne.add(ModelChild(R.drawable.section_one_book_two, "Основи екології"))
        dataListChildSectionOne.add(ModelChild(R.drawable.section_one_book_three, "Екологія та охорона навколишнього природного середовища"))
        dataListChildSectionOne.add(ModelChild(R.drawable.section_one_book_four, "Основи екології"))
        dataListChildSectionOne.add(ModelChild(R.drawable.section_one_book_five, "Загальна екологія. Природні наземні екосистеми"))
        dataListChildSectionOne.add(ModelChild(R.drawable.section_one_book_six, "Загальна екологія"))
        dataListChildSectionOne.add(ModelChild(R.drawable.section_one_book_seven, "Загальна і медецинська екологія"))

        val dataListChildSectionTwo = ArrayList<ModelChild>()
        dataListChildSectionTwo.add(ModelChild(R.drawable.section_two_book_one, "Інженерна екологія сільськогосподарського виробництва"))
        dataListChildSectionTwo.add(ModelChild(R.drawable.section_two_book_two, "Інженерна екологія"))
        dataListChildSectionTwo.add(ModelChild(R.drawable.section_two_book_three, "Інженерна екологія. Загальний курс. Частина 1"))
        dataListChildSectionTwo.add(ModelChild(R.drawable.section_two_book_four, "Інженерна екологія та екологічний менеджмент"))
        dataListChildSectionTwo.add(ModelChild(R.drawable.section_two_book_five, "Інженерна екологія. Учебник"))

        val dataListChildSectionThree = ArrayList<ModelChild>()
        dataListChildSectionThree.add(ModelChild(R.drawable.section_three_book_one, "Регіональна економіка та природокористування"))
        dataListChildSectionThree.add(ModelChild(R.drawable.section_three_book_two, "Організаційно-економічні основи екологічно безпечного природокористування"))
        dataListChildSectionThree.add(ModelChild(R.drawable.section_three_book_three, "Зелена революція. Економічний ріст без наслідків для екології"))
        dataListChildSectionThree.add(ModelChild(R.drawable.section_three_book_five, "Екологічна економіка"))

        val dataList = ArrayList<ModelParent>()
        dataList.add(ModelParent("Загальна екологія", dataListChildSectionOne))
        dataList.add(ModelParent("Інженерна екологія", dataListChildSectionTwo))
        dataList.add(ModelParent("Екологічна економіка", dataListChildSectionThree))

        val rvAdapter = RvAdapterParent(dataList)
        recyclerView.adapter = rvAdapter

    }

    companion object {
        lateinit var modelArrayList: ArrayList<ModelParent>
    }

}