package com.rgmj.trabajocineupc;

import java.util.ArrayList;
import java.util.HashMap;

import com.rgmj.persistencia.CinePeliculaDBHandler;
import com.rgmj.trabajocineload.R;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ActRecepcionPeliculas extends ListActivity {
	static final ArrayList<HashMap<String,String>> list = 
	    	new ArrayList<HashMap<String,String>>(); 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
				
		Bundle extras = getIntent().getExtras();
			
		if(extras.getInt("idPelicula") == 1){
			setContentView(R.layout.asumare);
	
		}else if (extras.getInt("idPelicula") == 2){
			setContentView(R.layout.fastfurious);
			
		}else if (extras.getInt("idPelicula") == 3){
			setContentView(R.layout.starwar1);
			
		}else if (extras.getInt("idPelicula") == 4){
			setContentView(R.layout.starwar2);
	
		}else if (extras.getInt("idPelicula") == 5){
			setContentView(R.layout.starwar3);
			
		}else if (extras.getInt("idPelicula") == 6){
			setContentView(R.layout.starwar4);			
		}
		
		SimpleAdapter adapter = new SimpleAdapter( this, 
				list, 
				R.layout.custom_row_view, 
				new String[] {"nci","dir","des"}, 
				new int[]{ R.id.textReserva,R.id.textciner,R.id.textView3} );
		
		CinePeliculaDBHandler c = new CinePeliculaDBHandler(getApplicationContext());
		Cursor cur = c.getLocalesXMovie(extras.getInt("idPelicula")); 
		list.clear();	
		//cp.idCinepeli, cp.idCine, c.nombreCine, c.descripcionCine, c.direccionCine
		if(cur.moveToFirst()){
   		 do{
   			HashMap<String,String> temp = new HashMap<String,String>();
   			temp.put("nci", cur.getString(2));
   			temp.put("dir", cur.getString(4));
   			temp.put("des", cur.getString(3));
   			list.add(temp);
   		 }while(cur.moveToNext());
   		 setListAdapter(adapter);
   	 }	
	}
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		
	}
}
