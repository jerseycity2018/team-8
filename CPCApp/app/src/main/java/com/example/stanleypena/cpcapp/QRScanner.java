package com.example.stanleypena.cpcapp;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.net.Uri;
import java.io.File;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;


import java.io.IOException;

public class QRScanner extends AppCompatActivity implements View.OnClickListener{

    TextView textView;
    Button scanImage;
    BarcodeDetector barcodeDetector;
    ImageView myImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrscanner);
        scanImage = findViewById(R.id.scanButton);
        // load image
        myImageView = (ImageView) findViewById(R.id.qrTest);
        scanImage.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == findViewById(R.id.scanButton)) {
            Bitmap imageBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.puppy);
            myImageView.setImageBitmap(imageBitmap);
            // Set up qr checker
            barcodeDetector =
                    new BarcodeDetector.Builder(getApplicationContext())
                            .setBarcodeFormats(Barcode.DATA_MATRIX | Barcode.QR_CODE)
                            .build();
            if(!barcodeDetector.isOperational()){
                Log.e("Barcode","NOT WORKING!!!");
                return;
            }
            Frame frame = new Frame.Builder().setBitmap(imageBitmap).build();
            SparseArray<Barcode> barcodes = barcodeDetector.detect(frame);

            // Decode
            Barcode thisCode = barcodes.valueAt(0);
            Toast.makeText(this, thisCode.rawValue, Toast.LENGTH_SHORT).show();
        }
    }
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        String potato = Integer.toString(requestCode);
//        Log.e("test",potato);
//        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
//            Bundle extras = data.getExtras();
//            Bitmap imageBitmap = (Bitmap) extras.get("data");
//
//        }
//
//    }
}
