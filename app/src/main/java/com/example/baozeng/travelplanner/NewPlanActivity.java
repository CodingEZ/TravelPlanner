package com.example.baozeng.travelplanner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;


public class NewPlanActivity extends FragmentActivity {

    private Button mButtonAddDestination;
    private Button mButtonRemoveDestination;
    private Button mButtonSave;
    private Button mButtonDoNotSave;
    private EditText mDestinationBox;
    private TextView mDestinationText;

    private static final int REQUEST_SAVE = 0;
    private static final String SAVE_TAG = "SAVE_TAG";
    private static final int SAVE = 0;
    private static final int DO_NOT_SAVE = 1;
    private static final int CANCEL = 2;

    private static final String PUT_START_LOCATION =
            "com.example.baozeng.travelplanner.start_location";
    private static final String PUT_DESTINATIONS =
            "com.example.baozeng.travelplanner.destinations";
    private ArrayList<String> destinations = new ArrayList<String>();

    public static Intent newIntent(Context packageContext) {
        Intent i = new Intent(packageContext, NewPlanActivity.class);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_plan);

        if (savedInstanceState != null) {
            Bundle b = savedInstanceState.getBundle(PUT_DESTINATIONS);
            if (b != null) {
                destinations = b.getStringArrayList(PUT_DESTINATIONS);
            }
        }

        mButtonSave = findViewById(R.id.button_save);
        mButtonSave.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onSave();
                    }
                }
        );

        mButtonDoNotSave = findViewById(R.id.button_do_not_save);
        mButtonDoNotSave.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onDoNotSave();
                    }
                }
        );

        mDestinationBox = findViewById(R.id.destination_box);
        mDestinationBox.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(mDestinationBox.getWindowToken(), 0);
                }
            }
        });

        mButtonAddDestination = findViewById(R.id.add_destination);
        mButtonAddDestination.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        destinations.add(mDestinationBox.getText().toString());
                        updateText();
                    }
                }
        );

        mButtonRemoveDestination = findViewById(R.id.remove_destination);
        mButtonRemoveDestination.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        destinations.remove("Boston");
                        updateText();
                    }
                }
        );

        mDestinationText = findViewById(R.id.destination_text);
        updateText();

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Bundle b = new Bundle();
        b.putStringArrayList(PUT_DESTINATIONS, destinations);
        savedInstanceState.putBundle(PUT_DESTINATIONS, b);
    }

    public void updateText() {
        String concat = "";
        for (int i = 0; i < destinations.size(); i++) {
            if (i != 0) {
                concat = concat.concat(", ");
            }
            concat = concat.concat(destinations.get(i));
        }
        mDestinationText.setText(concat);
    }

    public void onSave() {
        Intent i = MainActivity.newIntent(NewPlanActivity.this);
        Bundle b = new Bundle();
        b.putStringArrayList(PUT_DESTINATIONS, destinations);
        i.putExtras(b);
        super.onBackPressed();
    }

    public void onDoNotSave() {
        super.onBackPressed();
    }

    @Override
    public void onBackPressed() {
        // Ask if user wants to save plan
        Intent i = SaveActivity.newIntent(NewPlanActivity.this);
        startActivityForResult(i, REQUEST_SAVE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent receivedData) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        }

        if (requestCode == REQUEST_SAVE) {
            if (receivedData == null) {
                return;
            }

            int code = receivedData.getIntExtra(SAVE_TAG, CANCEL);

            switch (code) {
                case SAVE:
                    onSave();
                    break;
                case DO_NOT_SAVE:
                    onDoNotSave();
                    break;
                case CANCEL:

                default:

            }

        }
    }

}
