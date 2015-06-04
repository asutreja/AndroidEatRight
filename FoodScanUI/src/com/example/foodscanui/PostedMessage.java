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
import android.widget.TextView;
import android.widget.Toast;

public class PostedMessage extends DialogFragment{
	
	static final String CHOOSER_TEXT = "Load  with:";
	String sites;
	
	public PostedMessage (String m){
		sites = m;
	}

	public Dialog onCreateDialog(Bundle savedInstanceState) {

		// Use the Builder class for convenient dialog construction
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = getActivity().getLayoutInflater();
		View dialogView = inflater.inflate(R.layout.posted, null);

		builder.setTitle("Posted Message to:");
		builder.setView(dialogView);
		final AlertDialog dialog = builder.show();
		//dialog.getWindow().setLayout(520, 525);
		
		TextView message = (TextView) dialog.findViewById(R.id.sites_posted);
		message.setText(sites);

		Button done = (Button) dialog.findViewById(R.id.done);
		done.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				// TODO open social media options
				dialog.cancel();
			}
			
		});
		
		return dialog;
	}
}