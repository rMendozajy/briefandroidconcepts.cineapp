package com.rgmj.persistencia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SalaHCPDBHandler extends SQLiteOpenHelper {
	
	public static final String ROW_ID = "idSalahcp";
	public static final String ROW_HORARIOCP = "idHorariocp";
	public static final String ROW_SALA = "idSala";
	
	
	
	public static final String DATABASE_TABLE = "salaxhorariocinepelicula";
	
	public SalaHCPDBHandler(Context ctx){
		super(ctx, "cineupcsm.db", null, 1);
	}
	
	public void createSalaXHorarioCinePelicula(int idHorariocp, int idSala){
    	SQLiteDatabase db = getWritableDatabase();
    	db.execSQL("INSERT INTO salaxhorariocinepelicula VALUES (null," + idHorariocp + ", " + idSala + ")");
    }
	
	public void InsertarcreateSalaXHorarioCinePelicula(){
		createSalaXHorarioCinePelicula(23,20);
		createSalaXHorarioCinePelicula(21,20);
		createSalaXHorarioCinePelicula(20,19);
		createSalaXHorarioCinePelicula(1,18);
		createSalaXHorarioCinePelicula(1,17);
		createSalaXHorarioCinePelicula(22,17);
		createSalaXHorarioCinePelicula(22,16);
		createSalaXHorarioCinePelicula(19,15);
		createSalaXHorarioCinePelicula(19,14);
		createSalaXHorarioCinePelicula(18,14);
		createSalaXHorarioCinePelicula(17,13);
		createSalaXHorarioCinePelicula(17,13);
		createSalaXHorarioCinePelicula(16,12);
		createSalaXHorarioCinePelicula(15,12);
		createSalaXHorarioCinePelicula(15,11);
		createSalaXHorarioCinePelicula(14,11);
		createSalaXHorarioCinePelicula(14,10);
		createSalaXHorarioCinePelicula(13,9);
		createSalaXHorarioCinePelicula(12,8);
		createSalaXHorarioCinePelicula(11,7);
		createSalaXHorarioCinePelicula(10,6);
		createSalaXHorarioCinePelicula(9,5);
		createSalaXHorarioCinePelicula(8,4);
		createSalaXHorarioCinePelicula(7,3);
		createSalaXHorarioCinePelicula(6,2);
		createSalaXHorarioCinePelicula(5,2);
		createSalaXHorarioCinePelicula(4,1);
		createSalaXHorarioCinePelicula(3,9);
		createSalaXHorarioCinePelicula(3,8);
		createSalaXHorarioCinePelicula(2,7);
		createSalaXHorarioCinePelicula(1,6);
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
