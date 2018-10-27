package com.example.stanleypena.cpcapp;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.graphics.Bitmap;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button camera;
    Button urcode;
    ImageView hardCode1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        camera = findViewById(R.id.camerab);
        urcode = findViewById(R.id.urb);
        hardCode1 = findViewById(R.id.imageView);

        camera.setOnClickListener(this);
        urcode.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == findViewById(R.id.urb)) {
            Intent urintent = new Intent(this, QRScanner.class);
            startActivity(urintent);
        } else if (v == findViewById(R.id.camerab)) {
            dispatchTakePictureIntent();
        }
    }

    static final int REQUEST_IMAGE_CAPTURE = 1;

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
        startActivity(takePictureIntent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
//            hardCode1.setImageBitmap(imageBitmap);
        }
    }

}