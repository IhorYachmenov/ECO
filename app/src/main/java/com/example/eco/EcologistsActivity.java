package com.example.eco;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

import java.util.ArrayList;

public class EcologistsActivity extends AppCompatActivity  {

    private static final String TAG = "EcologistsActivity";

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mDates = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    private YouTubePlayerSupportFragment youTubePlayerFragment;
    //youtube player to play video when new video selected
    private YouTubePlayer youTubePlayer;

    private String ID_video = "1Y0aao1w1TI";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ecologists);

        getImages();
        initializeYoutubePlayer();
    }

    private void getImages(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("https://upload.wikimedia.org/wikipedia/uk/2/21/Stanislav_Shwarts.jpg");
        mNames.add("Шварц Станіслав Семенович");
        mDates.add("1918-1976");

        mImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/thumb/3/37/Ivan_Borodin_-_il103.jpg/250px-Ivan_Borodin_-_il103.jpg");
        mNames.add("Бородін Іван Парфенійович");
        mDates.add("1847-1930");

        mImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/thumb/3/3b/Ernst_Haeckel_1860.jpg/250px-Ernst_Haeckel_1860.jpg");
        mNames.add("Ернст Геккель");
        mDates.add("1834-1919");

        mImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a8/Karl_August_M%C3%B6bius_%281825-1908%29.jpg/250px-Karl_August_M%C3%B6bius_%281825-1908%29.jpg");
        mNames.add("Карл Август Мебіус");
        mDates.add("1825-1908");


        mImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Ramensky-Leonty_1884-1953.jpg/234px-Ramensky-Leonty_1884-1953.jpg");
        mNames.add("Раменский, Леонтий Григорьевич");
        mDates.add("1884-1953");

        mImageUrls.add("https://upload.wikimedia.org/wikipedia/ru/thumb/b/be/NF_Reimers.jpg/220px-NF_Reimers.jpg");
        mNames.add("Реймерс Микола Федорович");
        mDates.add("1931-1993");

        mImageUrls.add("https://upload.wikimedia.org/wikipedia/uk/thumb/d/da/Suduk_Olena_4668.JPG/225px-Suduk_Olena_4668.JPG");
        mNames.add("Судук Олена Юріївна");
        mDates.add("1977");

        mImageUrls.add("https://upload.wikimedia.org/wikipedia/uk/thumb/b/b6/Zhyla_u_Sagajdaka_1-02-2015_crop.jpg/225px-Zhyla_u_Sagajdaka_1-02-2015_crop.jpg");
        mNames.add("Жила Сергій Миколайович");
        mDates.add("1959");

        mImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d7/%D0%A2%D1%83%D0%BD%D0%B8%D1%86%D1%8F_%D0%AE%D1%80%D1%96%D0%B9_%D0%AE%D1%80%D1%96%D0%B9%D0%BE%D0%B2%D0%B8%D1%87.png/225px-%D0%A2%D1%83%D0%BD%D0%B8%D1%86%D1%8F_%D0%AE%D1%80%D1%96%D0%B9_%D0%AE%D1%80%D1%96%D0%B9%D0%BE%D0%B2%D0%B8%D1%87.png");
        mNames.add("Туниця Юрій Юрійович");
        mDates.add("1941");

        initRecyclerView();

    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImageUrls, mDates);
        recyclerView.setAdapter(adapter);
    }

    private void initializeYoutubePlayer() {

        youTubePlayerFragment = (YouTubePlayerSupportFragment) getSupportFragmentManager()
                .findFragmentById(R.id.youtube_player_fragment);

        if (youTubePlayerFragment == null)
            return;

        youTubePlayerFragment.initialize(PlayerConfig.API_KEY, new YouTubePlayer.OnInitializedListener() {

            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player,
                                                boolean wasRestored) {
                if (!wasRestored) {
                    youTubePlayer = player;

                    //set the player style default
                    youTubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);

                    //cue the 1st video by default
                    youTubePlayer.cueVideo(ID_video);
                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider arg0, YouTubeInitializationResult arg1) {

                //print or show error if initialization failed
                Log.e(TAG, "Youtube Player View initialization failed");
            }
        });
    }

}
