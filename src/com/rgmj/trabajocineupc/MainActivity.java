/*
	Autor:		Rubén Gilmar Mendoza Jayo
	Proyecto:	Cine
	Fichero:	MainActivity.java
	Version		0.1
	Fecha:		12/05/2013
 */


package com.rgmj.trabajocineupc;

import com.rgmj.persistencia.CineDBHandler;
import com.rgmj.persistencia.CinePeliculaDBHandler;
import com.rgmj.persistencia.DatabaseHandler;
import com.rgmj.persistencia.HorariosCPDBHandler;
import com.rgmj.persistencia.HorariosDBHandler;
import com.rgmj.persistencia.PeliculaDBHandler;
import com.rgmj.persistencia.SalaDBHandler;
import com.rgmj.persistencia.SalaHCPDBHandler;
import com.rgmj.trabajocineload.R;

import android.os.Bundle;
import android.os.Vibrator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
	
	
	private static final float INITIAL_ITEMS_COUNT = 1.8F;
	private LinearLayout mImageContainer;
	Vibrator vi; 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        DatabaseHandler db = new DatabaseHandler(this);
        //COMENTAR LA FILA 49 LUEGO DE LA PRIMERA EJECUCIÓN
        db.createDatabase();
        CineDBHandler cin = new CineDBHandler(this);
		PeliculaDBHandler pel = new PeliculaDBHandler(this);
		CinePeliculaDBHandler cp = new CinePeliculaDBHandler(this);
		HorariosDBHandler ho = new HorariosDBHandler(this);
		HorariosCPDBHandler hcp = new HorariosCPDBHandler(this);
		SalaDBHandler sal = new SalaDBHandler(this);
		SalaHCPDBHandler salhcp = new SalaHCPDBHandler(this);
		
		//COMENTAR DESDE LA FILA 59 A LA 65 LUEGO DE LA PRIMERA EJECUCIÓN
		pel.InsertarPelículas();
		cin.InsertarCines();
		cp.InsertarCinePeliculas();
		ho.InsertarHorarios();
		hcp.InsertarHorarioXCinePelicula();
		sal.InsertarSalas();
		salhcp.InsertarcreateSalaXHorarioCinePelicula();
       
        vi = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        mImageContainer = (LinearLayout) findViewById(R.id.carousel);
        
        Button btnPelicula = (Button) findViewById(R.id.btnpelicula);
        btnPelicula.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {				
			    vi.vibrate(50);
			    Intent i = new Intent(getApplicationContext(), ActFragPeliculas.class);
			    startActivity(i);
			}
		});
        
        Button btnLocal = (Button) findViewById(R.id.btnlocales);
        btnLocal.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				vi.vibrate(50);
			    Intent i = new Intent(getApplicationContext(), ActListLocales.class);
			    startActivity(i);	
			}
		});
        
        Button btnCartelera = (Button) findViewById(R.id.btnOpcion_10);
        btnCartelera.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				vi.vibrate(50);
			    Intent i = new Intent(getApplicationContext(), ActPeliculasCartelera.class);
			    startActivity(i);	
			}
		});
        
        Button btnReserva = (Button) findViewById(R.id.btnreserva);
        btnReserva.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				vi.vibrate(50);
			    Intent i = new Intent(getApplicationContext(), ActReserva.class);
			    startActivity(i);			
			}
		});
    }
    
    
    @Override
    protected void onDestroy() {
    	// TODO Auto-generated method stub
    	super.onDestroy();
    	vi.cancel();
    }
    
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
    	super.onPostCreate(savedInstanceState);
    	
    	 final DisplayMetrics displayMetrics = new DisplayMetrics();
         getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
         final int imageWidth = (int) (displayMetrics.widthPixels / INITIAL_ITEMS_COUNT);
         
         final TypedArray puppyResourcesTypedArray = getResources().obtainTypedArray(R.array.puppies_array);
         
         ImageView imageItem;
         for (int i = 0 ; i < puppyResourcesTypedArray.length() ; ++i) {
             // Crea nuevo ImageView
             imageItem = new ImageView(this);
             imageItem.setBackgroundResource(R.drawable.shadow);
             
             imageItem.setImageResource(puppyResourcesTypedArray.getResourceId(i, -1));

             // Ponemos las dimensiones de la image view para que se procese el valor
             imageItem.setLayoutParams(new LinearLayout.LayoutParams(imageWidth, imageWidth + 30));
             
             mImageContainer.addView(imageItem);
         }	
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
