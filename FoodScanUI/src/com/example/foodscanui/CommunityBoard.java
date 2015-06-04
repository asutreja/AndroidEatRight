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

public class CommunityBoard extends DialogFragment{

	public Dialog onCreateDialog(Bundle savedInstanceState) {

		// Use the Builder class for convenient dialog construction
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = getActivity().getLayoutInflater();
		View dialogView = inflater.inflate(R.layout.community_board, null);
		
		builder.setTitle("Community Board").setView(dialogView)
			.setPositiveButton("Done", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				
				dialog.cancel();
			}
		});
		
		final AlertDialog dialog = builder.show();

		final Button comBoard = (Button) dialog.findViewById(R.id.q_and_a);
		comBoard.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				QandA test = new QandA();
				test.show(getFragmentManager(), null);
			} 

		});
		
		final Button surpriseFinds = (Button) dialog.findViewById(R.id.surprise_finds_com);
		surpriseFinds.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				SurpriseFind test = new SurpriseFind();
				test.show(getFragmentManager(), null);
			} 

		});

		return dialog;
		
	}
}