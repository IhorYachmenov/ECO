package com.example.eco.how_we_can_help;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.eco.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class EcoProgram extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private WebView webview;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eco_program);

        getSupportActionBar().hide();

        webview = (WebView) findViewById(R.id.web_view);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl("https://docs.google.com/viewer?url=https://gp.org.ua/images/reports/eco_program.pdf");

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
