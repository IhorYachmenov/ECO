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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_about_ecology);

        data = (TextView) findViewById(R.id.ecology);

        FetchData process = new FetchData();
        process.execute();

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

                JSONObject reader = new JSONObject(data);
                JSONObject sys  = reader.getJSONObject("parse");
                parsedData = sys.getString("text");
                parsedData = deleteTagsFromParseData(parsedData);
                parsedData = changeText(parsedData);

            } catch (MalformedURLException e){
                e.printStackTrace();
            } catch (IOException e){
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            AllAboutEcology.data.setText(this.parsedData);
        }

        public String deleteTagsFromParseData(String html) {
            return Jsoup.parse(html).text();
        }

        public  String changeText(String text){


            Spanned hyperlink =  Html.fromHtml(
                    "<a href=\"http://www.stackoverflow.com\">Сучасна екологія</a> ");

            // Unnecessary data
            String firstUnnecessaryData = "Головні розділи[ред. | ред. код] ";
            String secondUnnecessaryData = "[уточнити]";
            String textDescriptionOfPicture = "Через негативні зміни в екосистемі, сучасні пташки почали застосовувати «новітні матеріали» для будівництва гнізд (стільки сміття у лісах). Миколаїв, 2018.";

            // Create paragraph
            String firstParagraph = "У структурі";
            String secondParagraph = "Загальна екологія охоплює";
            String thirdParagraph = "Загальна екологія вивчає";
            String fourthParagraph = "Спеціальна екологія";
            String fifthParagraph = "Розділами спеціальної";
            String sixthParagraph = "Прикладна екологія";
            String seventhParagraph = "Таким чином";
            String eighthParagraph = "Екологія є науковою ";

            text = text.replace(firstUnnecessaryData,"");
            text = text.replace(secondUnnecessaryData,"");
            text = text.replace(textDescriptionOfPicture,"");

            text = text.replace(firstParagraph,"\n \n" + firstParagraph);
            text = text.replace(secondParagraph,"\n \n" + secondParagraph);
            text = text.replace(thirdParagraph,"\n \n" + thirdParagraph);
            text = text.replace(fourthParagraph,"\n \n" + fourthParagraph);
            text = text.replace(fifthParagraph,"\n \n" + fifthParagraph);
            text = text.replace(sixthParagraph,"\n \n" + sixthParagraph);
            text = text.replace(seventhParagraph,"\n \n" + seventhParagraph);
            text = text.replace(eighthParagraph,"\n \n" + eighthParagraph);

            // Create list
            text = text.replace("сільськогосподарська екологія","\n \n" + " - сільськогосподарська екологія");
            text = text.replace("екологічний моніторинг","\n" + " - екологічний моніторинг");
            text = text.replace("екологічна токсикологія","\n" + " - екологічна токсикологія");
            text = text.replace("управління екосистемами","\n" + " - управління екосистемами");
            text = text.replace("заповідна справа","\n" + " - заповідна справа");
            text = text.replace("наукові основи охорони довкілля","\n" + " - наукові основи охорони довкілля");
            text = text.replace("геоекологія","\n" + " - геоекологія");
            text = text.replace("соціальна екологія","\n" + " - соціальна екологія");
            text = text.replace("техноекологія","\n" + " - техноекологія");

            // text = text.replace("Сучасна екологія",hyperlink);

            return text;
        }
    }

}
