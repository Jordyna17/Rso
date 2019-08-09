package com.example.rsofinder;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.Random;

public class HomePage extends Activity implements View.OnClickListener{

    Button button;
    Button randombutton;

    public App app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        button = (Button) findViewById(R.id.List);
        button.setOnClickListener(HomePage.this);

        randombutton = (Button) findViewById(R.id.Dice);
        randombutton.setOnClickListener(HomePage.this);

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.List) {
            System.out.println("testforlist");
            openActivity2();

        }

        if (v.getId() == R.id.Dice) {
            System.out.println("test!");

            Random ran = new Random();

            RandomPage r = new RandomPage();

            try {
                //app = MainActivity.test();
                System.out.println(app.RSO.length);

            } catch (Exception e) {
                System.out.println("dice app failed");
            }

            r.setTobeused(app.RSO[ran.nextInt(app.RSO.length)]);


            openRandomPage();
        }

    }


    public void openActivity2() {
        Intent intent = new Intent(HomePage.this, listpage.class);
        startActivity(intent);

    }

    public void openRandomPage() {
        Intent intent = new Intent(HomePage.this, RandomPage.class);
        startActivity(intent);



    }


}
