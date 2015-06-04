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

public class ShoppingList extends DialogFragment{
	
	public Dialog onCreateDialog(Bundle savedInstanceState) {

		// Use the Builder class for convenient dialog construction
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = getActivity().getLayoutInflater();
		View dialogView = inflater.inflate(R.layout.shopping_list, null);
		
		builder.setTitle("Shopping List").setView(dialogView)
		.setPositiveButton("Create", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				//TODO create the following class
		//		CreateList test = new CreateList();
			//	test.show(getFragmentManager(), null);
				
			}
		})
		.setNegativeButton("Download", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				//TODO Create the follwoing class
				//DownloadList test = new DownloadList();
				//test.show(getFragmentManager(), null);
				
				dialog.cancel();
			}
		});
		
		final AlertDialog dialog = builder.show();

		// Set image here for meter 
		ImageView foodMeter = (ImageView) dialog.findViewById(R.id.food_meter);
		foodMeter.setImageResource(R.drawable.food_gauge);
		

		return dialog;
		
	}
}