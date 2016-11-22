package com.medlog.medlogmobile;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import com.medlog.medlogmobile.util.NetConnStatus;
import com.medlog.medlogmobile.vo.PatientVO;

import java.util.ArrayList;

import android.util.Log;

public class MainActivity extends AppCompatActivity {
    PatientVO user;
    SeekBar sbMood;
    SeekBar sbProd;
    EditText txtTitle;
    Button btnSubmit;
    SubmitDiaryTask mSubmitTask=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Linkup form widgets
        sbMood = (SeekBar) findViewById(R.id.sbMood);
        sbProd = (SeekBar) findViewById(R.id.sbProductivity);
        txtTitle = (EditText) findViewById(R.id.txtDiaryID);
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
            if (getString(R.string.DEBUG).equals("true")) {
                Log.i(getString(R.string.tag_debug), "User  : " + user.toString());
            }
        }
    }

    private void doSubmitDiary() {
        if (mSubmitTask != null){
            return;//Task already running.
        }
        int prod = sbProd.getProgress();
        int mood = sbMood.getProgress();

        String title = txtTitle.getText().toString();

        if (getString(R.string.DEBUG).equals("true")) {
            Log.i(getString(R.string.tag_debug), "Progress val : " + prod);
            Log.i(getString(R.string.tag_debug), "Mood val : " + mood);
        }
        if (NetConnStatus.getInstance(this).isOnline()){
            //TODO Submit diary
            mSubmitTask = new SubmitDiaryTask(mood,prod,title,user.getPatientID());




            mSubmitTask.execute((Void) null);
        }else{
            //TODO Store locally


        }

    }

    public class SubmitDiaryTask extends AsyncTask<Void, Void, Boolean> {
        private final int mood;
        private final int prod;
        private final String title;
        private final int patientID;

        public SubmitDiaryTask(int mood, int prod, String title, int patientID) {
            this.mood = mood;
            this.prod = prod;//pasdfdsafsfsadfffsdfdsfs
            this.title = title;
            this.patientID = patientID;
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            return null;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
           //Reset
            mSubmitTask = null;
        }
    }
}
