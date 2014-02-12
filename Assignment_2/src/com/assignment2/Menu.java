package com.assignment2;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity
{

	String classes[] = {"MainActivity", "example1", "example2"};
	
		
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, classes));
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String localClass = classes[position];
		try 
		{
			@SuppressWarnings("rawtypes")
			Class makeNewClass = Class.forName("com.assignment2." + localClass);
			Intent intent = new Intent(Menu.this, makeNewClass);
			startActivity(intent);
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
	}
}
