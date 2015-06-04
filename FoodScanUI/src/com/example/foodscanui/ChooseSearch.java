package com.example.foodscanui;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ChooseSearch extends DialogFragment{


	public Dialog onCreateDialog(Bundle savedInstanceState) {

		// Use the Builder class for convenient dialog construction
		final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = getActivity().getLayoutInflater();
		View dialogView = inflater.inflate(R.layout.choose_search, null);

		builder.setView(dialogView)
		.setTitle("Choose Search Criteria")
		.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				RadioGroup rGroup = (RadioGroup)((Dialog) dialog).findViewById(R.id.radioGroup);
				RadioButton checkedRadioButton = (RadioButton)rGroup.findViewById(rGroup.getCheckedRadioButtonId());
				if (checkedRadioButton.getText().equals("Store")){
					SearchStore test = new SearchStore();
					test.show(getFragmentManager(), null);
				} else {
					SearchRestaurant test = new SearchRestaurant();
					test.show(getFragmentManager(), null);
				}
			}
		}).setNegativeButton("Cancel", null);
		final AlertDialog dialog = builder.show();

		return dialog;
	}
}

