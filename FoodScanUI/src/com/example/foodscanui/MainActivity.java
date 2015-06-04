/*package com.example.foodscanui;

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

public class MainActivity extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);

		final Button scanButton = (Button) findViewById(R.id.scan_food);
		scanButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				ScanFood test = new ScanFood();
	        	test.show(getFragmentManager(), ScanFood.CHOOSER_TEXT);

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
		searchMap.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				ShoppingList test = new ShoppingList();
				test.show(getFragmentManager(), null);

			} 

		});
		
		final Button comBoard = (Button) findViewById(R.id.community_board);
		comBoard.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				//TODO Uncomment and implement the class below
				//CommunityBoard test = new CommunityBoard();
				//test.show(getFragmentManager(), null);

			} 

		});
	}
}*/