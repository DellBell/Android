package com.assignment2;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FragActivity extends Activity
{
	
	Fragment fragment;
	Button bPoppy1, bPoppy2;
	String msg = "";
	TextView tv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.frag_activity);
		
		FragmentManager fm = getFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		
		StartFragment myFragment = new StartFragment();
		ft.add(R.id.imageFrame, myFragment);
		ft.commit();
		
		bPoppy1 = (Button)findViewById(R.id.bPop1);
		bPoppy2 = (Button)findViewById(R.id.bPop2);
		
		bPoppy1.setOnClickListener(bOnClickListener);
		bPoppy2.setOnClickListener(bOnClickListener);
	}
		
	Button.OnClickListener bOnClickListener = new Button.OnClickListener()
	{

		@Override
		public void onClick(View v) 
		{
			Fragment frag;
			
			if (v == bPoppy1)
			{
				frag = new Fragment1();
				/*msg = "Picture 1 added to stack"; 
				tv = (TextView)findViewById(R.id.tvBanner);
				tv.setText(msg);*/
				
			}
			else if(v == bPoppy2)
			{
				frag = new Fragment2();
				/*msg = "Picture 2 added to stack";
				tv = (TextView)findViewById(R.id.tvBanner);
				tv.setText(msg);*/
			}
			else
			{
				frag = new StartFragment();
				/*msg = ""; 
				tv = (TextView)findViewById(R.id.tvBanner);
				tv.setText(msg);*/
			}
			
			FragmentManager fm = getFragmentManager();
			FragmentTransaction ft = fm.beginTransaction();
			ft.replace(R.id.imageFrame, frag);
			ft.addToBackStack(null);
			ft.commit();
		}
		
	};
	
	
}
