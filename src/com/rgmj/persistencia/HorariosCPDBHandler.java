package com.rgmj.persistencia;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class HorariosCPDBHandler extends SQLiteOpenHelper{
	public static final String ROW_ID_HORARIO = "idHorario";
	public static final String ROW_ID_CINEPELI = "idCinepeli";
	public static final String ROW_HORARIOCP = "idHorariocp";//pk
	
	private static final String DATABASE_TABLE = "horarioxcinepelicula";
   
    public HorariosCPDBHandler(Context ctx){
    	super(ctx, "cineupcsm.db", null, 1);
    }
    
    public void createHorarioXCinePelicula(int idHorario, int idCinepeli){
    	SQLiteDatabase db = getWritableDatabase();
    	db.execSQL("INSERT INTO horarioxcinepelicula VALUES (null," + idCinepeli + ", " + idHorario + ")");
    }
	
    private final String MY_QUERY = "SELECT p.nombrePelicula, h.comienzoHorario, h.finHorario FROM horarioxpelicula hp INNER JOIN pelicula p ON p.idPelicula = hp.idPelicula INNER JOIN horario h ON hp.idHorario = h.idHorario WHERE hp.idPelicula = ?";
    
	public Cursor getAllHorariosXMovie(String idPelicula){
		SQLiteDatabase db = getWritableDatabase();
		return db.rawQuery(MY_QUERY, new String[] {idPelicula});
	}
	public void InsertarHorarioXCinePelicula(){
		
		createHorarioXCinePelicula(1,1);//1
		createHorarioXCinePelicula(1,11);//2
		createHorarioXCinePelicula(13,23);//3
		createHorarioXCinePelicula(9,14);//4
		createHorarioXCinePelicula(7,16);//5
		createHorarioXCinePelicula(4,18);//6
		createHorarioXCinePelicula(3,13);
		createHorarioXCinePelicula(5,15);
		createHorarioXCinePelicula(7,9);
		createHorarioXCinePelicula(14,3);
		createHorarioXCinePelicula(8,1);
		createHorarioXCinePelicula(8,2);
		createHorarioXCinePelicula(9,4);
		createHorarioXCinePelicula(10,5);
		createHorarioXCinePelicula(11,6);
		createHorarioXCinePelicula(12,7);
		createHorarioXCinePelicula(8,8);
		createHorarioXCinePelicula(7,10);
		createHorarioXCinePelicula(2,12);
		createHorarioXCinePelicula(12,17);
		createHorarioXCinePelicula(11,19);
		createHorarioXCinePelicula(10,20);
		createHorarioXCinePelicula(10,29);//23
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
