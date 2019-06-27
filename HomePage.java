package com.example.rsofinder;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends Activity implements View.OnClickListener{

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        button = (Button) findViewById(R.id.List);
        button.setOnClickListener(HomePage.this);

    }

    @Override
    public void onClick(View v) {
        openActivity2();
    }

    public void openActivity2() {
        Intent intent = new Intent(HomePage.this, listpage.class);
        startActivity(intent);

    }


}
