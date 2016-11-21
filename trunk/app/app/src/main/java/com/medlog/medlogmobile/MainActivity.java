package com.medlog.medlogmobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.medlog.medlogmobile.vo.PatientVO;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    PatientVO user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent receivedIntent = getIntent();
        //Load user info.
        if (receivedIntent != null) {
            user = receivedIntent.getParcelableExtra(getString(R.string.int_user));

        }
    }
}
