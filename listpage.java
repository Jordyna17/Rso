package com.example.rsofinder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class listpage extends AppCompatActivity {

    ListView listView;
    List list = new ArrayList();
    CustomAdapter adapter;
    App list2;
    String[] chesslist = {"cool", "fun", "awesome"};

    RSO a = new RSO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listpage);

        listView = findViewById(R.id.list_view);


        a.org_name = "chess club";
        a.email = "chess.org";
        a.leader = "mihir";
        a.tags = chesslist;

        list.add(a);




        /*try {
            list2 = MainActivity.test();

        } catch(Exception e) {

            System.out.println("fail!");

        }*/

        //adapter = new CustomAdapter(listpage.this, list2.RSO);

        //listView.setAdapter(adapter);


    }




}
