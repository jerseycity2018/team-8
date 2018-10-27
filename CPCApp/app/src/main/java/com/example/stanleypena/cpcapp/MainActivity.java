package com.example.stanleypena.cpcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button camera;
    Button urcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        camera = (Button) findViewById(R.id.camerab);
        urcode = (Button) findViewById(R.id.urb);



    }

    public void actionButton(View view) {
        Intent urintent = new Intent(this, QRScanner.class);
        startActivity(urintent);

        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(intent);

    }
}
