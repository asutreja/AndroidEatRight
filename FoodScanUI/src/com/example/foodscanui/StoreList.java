package com.example.foodscanui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class StoreList extends DialogFragment{
	
	double add;
	
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		
		// Use the Builder class for convenient dialog construction
		final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = getActivity().getLayoutInflater();
		View dialogView = inflater.inflate(R.layout.store_list, null);
		
		builder.setView(dialogView).setTitle("Find in Stores").
		setPositiveButton("Find in store", new DialogInterface.OnClickListener(){

			@Override
			public void onClick(DialogInterface dialog, int which) {

				RadioGroup rGroup = (RadioGroup)((Dialog) dialog).findViewById(R.id.radio_Group_store_list);
				RadioButton checkedRadioButton = (RadioButton)rGroup.findViewById(rGroup.getCheckedRadioButtonId());
				
				if(checkedRadioButton.getText().equals("Whole Foods")){
					HomeScreen.result = "";
					add = .10;
					
					//whole food is selected, make sure clear the static array 
					HomeScreen.result = "Items: \n\n";
					for(int i = 0; i < HomeScreen.listOfItems.size(); i++){
						HomeScreen.result += HomeScreen.listOfItems.get(i) + "    $" + (add + 2.89) + "\n";
						add += 0.15;
					}
					
					//Log.i("StoreList", result);
					ShowTotalWholeFoods total = new ShowTotalWholeFoods();
					total.show(getFragmentManager(), null);
					
				}else{
					// Trader joes is selected, make sure clear the static array
					HomeScreen.result = "";
					add = .10;
					
					HomeScreen.result = "ITEMS: \n\n";
					for(int i = 0; i < HomeScreen.listOfItems.size(); i++){
						HomeScreen.result += HomeScreen.listOfItems.get(i) + " $" + (add + 2.79) + "\n";
						add += 0.10;
					}
					
					//Log.i("StoreList", result);
					
					ShowTotalTraderJoes total = new ShowTotalTraderJoes();
					total.show(getFragmentManager(), null);
					
				}
				
			}
			
		}).setNegativeButton("Done", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				HomeScreen.listOfItems.clear();
				
			}
		});
		
		final AlertDialog dialog = builder.show();
		
		return dialog;
		
	}
}
