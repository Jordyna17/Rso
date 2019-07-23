package com.example.rsofinder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class RandomPage extends AppCompatActivity {

    TextView rsoname;
    TextView rsoemail;
    TextView rsodes;

    public RSO tobeused;

    public void setTobeused(RSO newvar ) {

        tobeused = newvar;

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        rsoname = (TextView) findViewById(R.id.RSONAME);
        rsoname.setText(tobeused.org_name);
        
        rsoemail = (TextView) findViewById(R.id.Rsoemail);
        rsoemail.setText(tobeused.email);

        rsodes = (TextView) findViewById(R.id.rsodescription);
        rsodes.setText(tobeused.description);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_page);
    }


}
