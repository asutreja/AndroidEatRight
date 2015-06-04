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
import android.widget.Toast;

public class ScanFood extends DialogFragment{
	
	public Dialog onCreateDialog(Bundle savedInstanceState) {

		// Use the Builder class for convenient dialog construction
		final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = getActivity().getLayoutInflater();
		View dialogView = inflater.inflate(R.layout.scanfood, null);
		
		builder.setView(dialogView)
		.setTitle("Barcode Scanner")
		.setPositiveButton("Scan", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {

				IngredientList test = new IngredientList();
				test.show(getFragmentManager(), null);
				
				dialog.cancel();
			}
		}).setNegativeButton("Cancel", null);
		final AlertDialog dialog = builder.show();

		ImageView barcode = (ImageView) dialog.findViewById(R.id.barcode_scanner);
		barcode.setImageResource(R.drawable.barcode_scanner);
		
		dialog.getButton(DialogInterface.BUTTON_NEGATIVE).setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				dialog.cancel();
			}

		});

		return dialog;
	}
}