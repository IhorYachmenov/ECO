package com.example.eco.main_category;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.eco.R;
import com.example.eco.all_about_ecology.AllAboutEcology;
import com.example.eco.chat_button.SignInActivity;
import com.example.eco.ecologists.EcologistsActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

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
        categoryResources.add(new Category(R.drawable.about_ecology, R.string.first_category_description));
        categoryResources.add(new Category(R.drawable.why_it_need, R.string.second_category_description));
        categoryResources.add(new Category(R.drawable.how_i_can_help, R.string.third_category_description));
        categoryResources.add(new Category(R.drawable.books_about_ecology, R.string.fourth_category_description));
        categoryResources.add(new Category(R.drawable.famous_ecologists, R.string.fifth_category_description));
        categoryResources.add(new Category(R.drawable.other, R.string.sixth_category_description));

        // Create an {@link CategoryAdapter}, whose data source is a list of {@link Category}s. The
        // adapter knows how to create list items for each item in the list.
        CategoryAdapter adapter = new CategoryAdapter(this, categoryResources);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // list_item.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list_of_category);
        listView.setAdapter(adapter);

        // Set action for listView elements
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Category category = categoryResources.get(position);

                // Set action for "ВСЕ ПРО ЕКОЛОГІЮ"
                if (position == 0){

                    Intent goToAboutEcology = new Intent(view.getContext(), AllAboutEcology.class);
                    startActivity(goToAboutEcology);
                } else if (position == 1){

                }
                else if (position == 2){

                }
                else if (position == 3){

                }
                else if (position == 4){
                    Intent goToScientists = new Intent(view.getContext(), EcologistsActivity.class);
                    startActivity(goToScientists);

                }
                else if (position == 5){

                }


            }
        });

        FloatingActionButton fab = findViewById(R.id.floating_action_button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CategoryActivity.this,"Welcome to eco-chat", Toast.LENGTH_SHORT).show();
                Intent goToEcoChat = new Intent(view.getContext(), SignInActivity.class);
                startActivity(goToEcoChat);
            }
        });

    }

}
