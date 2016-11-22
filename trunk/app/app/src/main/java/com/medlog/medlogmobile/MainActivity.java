package com.medlog.medlogmobile;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import com.medlog.medlogmobile.vo.PatientVO;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    PatientVO user;
    SeekBar sbMood;
    SeekBar sbProd;
    EditText txtTitle;
    Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sbMood = (SeekBar) findViewById(R.id.sbMood);
        sbProd = (SeekBar) findViewById(R.id.sbProductivity);
        txtTitle =(EditText) findViewById(R.id.txtDiaryID);
        btnSubmit = (Button) findViewById(R.id.btnDiaryFormSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // attemptLogin();
                doSubmitDiary();
            }
        });
        Intent receivedIntent = getIntent();
        //Load user info.
        if (receivedIntent != null) {
            user = receivedIntent.getParcelableExtra(getString(R.string.int_user));

        }
    }

    private void doSubmitDiary() {
        int prod = sbProd.getProgress();
        int mood = sbMood.getProgress();
        String password = txtTitle.getText().toString();
    }

    public class SubmitDiaryTask extends AsyncTask<Void, Void, Boolean> {
        private final int mood;
        private final int prod;
        private final String title;
        private final int patientID;

        public SubmitDiaryTask(int mood, int prod, String title, int patientID) {
            this.mood = mood;
            this.prod = prod;
            this.title = title;
            this.patientID = patientID;
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            return null;
        }
        @Override
        protected void onPostExecute(final Boolean success) {

        }
    }
}
