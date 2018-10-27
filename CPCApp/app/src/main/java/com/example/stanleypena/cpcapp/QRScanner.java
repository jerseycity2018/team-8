package com.example.stanleypena.cpcapp;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
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

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class QRScanner extends AppCompatActivity implements View.OnClickListener{

    public TextView textView;
    public Button scanImage;
    public BarcodeDetector barcodeDetector;
    public ImageView myImageView;
    private FirebaseFirestore db;
    private DocumentReference mDocRef;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrscanner);
        db = FirebaseFirestore.getInstance();
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
            for (int i = 0; i < barcodes.size(); i++) {

            }
            Barcode thisCode = barcodes.valueAt(0);
            Toast.makeText(this, thisCode.rawValue, Toast.LENGTH_SHORT).show();
        }
    }
}

//    Map<String, Object> userData = new HashMap<>();
//        userData.put("Username",userNameEditText.getText().toString().trim());
//                userData.put("Date Created",new Date());
//                userID = FirebaseAuth.getInstance().getCurrentUser();
//                String userUID = userID.getUid();
//                mDocRef = FirebaseFirestore.getInstance().document("users/" + userUID);
//                mDocRef.set(userData).addOnSuccessListener(new OnSuccessListener<Void>() {
//@Override
//public void onSuccess(Void aVoid) {
//        Log.d(TAG,"Document has been saved");
//        }
//        }).addOnFailureListener(new OnFailureListener() {
//@Override
//public void onFailure(@NonNull Exception e) {
//        Log.e(TAG,"Document failed to save");
//        }
//        });