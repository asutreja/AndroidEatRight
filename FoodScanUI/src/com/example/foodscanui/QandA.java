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

public class QandA extends DialogFragment{

	public Dialog onCreateDialog(Bundle savedInstanceState) {

		// Use the Builder class for convenient dialog construction
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = getActivity().getLayoutInflater();
		View dialogView = inflater.inflate(R.layout.q_and_a, null);
		
		builder.setTitle("Forum").setView(dialogView)
			.setPositiveButton("Done", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				//CommunityBoard test = new CommunityBoard();
				//test.show(getFragmentManager(), null);
				
				dialog.cancel();
			}
		});
		
		final AlertDialog dialog = builder.show();

		final Button recipes = (Button) dialog.findViewById(R.id.q_and_a_recipe);
		recipes.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				//TODO Uncomment and implement the class below
				QandARecipe test = new QandARecipe();
				test.show(getFragmentManager(), null);
				
				//QandAFind test = new QandAFind();
				//test.show(getFragmentManager(), null);

			} 

		});
		
		final Button finds = (Button) dialog.findViewById(R.id.q_and_a_finds);
		finds.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				//TODO Uncomment and implement the class below
				QandAFind test = new QandAFind();
				test.show(getFragmentManager(), null);
				
				//QandAFind test = new QandAFind();
				//test.show(getFragmentManager(), null);

			} 

		});
		
		final Button subs = (Button) dialog.findViewById(R.id.q_and_a_sub);
		subs.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				//TODO Uncomment and implement the class below
				QandASub test = new QandASub();
				test.show(getFragmentManager(), null);
				
				//QandAFind test = new QandAFind();
				//test.show(getFragmentManager(), null);

			} 

		});

		return dialog;
		
	}
}