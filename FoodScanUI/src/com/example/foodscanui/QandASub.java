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

public class QandASub extends DialogFragment{

	public Dialog onCreateDialog(Bundle savedInstanceState) {

		// Use the Builder class for convenient dialog construction
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = getActivity().getLayoutInflater();
		View dialogView = inflater.inflate(R.layout.q_and_a_sub, null);
		
		builder.setTitle("Substitutes Board").setView(dialogView)
			.setPositiveButton("Done", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				
				dialog.cancel();
			}
		});
		
		final AlertDialog dialog = builder.show();
		
		EditText question = (EditText) dialog.findViewById(R.id.post_question_sub);
		
		if (LoginScreen.user.equals("guest")){
			question.setHint("Post as guest");
		} else {
			question.setHint("Post question " + LoginScreen.user);
		}

		Button submitQuestion = (Button) dialog.findViewById(R.id.submit_sub_question);
		submitQuestion.setOnClickListener( new OnClickListener(){

			@Override
			public void onClick(View v) {
				EditText question = (EditText)((Dialog) dialog).findViewById(R.id.post_question_sub);
				if (question.getText().toString().equals("")){
					Toast.makeText(((Dialog) dialog).getContext(), "Please enter a valid question", Toast.LENGTH_SHORT).show();
				} else {
					TextView userQuestion = (TextView)((Dialog) dialog).findViewById(R.id.user_sub_question);
					userQuestion.setText(question.getText().toString());
					Toast.makeText(((Dialog) dialog).getContext(), "Thank you for posting your question!", Toast.LENGTH_SHORT).show();
					userQuestion.setCompoundDrawablesWithIntrinsicBounds(R.drawable.upvotenew, 0, 0, 0);
					question.clearComposingText();
					question.setText("");
				}
			}

		});


		return dialog;
		
	}
}