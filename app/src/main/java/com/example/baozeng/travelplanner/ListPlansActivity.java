package com.example.baozeng.travelplanner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;

public class ListPlansActivity extends FragmentActivity {

    private Button mMapsButton;

    public static Intent newIntent(Context packageContext) {
        Intent i = new Intent(packageContext, ListPlansActivity.class);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_plans);

        mMapsButton = findViewById(R.id.map_button);
        mMapsButton.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = MapsActivity.newIntent(ListPlansActivity.this);
                    startActivity(i);
                }
            }
        );

    }

}
