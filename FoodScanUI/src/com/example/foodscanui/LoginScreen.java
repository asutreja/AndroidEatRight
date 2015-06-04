package com.example.foodscanui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginScreen extends Activity {
	public static String user = "";
	public static boolean isGuest = false;
	final Context context = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_login);
		Button login = (Button)findViewById(R.id.button1);
		Button signup = (Button)findViewById(R.id.button2);
		Button guest = (Button)findViewById(R.id.Button01);
		final EditText username = (EditText) findViewById(R.id.editText1);
		final EditText password = (EditText) findViewById(R.id.password);


		login.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				user = username.getText().toString();

				if(!password.getText().toString().isEmpty() && !username.getText().toString().isEmpty()){
					Intent intent = new Intent(LoginScreen.this, HomeScreen.class);
					startActivity(intent);
				}
				else{
					Toast.makeText(getApplicationContext(), "All fields are required", Toast.LENGTH_SHORT).show();
				}
			}
		});


		signup.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				LayoutInflater li = LayoutInflater.from(context);
				View promptsView = li.inflate(R.layout.new_user, null);
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

				alertDialogBuilder.setView(promptsView);
				final AlertDialog alertDialog = alertDialogBuilder.create();

				final EditText signupuser = (EditText) promptsView.findViewById(R.id.signupuser);
				final EditText signuppassword = (EditText) promptsView.findViewById(R.id.signuppassword);
				final EditText email = (EditText) promptsView.findViewById(R.id.email);
				final Button submit = (Button) promptsView.findViewById(R.id.submit);
				submit.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						user = signupuser.getText().toString();
						
						if(!user.isEmpty() && !signuppassword.getText().toString().isEmpty() && !email.getText().toString().isEmpty()){
							Intent intent = new Intent(LoginScreen.this, HomeScreen.class);
							startActivity(intent);
						}else{
							Toast.makeText(getApplicationContext(), "All fields are required", Toast.LENGTH_LONG).show();
						}

					}
				});

				alertDialog.show();

			}
		});

		guest.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				LayoutInflater li = LayoutInflater.from(context);
				View promptsView = li.inflate(R.layout.guest, null);
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

				alertDialogBuilder.setView(promptsView);
				alertDialogBuilder
				.setCancelable(false)
				.setPositiveButton("OK",
						new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						user = "guest";
						isGuest = true;
						Intent intent = new Intent(LoginScreen.this, HomeScreen.class);
						startActivity(intent);
					}
				})
				.setNegativeButton("Cancel",
						new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						dialog.cancel();
					}
				});


				AlertDialog alertDialog = alertDialogBuilder.create();
				alertDialog.show();
			}
		});
	}
}
