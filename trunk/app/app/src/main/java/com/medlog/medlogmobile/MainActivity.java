package com.medlog.medlogmobile;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import com.google.gson.GsonBuilder;
import com.medlog.medlogmobile.util.Helpers;
import com.medlog.medlogmobile.util.NetConnStatus;
import com.medlog.medlogmobile.vo.DiaryVO;
import com.medlog.medlogmobile.vo.PatientVO;
import com.medlog.medlogmobile.vo.ResponseVO;

import java.io.IOException;
import java.util.ArrayList;

import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    PatientVO user;
    SeekBar sbMood;
    SeekBar sbProd;
    EditText txtTitle;
    EditText txtNotes;
    Button btnSubmit;
    SubmitDiaryTask mSubmitTask = null;
    ArrayList<DiaryVO> diaryVoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar ab = getSupportActionBar();
        setActionBar(ab, "Joural Log");
//        getActionBar().setLogo(R.drawable.ml);
        // Linkup form widgets
        sbMood = (SeekBar) findViewById(R.id.sbMood);
        sbProd = (SeekBar) findViewById(R.id.sbProductivity);
        txtTitle = (EditText) findViewById(R.id.txtDiaryID);
        btnSubmit = (Button) findViewById(R.id.btnDiaryFormSubmit);
        txtNotes = (EditText) findViewById(R.id.txtNotes);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
        SharedPreferences spf = getPreferences(MODE_PRIVATE);           //get old user data and place them into storage
        boolean hasData = spf.getBoolean(getString(R.string.lcl_db_hasdata), false);
        if (hasData) {
            String oldData = spf.getString(getString(R.string.lcl_db_data), "");
           diaryVoList= DiaryVO.fromJSON(oldData);
            Toast.makeText(getApplicationContext(), new StringBuilder().append(diaryVoList.size()+ " previous entries found.").append(NetConnStatus.getInstance(this).isOnline() ? " You are ONLINE. Syncing...": " You are offline. Entries will be saved." ).toString(), Toast.LENGTH_LONG).show();

        }


    }

    private void doSubmitDiary() {
        if (mSubmitTask != null) {
            return;//Task already running.
        }
        String notes = "";
        if (txtNotes != null) {
            notes = Helpers.toS(txtNotes.getText().toString(), "");
        }
        if (diaryVoList == null) {
            diaryVoList = new ArrayList<DiaryVO>();
        }
        diaryVoList.add(DiaryVO.builder().mood(sbMood.getProgress()).productivity(sbProd.getProgress())
                .title(Helpers.toS(txtTitle.getText().toString(), "Entry")).notes(notes).build());

        if (NetConnStatus.getInstance(this).isOnline()) {
            //TODO Submit diary
            mSubmitTask = new SubmitDiaryTask(diaryVoList, user.getPatientID());


            mSubmitTask.execute((Void) null);
        } else {
            //TODO Store locally


        }

    }

    public class SubmitDiaryTask extends AsyncTask<Void, Void, Integer> {

        private final int patientID;
        ArrayList<DiaryVO> voList;

        public SubmitDiaryTask(ArrayList<DiaryVO> vList, int patientID) {
            voList = vList;
            this.patientID = patientID;
        }

        @Override
        protected Integer doInBackground(Void... voids) {
            int cts = 0;
            for (DiaryVO vo : voList) {
                String tURL = getString(R.string.api_prefix) + vo.getURLString(patientID);
                try {
                    ResponseVO rVO = Helpers.getDiaryUrlSource(tURL);
                    cts++;
                    Log.i(getString(R.string.tag_async), rVO.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return cts;
        }

        @Override
        protected void onPostExecute(final Integer ct) {
            //Reset
            mSubmitTask = null;
            if (ct >= voList.size()) {
                voList.clear();
                Log.i(getString(R.string.tag_debug), "list size:" + diaryVoList.size());
                diaryVoList.clear();
                Toast.makeText(getApplicationContext(), new StringBuilder().append(ct + " ").append(" item(s) added saved!").toString(), Toast.LENGTH_LONG).show();

            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences prf = getPreferences(MODE_PRIVATE);           //saves all symbols of past portfolio
        SharedPreferences.Editor e = prf.edit();
        if (diaryVoList != null && diaryVoList.size() > 0) {
            String json = new GsonBuilder().serializeNulls().create().toJson(diaryVoList);
            e.putString(getString(R.string.lcl_db_data), json);
            e.putBoolean(getString(R.string.lcl_db_hasdata), true);
        } else {
            e.putBoolean(getString(R.string.lcl_db_hasdata), false);
            e.remove(getString(R.string.lcl_db_data));
        }


    }

    public void setActionBar(ActionBar actionBar, String heading) {
        // TODO Auto-generated method stub

//    ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setIcon(R.drawable.ml);
//        actionBar.set
//    actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimaryDark)));
        actionBar.setTitle(heading);
        actionBar.setLogo(R.drawable.ml);


        actionBar.show();

    }
}