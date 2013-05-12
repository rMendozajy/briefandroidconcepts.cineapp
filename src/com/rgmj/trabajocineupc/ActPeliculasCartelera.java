package com.rgmj.trabajocineupc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.ListActivity;
import android.content.Intent;
import com.rgmj.beans.PeliculaBean;
import com.rgmj.persistencia.DatabaseHandler;
import com.rgmj.trabajocineload.R;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;



public class ActPeliculasCartelera extends ListActivity {
	EditText filterEditText;
	static final ArrayList<HashMap<String,String>> list = 
	    	new ArrayList<HashMap<String,String>>(); 
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_pel_cartelera);
		
		DatabaseHandler db = new DatabaseHandler(this);
		
		List<PeliculaBean> movies = db.getAllPeliculasCartelera();
		Log.w("ENTRA", movies.toString());
		SimpleAdapter adapter = new SimpleAdapter( this, 
				list, 
				R.layout.custom_row_view, 
				new String[] {"mov","gen","dir"}, 
				new int[]{ R.id.textReserva,R.id.textciner,R.id.textView3} );
		list.clear();
		for (int i = 0; i < movies.size();i++){
			HashMap<String,String> temp = new HashMap<String,String>();
			temp.put("mov", movies.get(i).getNombrePelicula());
			temp.put("gen", movies.get(i).getGeneroPelicula());
			temp.put("dir", movies.get(i).getDirectorPelicula());
			list.add(temp);
		}
		setListAdapter(adapter);	
	}
	
	@Override
	protected void onListItemClick(ListView arg0, View arg1, int arg2, long arg3) {
		super.onListItemClick(arg0, arg1, arg2, arg3);
		//arg2 = position
		
		int pos = arg2 + 1;
		switch (pos){
		case 1:
			Intent myIntent = new Intent(this, ActRecepcionPeliculas.class);
			myIntent.putExtra("idPelicula", pos);
			startActivity(myIntent);
			break;
		case 2:
			Intent myIntent1 = new Intent(this, ActRecepcionPeliculas.class);
			myIntent1.putExtra("idPelicula", pos);
			startActivity(myIntent1);
			break;
		}
			
	}
}
