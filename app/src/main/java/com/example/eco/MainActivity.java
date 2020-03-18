package com.example.eco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hide action bar
        getSupportActionBar().hide();

        // Find id of arrow
        ImageView main_arrow = (ImageView) findViewById(R.id.main_arrow);

        // Set action of arrow button
        main_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create intent for calling "ListActivity"
                Intent intentCatalogActivity = new Intent(MainActivity.this, CategoryActivity.class);
                startActivity(intentCatalogActivity);

            }
        });
    }
}
