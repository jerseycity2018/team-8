package com.example.stanleypena.cpcapp;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button camera;
    Button urcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        camera = findViewById(R.id.camerab);
        urcode = findViewById(R.id.urb);

        camera.setOnClickListener(this);
        urcode.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == findViewById(R.id.urb)) {
            Intent urintent = new Intent(this, QRScanner.class);
            startActivity(urintent);
        } else if (v == findViewById(R.id.camerab)) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(intent);
        }
    }
}