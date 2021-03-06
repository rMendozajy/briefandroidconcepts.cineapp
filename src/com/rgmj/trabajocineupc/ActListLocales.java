package com.rgmj.trabajocineupc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import com.rgmj.beans.CineBean;
import com.rgmj.persistencia.DatabaseHandler;
import com.rgmj.trabajocineload.R;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;



public class ActListLocales extends ListActivity {
	EditText filterEditText;
	static final ArrayList<HashMap<String,String>> list = 
	    	new ArrayList<HashMap<String,String>>(); 
	Intent in;
	boolean click = false;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_locales);
		DatabaseHandler db = new DatabaseHandler(this);
	
		List<CineBean> places = db.getAllLocales();
		Log.w("ENTRA", places.toString());
		final SimpleAdapter adapter = new SimpleAdapter( this, 
				list, 
				R.layout.custom_row_locales, 
				new String[] {"nci","dir","des"}, 
				new int[]{ R.id.textReserva,R.id.textciner,R.id.textView3} );
		list.clear();
		for (int i = 0; i < places.size();i++){
			HashMap<String,String> temp = new HashMap<String,String>();
			temp.put("nci", places.get(i).getNombreCine());
			temp.put("dir", places.get(i).getDirecCine());
			temp.put("des", places.get(i).getDescCine());
			list.add(temp);
		}
		setListAdapter(adapter);
		final ListView myListView = getListView();
		
		SwipeListViewTouchListener touchListener = new SwipeListViewTouchListener(
				myListView,
				new SwipeListViewTouchListener.OnSwipeCallback() {
					//Como valor agregado, dejo para ustedes los métodos de SwipeRight 
					//and SwipeLeft para que únicamente sean implementados. 
					@Override
					public void onSwipeRight(ListView listView, int[] reverseSortedPositions) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void onSwipeLeft(ListView listView, int[] reverseSortedPositions) {
						// TODO Auto-generated method stub
						
					}
				},
				true,
				false);
		myListView.setOnTouchListener(touchListener);
		myListView.setOnScrollListener(touchListener.makeScrollListener());
	}
		
	@Override
	protected void onListItemClick(ListView arg0, View arg1, int arg2, long arg3) {
		super.onListItemClick(arg0, arg1, arg2, arg3);
		//arg2 = position
		int pos = arg2 + 1;
		switch (pos){
		case 1:
			Intent myIntent = new Intent(this, ActRecepcionLocales.class);
			myIntent.putExtra("idLocal", pos);
			startActivity(myIntent);
			break;
		case 2:
			Intent myIntent1 = new Intent(this, ActRecepcionLocales.class);
			myIntent1.putExtra("idLocal", pos);
			startActivity(myIntent1);
			break;
		case 3:
			Intent myIntent2 = new Intent(this, ActRecepcionLocales.class);
			myIntent2.putExtra("idLocal", pos);
			startActivity(myIntent2);
			break;
		case 4:
			Intent myIntent3 = new Intent(this, ActRecepcionLocales.class);
			myIntent3.putExtra("idLocal", pos);
			startActivity(myIntent3);
			break;
		case 5:
			Intent myIntent4 = new Intent(this, ActRecepcionLocales.class);
			myIntent4.putExtra("idLocal", pos);
			startActivity(myIntent4);
			break;		
		case 6:
			Intent myIntent5 = new Intent(this, ActRecepcionLocales.class);
			myIntent5.putExtra("idLocal", pos);
			startActivity(myIntent5);
			break;
		
		case 7:
			Intent myIntent6 = new Intent(this, ActRecepcionLocales.class);
			myIntent6.putExtra("idLocal", pos);
			startActivity(myIntent6);
			break;
		case 8:
			Intent myIntent7 = new Intent(this, ActRecepcionLocales.class);
			myIntent7.putExtra("idLocal", pos);
			startActivity(myIntent7);
			break;
		case 9:
			Intent myIntent8 = new Intent(this, ActRecepcionLocales.class);
			myIntent8.putExtra("idLocal", pos);
			startActivity(myIntent8);
			break;
		case 10:
			Intent myIntent9 = new Intent(this, ActRecepcionLocales.class);
			myIntent9.putExtra("idLocal", pos);
			startActivity(myIntent9);
			break;
		case 11:
			Intent myIntent10 = new Intent(this, ActRecepcionLocales.class);
			myIntent10.putExtra("idLocal", pos);
			startActivity(myIntent10);
			break;		
		case 12:
			Intent myIntent11 = new Intent(this, ActRecepcionLocales.class);
			myIntent11.putExtra("idLocal", pos);
			startActivity(myIntent11);
			break;
		
		case 13:
			Intent myIntent12 = new Intent(this, ActRecepcionLocales.class);
			myIntent12.putExtra("idLocal", pos);
			startActivity(myIntent12);
			break;
		case 14:
			Intent myIntent13 = new Intent(this, ActRecepcionLocales.class);
			myIntent13.putExtra("idLocal", pos);
			startActivity(myIntent13);
			break;
		case 15:
			Intent myIntent14 = new Intent(this, ActRecepcionLocales.class);
			myIntent14.putExtra("idLocal", pos);
			startActivity(myIntent14);
			break;		
		case 16:
			Intent myIntent15 = new Intent(this, ActRecepcionLocales.class);
			myIntent15.putExtra("idLocal", pos);
			startActivity(myIntent15);
			break;	
		case 17:
			Intent myIntent16 = new Intent(this, ActRecepcionLocales.class);
			myIntent16.putExtra("idLocal", pos);
			startActivity(myIntent16);
			break;
		case 18:
			Intent myIntent17 = new Intent(this, ActRecepcionLocales.class);
			myIntent17.putExtra("idLocal", pos);
			startActivity(myIntent17);
			break;
		case 19:
			Intent myIntent18 = new Intent(this, ActRecepcionLocales.class);
			myIntent18.putExtra("idLocal", pos);
			startActivity(myIntent18);
			break;
		}
			
	}
}
