package com.example.baozeng.travelplanner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class ListPlansActivity extends FragmentActivity {

    public static Intent newIntent(Context packageContext) {
        Intent i = new Intent(packageContext, ListPlansActivity.class);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_plans);
    }

    @Override
    public void onBackPressed() {
        // do something here, probably ask to do a save of some kind
        Intent data = new Intent();
        setResult(Activity.RESULT_OK, data); // Set result for activity

        //super.onBackPressed();
    }

}
