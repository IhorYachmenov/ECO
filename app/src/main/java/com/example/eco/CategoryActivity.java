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

        // Hide action bar
        getSupportActionBar().hide();

        // Create category
        final ArrayList<Category> categoryResources = new ArrayList<Category>();
        categoryResources.add(new Category(R.drawable.earth, R.string.first_category_description));
        categoryResources.add(new Category(R.drawable.earth, R.string.second_category_description));
        categoryResources.add(new Category(R.drawable.earth, R.string.third_category_description));
        categoryResources.add(new Category(R.drawable.earth, R.string.fourth_category_description));
        categoryResources.add(new Category(R.drawable.earth, R.string.fifth_category_description));
        categoryResources.add(new Category(R.drawable.earth, R.string.sixth_category_description));

        // Create an {@link CategoryAdapter}, whose data source is a list of {@link Category}s. The
        // adapter knows how to create list items for each item in the list.
        CategoryAdapter adapter = new CategoryAdapter(this, categoryResources);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // list_item.xml layout file.
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
