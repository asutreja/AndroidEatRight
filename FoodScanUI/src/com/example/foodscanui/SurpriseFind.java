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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SurpriseFind extends DialogFragment{

	public Dialog onCreateDialog(Bundle savedInstanceState) {

		// Use the Builder class for convenient dialog construction
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = getActivity().getLayoutInflater();
		View dialogView = inflater.inflate(R.layout.surprise_find, null);

		builder.setTitle("Surprise Finds").setView(dialogView)
		.setPositiveButton("Done", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {

				dialog.cancel();
			}
		});

		final AlertDialog dialog = builder.show();

		EditText question = (EditText) dialog.findViewById(R.id.post_question_surprise);
		
		// Get username from static variable in LoginScreen to post name if there is one
		// if (LoginScreen.username.equals(guest){
		// 		question.setHint("Enter your post, " + username);
		//  }

		if (LoginScreen.user.equals("guest")){
			question.setHint("Post as guest");
		} else {
			question.setHint("Post question " + LoginScreen.user);
		}
		
		Button submitQuestion = (Button) dialog.findViewById(R.id.submit_surprise_question);
		submitQuestion.setOnClickListener( new OnClickListener(){

			@Override
			public void onClick(View v) {

				RadioGroup rGroup = (RadioGroup)((Dialog) dialog).findViewById(R.id.radioGroupSurprise);
				// This will get the radiobutton in the radiogroup that is checked
				RadioButton checkedRadioButton = (RadioButton)rGroup.findViewById(rGroup.getCheckedRadioButtonId());

				EditText question = (EditText)((Dialog) dialog).findViewById(R.id.post_question_surprise);
				String post = question.getText().toString();

				if (question.getText().toString().equals("")){
					Toast.makeText(((Dialog) dialog).getContext(), "Please enter a valid post", Toast.LENGTH_SHORT).show();
				} else {
					if (checkedRadioButton.getText().equals("Good")){

						//Set text for good
						TextView userQuestion = (TextView)((Dialog) dialog).findViewById(R.id.user_surprise_question_good);
						userQuestion.setText(question.getText().toString());
						Toast.makeText(((Dialog) dialog).getContext(), "Thank you for posting!", Toast.LENGTH_SHORT).show();
						userQuestion.setCompoundDrawablesWithIntrinsicBounds(R.drawable.upvotenew, 0, 0, 0);
						question.clearComposingText();
						question.setText("");
					} else {

						//set text for bad
						TextView userQuestion = (TextView)((Dialog) dialog).findViewById(R.id.user_surprise_question_bad);
						userQuestion.setText(question.getText().toString());
						Toast.makeText(((Dialog) dialog).getContext(), "Thank you for posting!", Toast.LENGTH_SHORT).show();
						userQuestion.setCompoundDrawablesWithIntrinsicBounds(R.drawable.upvotenew, 0, 0, 0);
						question.clearComposingText();
						question.setText("");
					}
				}
			}

		});

		return dialog;

	}
}