package com.example.eco;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AllAboutEcology extends AppCompatActivity {

    public static TextView data;

    Button click;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_about_ecology);

        data = (TextView) findViewById(R.id.ecology);
        click = (Button) findViewById(R.id.get);


        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FetchData process = new FetchData();
                process.execute();
            }
        });

    }

    private class FetchData extends AsyncTask<Void, Void, Void> {

        String data = "";
        String parsedData = "";

        @Override
        protected Void doInBackground(Void... voids) {

            try {
                URL url = new URL(
                        "https://uk.wikipedia.org/w/api.php?action=parse&page=%D0%95%D0%BA%D0%BE%D0%BB%D0%BE%D0%B3%D1%96%D1%8F&prop=text&formatversion=2&format=json&section=1");
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line = "";

                while (line != null){
                    line = bufferedReader.readLine();
                    data = data + line;
                }

            } catch (MalformedURLException e){
                e.printStackTrace();
            } catch (IOException e){
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            AllAboutEcology.data.setText(this.data);
        }
    }

}
