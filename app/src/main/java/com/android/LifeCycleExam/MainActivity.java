package com.android.LifeCycleExam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mLevelText;
    private TextView mScoreText;

    static final String STATE_SCORE = "playerScore";
    static final String STATE_LEVEL = "playerLevel";

    private int mLevel = 0;
    private int mScore = 0;

    @Override
    protected void onSaveInstanceState(Bundle outState){
        outState.putInt(STATE_LEVEL, mLevel);
        outState.putInt(STATE_SCORE, mScore);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle saveinstanceState){
        super.onRestoreInstanceState(saveinstanceState);
        mLevel = saveinstanceState.getInt(STATE_LEVEL);
        mScore = saveinstanceState.getInt(STATE_SCORE);
        mLevelText.setText("레벨 : "+mLevel);
        mScoreText.setText("점수 : "+mScore);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLevelText = (TextView)findViewById(R.id.level_text);
        mScoreText = (TextView)findViewById(R.id.score_text);

    }

    public void onLevelUp(View view){
        mLevel++;
        mLevelText.setText("레벨 : "+mLevel);
    }
    public void onScoreUp(View view){
        mScore++;
        mScoreText.setText("점수 : "+mScore);
    }

}