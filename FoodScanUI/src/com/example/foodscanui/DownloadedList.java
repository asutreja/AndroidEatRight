package com.example.foodscanui;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class DownloadedList extends DialogFragment{
		
	ArrayList<String> veganList, sugerFree, gmos, guletinFree;
	
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		
		veganList = new ArrayList<String>();
		sugerFree = new ArrayList<String>();
		gmos = new ArrayList<String>();
		guletinFree = new ArrayList<String>();
		
		veganList.add("Oreos");
		veganList.add("Sour Patch Kids");
		veganList.add("Red Bull");
		
		sugerFree.add("Orbit White");
		sugerFree.add("Fudge Graham");
		sugerFree.add("Diet Lipton Iced Tea");
		
		gmos.add("Canned Soups");
		gmos.add("Sweetend Juice");
		gmos.add("Soy Milks");
		
		guletinFree.add("Quino Flakes");
		guletinFree.add("Soy Wrappers");
		guletinFree.add("Red Quinoa");
		
		final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = getActivity().getLayoutInflater();
		View dialogView = inflater.inflate(R.layout.donload_list, null);
		
		builder.setView(dialogView).setTitle("Pick default list").
		setPositiveButton("Submit",new DialogInterface.OnClickListener(){
		
			@Override
			public void onClick(DialogInterface dialog, int which) {
				
				RadioGroup rGroup = (RadioGroup)((Dialog) dialog).findViewById(R.id.radio_Group_downlaod_list);
				RadioButton checkedRadioButton = (RadioButton)rGroup.findViewById(rGroup.getCheckedRadioButtonId());
				
				if(checkedRadioButton.getText().equals("Vegan")){
					// Set ArrayList for Vegan here and send user to find in store dialog
					HomeScreen.listOfItems = veganList;
					
				}else if(checkedRadioButton.getText().equals("Dairy free")){
					// set ArrayList for GMOs and send user to find in store dialog 
					HomeScreen.listOfItems = gmos;
			
				}else if(checkedRadioButton.getText().equals("Sugar Free")){
					// set ArrayList for Sugar free and send user to find in store dialog 
					HomeScreen.listOfItems = sugerFree;
					
				}else if(checkedRadioButton.getText().equals("Gluten Free")){
					// set ArrayList for Gluten free and send user to find in store dialog 
					HomeScreen.listOfItems = guletinFree;
				}
				
				StoreList store = new StoreList();
				store.show(getFragmentManager(), null);
				
			}
			
		}).setNegativeButton("Cancel", null);
		
		final AlertDialog dialog = builder.show();
		
		return dialog;
		
		
	}

}
