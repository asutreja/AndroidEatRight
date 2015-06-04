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

public class RestaurantInfo extends DialogFragment{

	EditText restItem;
	EditText restPrice;
	EditText restReview;

	String rItem;
	String rReview;
	String rPrice;

	public Dialog onCreateDialog(Bundle savedInstanceState) {

		// Use the Builder class for convenient dialog construction
		final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = getActivity().getLayoutInflater();
		View dialogView = inflater.inflate(R.layout.restaurant_info, null);

		builder.setView(dialogView)
		.setTitle("Marks Kitchen")
		.setPositiveButton("Done", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {

				dialog.cancel();
			}
		});
		final AlertDialog dialog = builder.show();
		Button submitReview = (Button) dialog.findViewById(R.id.submit_rest);
		submitReview.setOnClickListener( new OnClickListener(){

			@Override
			public void onClick(View v) {

				restItem = (EditText)((Dialog) dialog).findViewById(R.id.add_rest_item);
				restPrice = (EditText)((Dialog) dialog).findViewById(R.id.add_rest_price);
				restReview = (EditText)((Dialog) dialog).findViewById(R.id.add_rest_review);

				rItem = restItem.getText().toString();
				rPrice = restPrice.getText().toString();
				rReview = restReview.getText().toString();


				if (!checkIfNull(rReview) && !checkIfNull(rPrice) && !checkIfNull(rItem)){
					postReview();
					postItem();
				}
				if (!checkIfNull(rReview)){

					postReview();
				} else if (checkIfNull(rPrice) || checkIfNull(rItem)){
					Toast.makeText(((Dialog) dialog).getContext(), "Please enter price or item", Toast.LENGTH_SHORT).show();
				} else if (checkIfNull(rReview) && (checkIfNull(rPrice) && checkIfNull(rReview))){
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
		TextView userPrice = (TextView)((Dialog) getDialog()).findViewById(R.id.user_rest_price);
		TextView userItem = (TextView)((Dialog) getDialog()).findViewById(R.id.user_rest_item);

		userPrice.setText(rPrice);
		userItem.setText(rItem);

		Toast.makeText(((Dialog) getDialog()).getContext(), "Thank you for posting your item!", Toast.LENGTH_SHORT).show();
		restPrice.clearComposingText();
		restPrice.setText("");

		restItem.clearComposingText();
		restItem.setText("");
	}

	public void postReview(){
		TextView userReview = (TextView)((Dialog) getDialog()).findViewById(R.id.user_rest_review);
		userReview.setText(rReview + " -" +LoginScreen.user);
		Toast.makeText(((Dialog) getDialog()).getContext(), "Thank you for posting your review!", Toast.LENGTH_SHORT).show();
		restReview.clearComposingText();
		restReview.setText("");
	}

}

