package com.example.eco.how_we_can_help;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.eco.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class EcoProgram extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eco_program);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setItemIconTintList(null);

        bottomNavigationView.setSelectedItemId(R.id.action_program);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_how:
                        startActivity(new Intent(getApplicationContext(), ActivityMainHelp.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.action_program:
                        return true;
                }


                return false;
            }
        });
    }
}
