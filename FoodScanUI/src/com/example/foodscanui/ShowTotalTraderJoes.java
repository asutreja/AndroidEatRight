package com.example.foodscanui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView.FindListener;
import android.widget.TextView;

public class ShowTotalTraderJoes extends DialogFragment{
	
	public static TextView textView;
	
	public Dialog onCreateDialog(Bundle savedInstanceState) {
	
		final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = getActivity().getLayoutInflater();
		View dialogView = inflater.inflate(R.layout.total, null);
		
		builder.setView(dialogView).setTitle("Trader Joes").setPositiveButton("Find In Store", new DialogInterface.OnClickListener(){

			@Override
			public void onClick(DialogInterface dialog, int which) {
				
				StoreList goBack = new StoreList();
				goBack.show(getFragmentManager(), null);
				
			}
			
		}).setNegativeButton("Done", new DialogInterface.OnClickListener(){

			@Override
			public void onClick(DialogInterface dialog, int which) {
				HomeScreen.listOfItems.clear();
			}
			
		});
		
		final AlertDialog dialog = builder.show();
		
		TextView store = (TextView) dialog.findViewById(R.id.store_name);
		TextView shoppingList = (TextView) dialog.findViewById(R.id.show_total_textView);
		
		store.setCompoundDrawablesWithIntrinsicBounds(R.drawable.trader_joes_pic, 0, 0, 0);
		
		shoppingList.setText(HomeScreen.result);
		return dialog;
	
	}

}
