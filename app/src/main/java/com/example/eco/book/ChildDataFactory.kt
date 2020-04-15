package com.example.eco.book

import com.example.eco.R

object ChildDataFactory {

    private fun arrayOfImage() : Int {
        val image = arrayListOf(R.drawable.aviator)
        val index = image.size
         return image[index]

    }

    private fun arrayOfDescription() : String {
        val description = arrayListOf("Book 1")
        val index = description.size
        return description[index]

    }

    fun getChildren(count : Int) : MutableList<ModelChild> {
        val children = mutableListOf<ModelChild>()
        repeat(count) {
            val child = ModelChild(arrayOfImage(), arrayOfDescription())
            children.add(child)
        }
        return children
    }
}