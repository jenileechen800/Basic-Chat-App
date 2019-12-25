package com.hfad.messengerapp5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

//        mToolbar = (Toolbar) findViewById(R.id.main_page_toolbar);
//        setSupportActionBar(mToolbar);
//        getSupportActionBar().setTitle("Lapit Chat");
    }

    @Override
    public void onStart() {
        super.onStart();

        // Check if user is signed in (non-null), update UI accordingly
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if (currentUser == null) {              // because this is null --> current user isn't signed in
                                                // go to this other page
            Intent startIntent = new Intent(MainActivity.this, StartActivity.class);
            startActivity(startIntent);
            finish();
        }
    }
}
