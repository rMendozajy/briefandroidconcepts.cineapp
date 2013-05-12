package com.rgmj.trabajocineupc;

import java.util.ArrayList;
import java.util.HashMap;

import com.rgmj.persistencia.CinePeliculaDBHandler;
import com.rgmj.trabajocineload.R;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.SimpleAdapter;

public class ActRecepcionLocales extends ListActivity {
	static final ArrayList<HashMap<String,String>> list = 
	    	new ArrayList<HashMap<String,String>>(); 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Bundle extras = getIntent().getExtras();
		
		
		if(extras.getInt("idLocal") == 1){
			setContentView(R.layout.alcazarcine);
		}else if (extras.getInt("idLocal") == 2){
			setContentView(R.layout.arequipacine);
		}else if (extras.getInt("idLocal") == 3){
			setContentView(R.layout.arequiparpcine);
		}else if (extras.getInt("idLocal") == 4){
			setContentView(R.layout.centrocine);	
		}else if (extras.getInt("idLocal") == 5){
			setContentView(R.layout.centrocivicocine);
		}else if (extras.getInt("idLocal") == 6){
			setContentView(R.layout.chiclayocine);
		}else if (extras.getInt("idLocal") == 7){
			setContentView(R.layout.comascine);
		}else if (extras.getInt("idLocal") == 8){
			setContentView(R.layout.huancayocine);
		}
			
		SimpleAdapter adapter = new SimpleAdapter( this, 
				list, 
				R.layout.custom_row_view, 
				new String[] {"nom","gen","dir"}, 
				new int[]{ R.id.textReserva,R.id.textciner,R.id.textView3} );
		
		CinePeliculaDBHandler c = new CinePeliculaDBHandler(getApplicationContext());
		Cursor cur = c.getMoviesXLocal(extras.getInt("idLocal"));
		//cp.idCinepeli, cp.idPelicula, p.nombrePelicula, p.generoPelicula, p.directorPelicula
			
		list.clear();	
		if(cur.moveToFirst()){
   		 do{
   			HashMap<String,String> temp = new HashMap<String,String>();
   			temp.put("nom", cur.getString(2));
   			temp.put("gen", cur.getString(3));
   			temp.put("dir", cur.getString(4));	
   			list.add(temp);
   		 }while(cur.moveToNext());
   		 setListAdapter(adapter);
   	 }
	}
}
