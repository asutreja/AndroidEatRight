package com.example.foodscanui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class SearchRestaurant extends DialogFragment{

	static final String CHOOSER_TEXT = "Load  with:";

	public Dialog onCreateDialog(Bundle savedInstanceState) {

		// Use the Builder class for convenient dialog construction
		final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = getActivity().getLayoutInflater();
		View dialogView = inflater.inflate(R.layout.restaurant_map, null);

		builder.setView(dialogView).setTitle("Map View").setPositiveButton("Click on restaurant for more information", null);
		final AlertDialog dialog = builder.show();

		RelativeLayout rlayout = (RelativeLayout) dialog.findViewById(R.id.mainlayout);
		rlayout.setOnClickListener(new OnClickListener() {

		    @Override
		    public void onClick(View v) {
		    	RestaurantInfo test = new RestaurantInfo();
		    	test.show(getFragmentManager(), null);
		    	dialog.cancel();
		    }

		 });


		return dialog;

	}	
}
