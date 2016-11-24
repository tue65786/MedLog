package com.medlog.medlogmobile;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
    private View mProgressView;
    private View mFormView;
    SubmitDiaryTask mSubmitTask = null;
    ArrayList<DiaryVO> diaryVoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar ab = getSupportActionBar();
        setActionBar(ab, "Jounral Log");
//        getActionBar().setLogo(R.drawable.ml);
        // Linkup form widgets
        sbMood = (SeekBar) findViewById(R.id.sbMood);
        sbProd = (SeekBar) findViewById(R.id.sbProductivity);
        txtTitle = (EditText) findViewById(R.id.txtDiaryID);
        btnSubmit = (Button) findViewById(R.id.btnDiaryFormSubmit);
        txtNotes = (EditText) findViewById(R.id.txtNotes);
        mFormView = findViewById(R.id.mainact_form);
        mProgressView = findViewById(R.id.main_progress);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                doSubmitDiary(true);
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.btnSync:
                  if (diaryVoList != null && diaryVoList.size() > 0){
                      showProgress(true);doSubmitDiary(false);
                  return true;
                  }
                else{
                      showProgress(true);
                      try {

                          // Simulate network access.
                          Thread.sleep(1500);
                      } catch (InterruptedException e) {
                          showProgress(false);
                      }
                      showProgress(false);
                      Toast.makeText(getApplicationContext(), new StringBuilder().append( " Nothing to sync").toString(), Toast.LENGTH_LONG).show();

                  }
                break;
            case R.id.rpt:
                Intent mainI = new Intent( MainActivity.this,ReportActivity.class);
//                mainI.putExtra(getString(R.string.int_user), (Parcelable) user);
               startActivity(mainI);
                break;

        }
        return false;
    }

            private void doSubmitDiary(boolean withForm) {
        if (mSubmitTask != null) {
            return;//Task already running.
        }
        if (withForm) {
            String notes = "";
            if (txtNotes != null) {
                notes = Helpers.toS(txtNotes.getText().toString(), "");
            }
            if (diaryVoList == null) {
                diaryVoList = new ArrayList<DiaryVO>();
            }
            diaryVoList.add(DiaryVO.builder().mood(sbMood.getProgress()).productivity(sbProd.getProgress())
                    .title(Helpers.toS(txtTitle.getText().toString(), "Entry")).notes(notes).build());
        }
        if (NetConnStatus.getInstance(this).isOnline()) {
            //TODO Submit diary
            showProgress(true);
            mSubmitTask = new SubmitDiaryTask(diaryVoList, user.getPatientID());


            mSubmitTask.execute((Void) null);
        } else {

            Log.i(getString(R.string.tag_debug), "offline store list size:" + diaryVoList.size());


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
            try {
                // Simulate network access.
                Thread.sleep(500);
            } catch (InterruptedException e) {

            }
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
            showProgress(false);
            if (ct >= voList.size()) {
                voList.clear();
                Log.i(getString(R.string.tag_debug), "list size:" + diaryVoList.size());
                diaryVoList.clear();
                Toast.makeText(getApplicationContext(), new StringBuilder().append(ct + " ").append(" item(s) added saved!").toString(), Toast.LENGTH_LONG).show();

            }
        }
        @Override
        protected void onCancelled() {
            mSubmitTask = null;
            showProgress(false);
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
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
//        MenuItem item = getToolbar().getMenu().findItem(Menu.FIRST);
//
//        Animation animation = new RotateAnimation(0.0f, 360.0f,
//                Animation.RELATIVE_TO_SELF, 0.5f,
//                Animation.RELATIVE_TO_SELF, 0.5f);
//        animation.setDuration(700);
//        animation.setRepeatCount(Animation.INFINITE);
//
//        ImageView imageView = new ImageView(this);
//        imageView.setImageDrawable(UIHelper.getIcon(this, MMEXIconFont.Icon.mmx_refresh));
//
//        imageView.startAnimation(animation);
//        item.setActionView(imageView);
    }
}