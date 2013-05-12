package com.rgmj.trabajocineupc;

import com.rgmj.persistencia.DatabaseHandler;
import com.rgmj.trabajocineload.R;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

public class ActReserva extends Activity {
	Intent i;String cadena = "";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.reserva);
		
		DatabaseHandler db = new DatabaseHandler(this);
		Spinner prueba = (Spinner)findViewById(R.id.spinnercine);
		Spinner prueba2 = (Spinner)findViewById(R.id.spinnerpelicula);
				
		Cursor c = db.getAllLocalesCursor();
		Cursor d = db.getAllPeliculasCursor();
			
		//Creamos el adaptador
		
		SimpleCursorAdapter adapter2 = new SimpleCursorAdapter(getApplicationContext(),android.R.layout.simple_spinner_item,c,new String[] {"nombreCine"},new int[] {android.R.id.text1});
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		prueba.setAdapter(adapter2);
		
		SimpleCursorAdapter adapter3 = new SimpleCursorAdapter(getApplicationContext(),android.R.layout.simple_spinner_item,d,new String[] {"nombrePelicula"},new int[] {android.R.id.text1});
		adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		prueba2.setAdapter(adapter3);

	}
	
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onPostCreate(savedInstanceState);
		
		
		
	}
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		
	}
	
	public void Resultado(){
		EditText ninos = (EditText) findViewById(R.id.editText1);
		EditText adultos = (EditText) findViewById(R.id.editText2);
		EditText madultos = (EditText) findViewById(R.id.editText3);
		CheckBox c1 = (CheckBox) findViewById(R.id.checkBox1);
		CheckBox c2 = (CheckBox) findViewById(R.id.checkBox2);
		CheckBox c3 = (CheckBox) findViewById(R.id.checkBox3);
		CheckBox c4 = (CheckBox) findViewById(R.id.checkBox4);
		CheckBox c5 = (CheckBox) findViewById(R.id.checkBox5);
		CheckBox c6 = (CheckBox) findViewById(R.id.checkBox6);
		CheckBox c7 = (CheckBox) findViewById(R.id.checkBox7);
		CheckBox c8 = (CheckBox) findViewById(R.id.checkBox8);
		CheckBox c9 = (CheckBox) findViewById(R.id.checkBox9);
		CheckBox c10 = (CheckBox) findViewById(R.id.checkBox10);
		CheckBox c11 = (CheckBox) findViewById(R.id.checkBox11);
		CheckBox c12 = (CheckBox) findViewById(R.id.checkBox12);
		CheckBox c13 = (CheckBox) findViewById(R.id.checkBox13);
		CheckBox c14 = (CheckBox) findViewById(R.id.checkBox14);
	    CheckBox c15 = (CheckBox) findViewById(R.id.checkBox15);
		CheckBox c16 = (CheckBox) findViewById(R.id.checkBox16);
		CheckBox c17 = (CheckBox) findViewById(R.id.checkBox17);
		CheckBox c18= (CheckBox) findViewById(R.id.checkBox18);
		CheckBox c19 = (CheckBox) findViewById(R.id.checkBox19);
		Spinner prueba = (Spinner)findViewById(R.id.spinnercine);
		Spinner prueba2 = (Spinner) findViewById(R.id.spinnerpelicula);	 
			
			if (c1.isActivated()){
				 cadena = cadena + ", " +  c1.getText().toString();
			}else if (c2.isActivated()){
				cadena = cadena + ", " +  c2.getText().toString();
			}else if (c3.isActivated()){
				cadena = cadena + ", " +  c3.getText().toString();
			}else if (c4.isActivated()){
				cadena = cadena + ", " +  c4.getText().toString();
			}else if (c5.isActivated()){
				cadena = cadena + ", " +  c5.getText().toString();
			}else if (c6.isActivated()){
				cadena = cadena + ", " +  c6.getText().toString();
			}else if (c7.isActivated()){
				cadena = cadena + ", " +  c7.getText().toString();
			}else if (c8.isActivated()){
				cadena = cadena + ", " +  c8.getText().toString();
			}else if (c9.isActivated()){
				cadena = cadena + ", " +  c9.getText().toString();
			}else if (c10.isActivated()){
				cadena = cadena + ", " +  c10.getText().toString();
			}else if (c11.isActivated()){
				cadena = cadena + ", " +  c11.getText().toString();
			}else if (c12.isActivated()){
				cadena = cadena + ", " +  c12.getText().toString();
			}else if (c13.isActivated()){
				cadena = cadena + ", " +  c13.getText().toString();
			}else if (c14.isActivated()){
				cadena = cadena + ", " +  c14.getText().toString();
			}else if (c15.isActivated()){
				cadena = cadena + ", " +  c15.getText().toString();
			}else if (c16.isActivated()){
				cadena = cadena + ", " +  c16.getText().toString();
			}else if (c17.isActivated()){
				cadena = cadena + ", " +  c17.getText().toString();
			}else if (c18.isActivated()){
				cadena = cadena + ", " +  c18.getText().toString();
			}else if (c19.isActivated()){
				cadena = cadena + ", " +  c19.getText().toString();
			}
			    i = new Intent(getApplicationContext(), ActRecepcionReserva.class);
				i.putExtra("cine", prueba.getSelectedItem().toString());
				i.putExtra("pelicula", prueba2.getSelectedItem().toString());
				i.putExtra("nninos", ninos.getText() );
				i.putExtra("adultos", adultos.getText() );
				i.putExtra("madultos", madultos.getText() );
				i.putExtra("cadena", cadena);
				startActivity(i);
	}

	

}
