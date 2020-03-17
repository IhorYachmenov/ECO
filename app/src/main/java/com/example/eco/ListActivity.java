package com.example.eco;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_of_category);

        // Hide action bar on "ListActivity"
        getSupportActionBar().hide();
    }
}
