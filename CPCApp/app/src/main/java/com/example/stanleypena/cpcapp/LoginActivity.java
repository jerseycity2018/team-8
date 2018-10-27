package com.example.stanleypena.cpcapp;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.List;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    // UI references.
    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;
    EditText userName;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Init all buttons, find views etc.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        firebaseAuth = FirebaseAuth.getInstance();
        userName = findViewById(R.id.email);
        password = findViewById(R.id.password);
        progressDialog = new ProgressDialog(this);

        Button b = findViewById(R.id.emailSignIn);
        Button r = findViewById(R.id.create_account);
        b.setOnClickListener(this);
        r.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // Sign in
        if (v == findViewById(R.id.emailSignIn)) {
            if (TextUtils.isEmpty(userName.getText())) {
                Toast.makeText(this, "Please enter a email", Toast.LENGTH_SHORT).show();
                return;
            }
            if (TextUtils.isEmpty(password.getText())) {
                Toast.makeText(this, "Please enter a valid password", Toast.LENGTH_SHORT).show();
                return;
            }
            userLogIn();
            // Register account
        } else if (v == findViewById(R.id.create_account)) {
            Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
            startActivity(intent);
        }
    }

    private void userLogIn() {
        progressDialog.setMessage("Logging you in!");
        progressDialog.show();
        // Sign in here!
        firebaseAuth.signInWithEmailAndPassword(userName.getText().toString().trim(),password.getText().toString().trim()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    // If already signed in will not create new activity?
                    progressDialog.hide();
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                } else {
                    progressDialog.hide();
                    Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

}

