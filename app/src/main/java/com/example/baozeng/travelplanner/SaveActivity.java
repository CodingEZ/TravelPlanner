package com.example.baozeng.travelplanner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SaveActivity extends FragmentActivity {

    private Button mButtonSave;
    private Button mButtonDoNotSave;
    private Button mButtonCancel;

    private static final String SAVE_TAG = "SAVE_TAG";
    private static final int SAVE = 0;
    private static final int DO_NOT_SAVE = 1;
    private static final int CANCEL = 2;


    public static Intent newIntent(Context packageContext) {
        Intent i = new Intent(packageContext, SaveActivity.class);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);

        mButtonSave = findViewById(R.id.button_save);
        mButtonSave.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    Intent data = new Intent();
                    data.putExtra(SAVE_TAG, SAVE);

                    setResult(Activity.RESULT_OK, data); // Set result for activity
                    onBackPressed();
                    }
                }
        );

        mButtonDoNotSave = findViewById(R.id.button_do_not_save);
        mButtonDoNotSave.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    Intent data = new Intent();
                    data.putExtra(SAVE_TAG, DO_NOT_SAVE);

                    setResult(Activity.RESULT_OK, data); // Set result for activity
                    onBackPressed();
                    }
                }
        );

        mButtonCancel = findViewById(R.id.button_cancel);
        mButtonCancel.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    Intent data = new Intent();
                    data.putExtra(SAVE_TAG, CANCEL);

                    setResult(Activity.RESULT_OK, data); // Set result for activity
                    onBackPressed();
                    }
                }
        );

        this.setFinishOnTouchOutside(false);

    }

}
