package com.example.baozeng.travelplanner;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends FragmentActivity {

    private Button mNewPlanButton;
    private Button mSavedPlansButton;

    public static Intent newIntent(Context packageContext) {
        Intent i = new Intent(packageContext, MainActivity.class);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNewPlanButton = findViewById(R.id.new_plan);
        mNewPlanButton.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = NewPlanActivity.newIntent(MainActivity.this);
                    startActivity(i);
                }
            }
        );

        mSavedPlansButton = findViewById(R.id.saved_plans);
        mSavedPlansButton.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = ListPlansActivity.newIntent(MainActivity.this);
                    startActivity(i);
                }
            }
        );

    }

}
