package com.example.eco;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class EcologistsActivity extends AppCompatActivity {

    private static final String TAG = "EcologistsActivity";

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scientists);

        getImages();

//        setContentView(R.layout.scientists);
//
//        // Find the view pager that will allow the user to swipe between fragments
//        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
//
//        // Create an adapter that knows which fragment should be shown on each page
//        /**
//         Since we modified the CategoryAdapter constructor, we also need to update the MainActivity (which uses that constructor).
//         When we create a CategoryAdapter, we pass in a Context (which is “this” or the activity) and the FragmentManager.
//         */
//        EcologistAdapter adapter = new EcologistAdapter(this, getSupportFragmentManager());
//
//        // Set the adapter onto the view pager
//        viewPager.setAdapter(adapter);
//
//        // Find the tab layout that shows the tabs
//        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
//
//        // Connect the tab layout with the view pager. This will
//        //   1. Update the tab layout when the view pager is swiped
//        //   2. Update the view pager when a tab is selected
//        //   3. Set the tab layout's tab names with the view pager's adapter's titles
//        //      by calling onPageTitle()
//        tabLayout.setupWithViewPager(viewPager);
    }

    private void getImages(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        mNames.add("Havasu Falls");

        mImageUrls.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        mNames.add("Trondheim");

        mImageUrls.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        mNames.add("Portugal");

        mImageUrls.add("https://i.redd.it/j6myfqglup501.jpg");
        mNames.add("Rocky Mountain National Park");


        mImageUrls.add("https://i.redd.it/0h2gm1ix6p501.jpg");
        mNames.add("Mahahual");

        mImageUrls.add("https://i.redd.it/k98uzl68eh501.jpg");
        mNames.add("Frozen Lake");


        mImageUrls.add("https://i.redd.it/glin0nwndo501.jpg");
        mNames.add("White Sands Desert");

        mImageUrls.add("https://i.redd.it/obx4zydshg601.jpg");
        mNames.add("Austrailia");

        mImageUrls.add("https://i.imgur.com/ZcLLrkY.jpg");
        mNames.add("Washington");

        initRecyclerView();

    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImageUrls);
        recyclerView.setAdapter(adapter);
    }

}
