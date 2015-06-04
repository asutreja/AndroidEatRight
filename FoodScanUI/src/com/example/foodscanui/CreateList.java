package com.example.foodscanui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class CreateList extends DialogFragment{

	int counter = 1;
	
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		
		final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = getActivity().getLayoutInflater();
		View dialogView = inflater.inflate(R.layout.create_list, null);
		
		
		
		builder.setView(dialogView).setTitle("Make Your List").
		setPositiveButton("Enter", new DialogInterface.OnClickListener(){
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// Overriding the method below to keep the dialog on the screen. 	
			}
			
		}).setNegativeButton("Done", new DialogInterface.OnClickListener(){

			@Override
			public void onClick(DialogInterface dialog, int which) {
				StoreList stores = new StoreList();
				stores.show(getFragmentManager(), null);
			}
			
		});
		
		final AlertDialog dialog = builder.show();
		
		return dialog;
		
	}
	
	@Override
	public void onStart(){
		
		super.onStart();
		AlertDialog d = (AlertDialog)getDialog();
		
		if(d != null){
			
			final Button positiveButton = (Button)d.getButton(Dialog.BUTTON_POSITIVE);
			
			positiveButton.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					
						EditText input = (EditText) ((Dialog) (AlertDialog)getDialog()).findViewById(R.id.create_list_userInput);
						String result = input.getText().toString();
						
						if(!result.equals("")){
							//Log.i("String item", "list: " + result);
							HomeScreen.listOfItems.add(result);
							input.setHint("Insert item " + ++counter);
							input.setText("");
							TextView test = (TextView) ((Dialog) (AlertDialog)getDialog()).findViewById(R.id.create_list_result);
							String userList = "";
							for (String m:HomeScreen.listOfItems){
								userList += m + "\n";
							}
							test.setText(userList);
						}else{
							Toast.makeText(getActivity(), "Please enter item", Toast.LENGTH_SHORT).show();
						}
							
						
					
				
				}
			});
		}
		
	}

}
