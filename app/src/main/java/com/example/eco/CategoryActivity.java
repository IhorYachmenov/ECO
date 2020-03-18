package com.example.eco;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_activity);

        getSupportActionBar().hide();

        final ArrayList<Category> categoryResources = new ArrayList<Category>();
        categoryResources.add(new Category(R.drawable.earth, "Category"));

        CategoryAdapter adapter = new CategoryAdapter(this,categoryResources);

        ListView listView = (ListView) findViewById(R.id.list_of_category);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Category category = categoryResources.get(position);
            }
        });
    }
}
