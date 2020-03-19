package com.example.eco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;


public class MainActivity extends AppCompatActivity {

    // Animation variable
    private Animation pulse;

    // Shimmer textView variable
    ShimmerTextView textShimmer;

    //Shimmer object variable
    Shimmer shimmer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hide action bar
        getSupportActionBar().hide();

        // Find id of arrow
        ImageView main_arrow = (ImageView) findViewById(R.id.main_leaf);

        // Set action of arrow button
        main_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create intent for calling "ListActivity"
                Intent intentCatalogActivity = new Intent(MainActivity.this, CategoryActivity.class);
                startActivity(intentCatalogActivity);

            }
        });

        // Initialize shimmer object
        textShimmer = (ShimmerTextView) findViewById(R.id.shimmer_text_main_screen);
        // Initialize shimmer object
        shimmer = new Shimmer();
        // Start shimmer animation
        shimmer.start(textShimmer);

        // Initialize ImageView object
        ImageView leaf = (ImageView) findViewById(R.id.main_leaf);
        // Initialize animation pulse
        pulse = AnimationUtils.loadAnimation(this, R.anim.pulse);
        // Start animation
        leaf.startAnimation(pulse);

        // Initialize ImageView object
        ImageView eco = (ImageView) findViewById(R.id.eco_text_logo);
        // Initialize animation pulse
        pulse = AnimationUtils.loadAnimation(this, R.anim.pulse_eco);
        // Start animation
        eco.startAnimation(pulse);

    }
}
