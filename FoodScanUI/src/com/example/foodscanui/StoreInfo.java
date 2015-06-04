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

public class StoreInfo extends DialogFragment{

	EditText storeItem;
	EditText storePrice;
	EditText storeReview;
	
	String sItem;
	String sReview;
	String sPrice;
	
	public Dialog onCreateDialog(Bundle savedInstanceState) {

		// Use the Builder class for convenient dialog construction
		final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = getActivity().getLayoutInflater();
		View dialogView = inflater.inflate(R.layout.store_info, null);

		builder.setView(dialogView)
		.setTitle("Trader Joes")
		.setPositiveButton("Done", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.cancel();
			}
		});
		final AlertDialog dialog = builder.show();

		Button submitReview = (Button) dialog.findViewById(R.id.submit_store);
		submitReview.setOnClickListener( new OnClickListener(){
			 
			@Override
			public void onClick(View v) {
				
				storeItem = (EditText)((Dialog) dialog).findViewById(R.id.add_store_item);
				storePrice = (EditText)((Dialog) dialog).findViewById(R.id.add_store_price);
				storeReview = (EditText)((Dialog) dialog).findViewById(R.id.add_store_review);

				sItem = storeItem.getText().toString();
				sPrice = storePrice.getText().toString();
				sReview = storeReview.getText().toString();


				if (!checkIfNull(sReview) && !checkIfNull(sPrice) && !checkIfNull(sItem)){
					postReview();
					postItem();
				}
				if (!checkIfNull(sReview)){
					
					postReview();
				} else if (checkIfNull(sPrice) || checkIfNull(sItem)){
					Toast.makeText(((Dialog) dialog).getContext(), "Please enter price or item", Toast.LENGTH_SHORT).show();
				} else if (checkIfNull(sReview) && (checkIfNull(sPrice) && checkIfNull(sReview))){
					Toast.makeText(((Dialog) dialog).getContext(), "Please enter input", Toast.LENGTH_SHORT).show();
				} else {
					postItem();
				}
			}

		});


		return dialog;
	}

	public boolean checkIfNull(String m){
		return m.equals("");
	}
	
	public void postItem(){
		TextView userPrice = (TextView)((Dialog) getDialog()).findViewById(R.id.user_store_price);
		TextView userItem = (TextView)((Dialog) getDialog()).findViewById(R.id.user_store_item);

		userPrice.setText(sPrice);
		userItem.setText(sItem);

		Toast.makeText(((Dialog) getDialog()).getContext(), "Thank you for posting your item!", Toast.LENGTH_SHORT).show();
		storePrice.clearComposingText();
		storePrice.setText("");

		storeItem.clearComposingText();
		storeItem.setText("");
	}
	
	public void postReview(){
		TextView userReview = (TextView)((Dialog) getDialog()).findViewById(R.id.user_store_review);
		userReview.setText(sReview + " -" +LoginScreen.user);
		Toast.makeText(((Dialog) getDialog()).getContext(), "Thank you for posting your review!", Toast.LENGTH_SHORT).show();
		storeReview.clearComposingText();
		storeReview.setText("");
	}
}

