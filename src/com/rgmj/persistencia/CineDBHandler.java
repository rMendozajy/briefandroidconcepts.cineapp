package com.rgmj.persistencia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CineDBHandler extends SQLiteOpenHelper {
	
	public static final String ROW_ID = "idCine";
	public static final String NOM_CINE = "nombreCine";
	public static final String DESC_CINE = "descripcionCine";
	public static final String DIR_CINE = "direccionCine";
	
	
	public static final String DATABASE_TABLE = "cine";
	
	public CineDBHandler(Context ctx){
		super(ctx, "cineupcsm.db", null, 1);
	}
	
	
    public void createCine (String nombreCine, String descripcionCine, String direccionCine){
		
		SQLiteDatabase db = getWritableDatabase();
		db.execSQL("INSERT INTO cine VALUES (null,'" + nombreCine + "','" + descripcionCine + "','" + direccionCine + "')");
		
	}
    
    public void InsertarCines(){
    	//Si se desea puede alterar está información teniendo en cuenta que el tipo de dato debe ser String.
    	createCine("CinePlanet Alcázar", "Es un cine...", "Av. Alcázar 532");//1
    	createCine("CinePlanet Arequipa", "Es un cine...", "Av. Alcázar 532");//2
    	createCine("CinePlanet Arequipa Real Plaza", "Es un cine...", "Av. Alcázar 532");//3
    	createCine("CinePlanet Centro", "Es un cine...", "Av. Alcázar 532");//4
    	createCine("CinePlanet Centro Cívico", "Es un cine...", "Av. Alcázar 532");
    	createCine("CinePlanet Chiclayo", "Es un cine...", "Av. Alcázar 532");
    	createCine("CinePlanet Comas", "Es un cine...", "Av. Alcázar 532");
    	createCine("CinePlanet Huancayo", "Es un cine...", "Av. Alcázar 532");
    	createCine("CinePlanet Juliaca", "Es un cine...", "Av. Alcázar 532");
    	createCine("CinePlanet La Molina", "Es un cine...", "Av. Alcázar 532");
    	createCine("CinePlanet Norte", "Es un cine...", "Av. Alcázar 532");
    	createCine("CinePlanet Piura", "Es un cine...", "Av. Alcázar 532");
    	createCine("CinePlanet Primavera", "Es un cine...", "Av. Alcázar 532");
    	createCine("CinePlanet Pro", "Es un cine...", "Av. Alcázar 532");
    	createCine("CinePlanet Puno", "Es un cine...", "Av. Alcázar 532");
    	createCine("CinePlanet Risso", "Es un cine...", "Av. Alcázar 532");
    	createCine("CinePlanet San Borja", "Es un cine...", "Av. Alcázar 532");
    	createCine("CinePlanet San Miguel", "Es un cine...", "Av. Alcázar 532");
    	createCine("CinePlanet Santa Claro", "Es un cine...", "Av. Alcázar 532");//19	
    }
	
	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	
	
	

}
