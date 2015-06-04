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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class IngredientList extends DialogFragment{
	
	static final String CHOOSER_TEXT = "Load  with:";

	private LinearLayout mFrame;

	public Dialog onCreateDialog(Bundle savedInstanceState) {

		// Use the Builder class for convenient dialog construction
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = getActivity().getLayoutInflater();
		View dialogView = inflater.inflate(R.layout.ingredientlist, null);
		
		builder.setTitle("Product Information").setView(dialogView)
		.setPositiveButton("Share", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				ShareContent sCon = new ShareContent();
				sCon.show(getFragmentManager(), ShareContent.CHOOSER_TEXT);
			}
		})
		.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
			
				dialog.cancel();
			}
		}).setNeutralButton("More Information", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				MoreInformation test = new MoreInformation();
		    	test.show(getFragmentManager(), MoreInformation.CHOOSER_TEXT);
			}
		});
		
		final AlertDialog dialog = builder.show();

		// Set image here for meter 
		ImageView foodMeter = (ImageView) dialog.findViewById(R.id.food_meter);
		foodMeter.setImageResource(R.drawable.food_gauge);
		
		/*Button done = (Button) dialog.findViewById(R.id.more_information);
		done.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				MoreInformation test = new MoreInformation();
		    	test.show(getFragmentManager(), MoreInformation.CHOOSER_TEXT);
			}
		});*/

		return dialog;
		
	}
}