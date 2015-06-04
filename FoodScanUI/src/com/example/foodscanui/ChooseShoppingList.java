package com.example.foodscanui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ChooseShoppingList extends DialogFragment{
	
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		
		final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = getActivity().getLayoutInflater();
		View dialogView = inflater.inflate(R.layout.choose_shop_list, null);
		
		builder.setView(dialogView).setTitle("Choose your list").
		setPositiveButton("Submit", new DialogInterface.OnClickListener(){

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// Auto-generated method stub
				RadioGroup rGroup = (RadioGroup)((Dialog) dialog).findViewById(R.id.radio_Group_choose_shop_list);
				RadioButton checkedRadioButton = (RadioButton)rGroup.findViewById(rGroup.getCheckedRadioButtonId());
				
				if(checkedRadioButton.getText().equals("Download List")){
					DownloadedList download = new DownloadedList();
					download.show(getFragmentManager(), null);
				}else{
					
					// ADD code for creating the user's list 
					CreateList makeList = new CreateList();
					makeList.show(getFragmentManager(), null);
				}
			}
			
		}).setNegativeButton("Cancel", null);;
		
		final AlertDialog dialog = builder.show();
		
		return dialog;
		
		
	}
	
	
}
