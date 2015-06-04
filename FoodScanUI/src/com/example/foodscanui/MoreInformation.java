package com.example.foodscanui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
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
import android.widget.Toast;

public class MoreInformation extends DialogFragment{
	
	static final String CHOOSER_TEXT = "Load  with:";


	public Dialog onCreateDialog(Bundle savedInstanceState) {

		// Use the Builder class for convenient dialog construction
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = getActivity().getLayoutInflater();
		View dialogView = inflater.inflate(R.layout.moreinformation, null);

		builder.setTitle("More Information");
		
		builder.setView(dialogView);
		final AlertDialog dialog = builder.show();
		//dialog.getWindow().setLayout(520, 525);

		Button done = (Button) dialog.findViewById(R.id.done_with_info);
		done.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				//GO back to previous dialog entry
				IngredientList test = new IngredientList();
		    	test.show(getFragmentManager(), null);
				dialog.cancel();
			}
			
		});
		
		return dialog;
	}
}