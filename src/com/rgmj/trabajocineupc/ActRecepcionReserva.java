package com.rgmj.trabajocineupc;


import com.rgmj.trabajocineload.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

public class ActRecepcionReserva extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.recepcionreserva);
		Bundle extras = getIntent().getExtras();
		
		EditText ee = (EditText) findViewById(R.id.textReserva);
		EditText e1 = (EditText) findViewById(R.id.textciner);
		EditText e2 = (EditText) findViewById(R.id.textpelar);
		EditText e3 = (EditText) findViewById(R.id.textninosr);
		EditText e4 = (EditText) findViewById(R.id.textadultosr);
		EditText e5 = (EditText) findViewById(R.id.textadultosmr);
		EditText e6 = (EditText) findViewById(R.id.textentradasr);
		
		ee.setText("Se realizo su reserva satisfactoriamente con la siguiente información: ");
		e1.setText(extras.getString("cine"));
		e2.setText(extras.getString("pelicula"));
		e3.setText(extras.getString("nninos"));
		e4.setText(extras.getString("adultos"));
		e5.setText(extras.getString("madultos"));
		e6.setText(extras.getString("cadena"));
		
		
	}

}
