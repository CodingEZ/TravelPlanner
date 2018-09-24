package com.example.baozeng.travelplanner;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class SaveDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.save_question)
                .setPositiveButton(R.string.save_answer, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // save plan
                    }
                })
                .setNegativeButton(R.string.cancel_answer, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // exit without saving
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }

}