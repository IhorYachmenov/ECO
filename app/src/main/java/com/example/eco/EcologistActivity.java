package com.example.eco;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EcologistActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_ecologist);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new EcologistFragment())
                .commit();
    }
}
