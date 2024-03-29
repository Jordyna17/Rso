package com.example.rsofinder;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static App a;
    private static int SPLASH_TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(MainActivity.this, HomePage.class);
                startActivity(homeIntent);
                finish();
            }

        }, SPLASH_TIME_OUT);

        try {

            a = test();
            System.out.println(a.RSO.length);


        } catch(Exception e) {
            System.out.println("fail");
        }

    }

    private static String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }

    public static void main(String args[]) throws Exception {
        String json = readUrl("https://pastebin.com/raw/6krt1cbb");

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        App page = gson.fromJson(json, App.class);

    }





    public String readJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("json.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public App test() throws Exception {
        String json = readJSONFromAsset();

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        App page = gson.fromJson(json, App.class);

        return page;
    }

    public ArrayList<RSO> findTags(String[] tags) {



        ArrayList<RSO> matches = new ArrayList<>();

        for(int i = 0; i < a.RSO.length; i++) {
            for (int j = 0; j < tags.length; j++) {
                if (a.RSO[i].equals(tags[j]) && !matches.contains(a.RSO)) {

                    matches.add(a.RSO[i]);

                }
            }

        }
        return matches;

    }

    public ArrayList<RSO> findName(String name) {

        ArrayList<RSO> matches = new ArrayList<>();

        for (int i = 0; i < a.RSO.length; i++) {
            if (name.equals(a.RSO[i].org_name)) {
                matches.add(a.RSO[i]);
            }
        }


        return matches;

    }





}
