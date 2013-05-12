package com.rgmj.persistencia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SalaDBHandler extends SQLiteOpenHelper {
	
	public static final String ROW_ID = "idSala";
	public static final String NOM_SALA = "nombreSala";
	public static final String DESC_SALA = "descripcionSala";
	
	
	
	public static final String DATABASE_TABLE = "sala";
	
	public SalaDBHandler(Context ctx){
		super(ctx, "cineupcsm.db", null, 1);
		
	}
	
	
    public void createSala (String nombreSala, String descripcionSala){
		
		SQLiteDatabase db = getWritableDatabase();
		db.execSQL("INSERT INTO sala VALUES (null,'" + nombreSala + "', '" + descripcionSala + "')");
		
	}
    
    public void InsertarSalas(){
    	//Si se desea puede alterar está información teniendo en cuenta los tipos de dato correspondientes.
    	createSala("Sala 01", "Es una sala ...");
    	createSala("Sala 02", "Es una sala ...");
    	createSala("Sala 03", "Es una sala ...");
    	createSala("Sala 04", "Es una sala ...");
    	createSala("Sala 05", "Es una sala ...");
    	createSala("Sala 06", "Es una sala ...");
    	createSala("Sala 07", "Es una sala ...");
    	createSala("Sala 08", "Es una sala ...");
    	createSala("Sala 09", "Es una sala ...");
    	createSala("Sala 10", "Es una sala ...");
    	createSala("Sala 11", "Es una sala ...");
    	createSala("Sala 12", "Es una sala ...");
    	createSala("Sala 13", "Es una sala ...");
    	createSala("Sala 14", "Es una sala ...");
    	createSala("Sala 15", "Es una sala ...");
    	createSala("Sala 16", "Es una sala ...");
    	createSala("Sala 17", "Es una sala ...");
    	createSala("Sala 18", "Es una sala ...");
    	createSala("Sala 19", "Es una sala ...");
    	createSala("Sala 20", "Es una sala ...");
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
