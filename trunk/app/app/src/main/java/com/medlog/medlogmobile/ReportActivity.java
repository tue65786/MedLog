package com.medlog.medlogmobile;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.medlog.medlogmobile.vo.DiaryVO;
import com.medlog.medlogmobile.vo.PatientVO;

/**
 * Produces line graph
 */
public class ReportActivity extends AppCompatActivity {
    GraphView graphView;
    String userString;
    PatientVO user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        graphView = (GraphView) findViewById(R.id.graph);
        Intent receivedIntent = getIntent();
        //Load user info.
        if (receivedIntent != null) {
            user = getUserFromIntent(receivedIntent);
            getSupportActionBar().setTitle(user.getUserName() +  " Journal Report");
            if (getString(R.string.DEBUG).equals("true")) {
                Log.i(getString(R.string.tag_debug), "User  : " + user.toString());
            }
        }
        initGraph(graphView, user);
    }

    private PatientVO getUserFromIntent(Intent receivedIntent) {
        userString = receivedIntent.getStringExtra(getString(R.string.intent_val_user_json));
        return  PatientVO.fromJSON(userString);
    }

    public void initGraph(GraphView graph, PatientVO user) {

        DataPoint[] moods = new DataPoint[user.getDiaryList().size()];
        DataPoint[] prods = new DataPoint[user.getDiaryList().size()];

        for (int i = 0; i < user.getDiaryList().size(); i++) {
            DiaryVO d = user.getDiaryList().get(i);
            moods[i] = new DataPoint(i, d.getMood());

            prods[i] = new DataPoint(i, d.getProductivity());
        }
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(moods);
        graph.addSeries(series);
        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<>(prods);
        graph.addSeries(series2);
        series.setTitle("Mood");
        series.setColor(Color.GREEN);
        series.setDataPointsRadius(20);
        series.setThickness(4);
        series2.setDataPointsRadius(10);
        series2.setThickness(4);

        series2.setColor(Color.BLUE);
//        Paint paint = new Paint();
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setStrokeWidth(10);

//        paint.setPathEffect(new DashPathEffect(new float[]{3, 8}, 3));
//        series2.setCustomPaint(paint);
            series2.setTitle("Productivity");
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(4);
        graph.getViewport().setScalable(true); // enables horizontal zooming and scrolling
        graph.getLegendRenderer().setVisible(true);
        graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
    }
}
