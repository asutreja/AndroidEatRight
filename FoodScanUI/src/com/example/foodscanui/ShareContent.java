package com.example.foodscanui;

import java.util.ArrayList;

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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ShareContent extends DialogFragment{

	static final String CHOOSER_TEXT = "Load  with:";
	ArrayList <String> sitesChecked = new ArrayList<String>();
	private LinearLayout mFrame;

	public Dialog onCreateDialog(Bundle savedInstanceState) {

		// Use the Builder class for convenient dialog construction
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = getActivity().getLayoutInflater();
		View dialogView = inflater.inflate(R.layout.share_content, null);
		

		builder.setTitle("Share Content").setView(dialogView)
		.setPositiveButton("Share", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				String m = "";
				CheckBox fb = (CheckBox) ((Dialog) dialog).findViewById(R.id.facebook);
				CheckBox tw = (CheckBox) ((Dialog) dialog).findViewById(R.id.twitter);
				CheckBox cb = (CheckBox) ((Dialog) dialog).findViewById(R.id.communityboard);
				if (fb.isChecked() || tw.isChecked() || cb.isChecked()){
					if (fb.isChecked()){
						m += "Facebook, ";
					}
					if (tw.isChecked()){
						m += "Twitter, ";
					}
					if (cb.isChecked()){
						m += "Community Board, ";
					}
					
					m = m.substring(0, m.lastIndexOf(","));
					PostedMessage test = new PostedMessage(m);
					test.show(getFragmentManager(), PostedMessage.CHOOSER_TEXT);
					dialog.cancel();
				} else {
					Toast.makeText(((Dialog) dialog).getContext(), "Please choose an option", Toast.LENGTH_SHORT).show();
				}
				
				
			}
		})
		.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {


				dialog.cancel();
			}
		});

		final AlertDialog dialog = builder.show();

		return dialog;

	}
}