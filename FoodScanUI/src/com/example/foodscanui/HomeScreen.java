package com.example.foodscanui;

import java.util.ArrayList;
import java.util.Random;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.EditText;
import android.widget.TextView;

public class HomeScreen extends Activity {

	public static ArrayList<String> listOfItems = new ArrayList<String>();
	public static String result;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);

		final Button scanButton = (Button) findViewById(R.id.scan_food);
		scanButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				ScanFood test = new ScanFood();
				test.show(getFragmentManager(), null);

			} 

		});

		final Button searchMap= (Button) findViewById(R.id.search_map);
		searchMap.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				ChooseSearch test = new ChooseSearch();
				test.show(getFragmentManager(), null);

			} 

		});

		final Button shopList = (Button) findViewById(R.id.make_shopping_list);
		shopList.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				ChooseShoppingList shopList = new ChooseShoppingList();
				shopList.show(getFragmentManager(), null);
			} 
		});

		final Button comBoard = (Button) findViewById(R.id.community_board);
		comBoard.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				CommunityBoard test = new CommunityBoard();
				test.show(getFragmentManager(), null);
			} 
		});
		
		final TextView welcome = (TextView) findViewById(R.id.welcome);
		welcome.setText("Welcome " + LoginScreen.user);
	}
}