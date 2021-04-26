package com.mainCity.ui.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.mainCity.R;
import com.mainCity.ui.login.LoginActivity;

/**
 * This is the launch activity that will launch when the app is opened.
 * I added a nice background image to show up and it can make the app launch loading looks better.
 */
public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(LaunchActivity.this, LoginActivity.class));
                LaunchActivity.this.finish();
            }
        }, 1700);
    }
}