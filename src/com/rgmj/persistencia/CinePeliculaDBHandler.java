package com.rgmj.persistencia;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CinePeliculaDBHandler extends SQLiteOpenHelper{
	
	public static final String ROW_ID = "idCinepeli";
	public static final String ID_PELICULA = "idPelicula";
	public static final String ID_CINE = "idCine";
	
	
	public static final String DATABASE_TABLE = "cinexpelicula";
	
	public CinePeliculaDBHandler(Context ctx){
		super(ctx, "cineupcsm.db", null, 1);
	}
	
	
    public void createCinePeliculas (int idPelicula, int idCine){
		
		SQLiteDatabase db = getWritableDatabase();
		db.execSQL("INSERT INTO cinexpelicula VALUES (null," + idPelicula + ", " + idCine + ")");
		
	}
    
    public Cursor getLocalesXMovie(int idPelicula){
    	String sQuery = "select cp.idCinepeli, cp.idCine, c.nombreCine, c.descripcionCine, c.direccionCine from cinexpelicula cp inner join cine c on cp.idCine = c.idCine inner join pelicula p on p.idPelicula = cp.idPelicula where p.idPelicula = ?";
    	SQLiteDatabase db = this.getWritableDatabase();
    	Cursor cur = db.rawQuery(sQuery,new String[]{String.valueOf(idPelicula)});
        return cur;    
    }
    //CARTELERA POR LOCAL
    public Cursor getMoviesXLocal(int idLocal){
    	String sQuery = "select cp.idCinepeli, cp.idPelicula, p.nombrePelicula, p.generoPelicula, p.directorPelicula from cinexpelicula cp inner join cine c on cp.idCine = c.idCine inner join pelicula p on p.idPelicula = cp.idPelicula where c.idCine = ? AND p.esCartelera = 1";
    	SQLiteDatabase db = this.getWritableDatabase();
    	Cursor cur = db.rawQuery(sQuery,new String[]{String.valueOf(idLocal)});
        return cur;    
    }
    
    	
    public void InsertarCinePeliculas(){
    	createCinePeliculas(1,3);//1
    	createCinePeliculas(6,3);//2
    	createCinePeliculas(4,3);//3
    	createCinePeliculas(5,3);//4
    	createCinePeliculas(1,1);//5
    	createCinePeliculas(2,1);//6
    	createCinePeliculas(3,2);//7
    	createCinePeliculas(6,4);//8
    	createCinePeliculas(1,5);//9
    	createCinePeliculas(3,5);
    	createCinePeliculas(1,6);
    	createCinePeliculas(6,5);
    	createCinePeliculas(3,6);
    	createCinePeliculas(1,7);
    	createCinePeliculas(4,8);
    	createCinePeliculas(1,8);
    	createCinePeliculas(2,9);
    	createCinePeliculas(1,10);
    	createCinePeliculas(5,10);
    	createCinePeliculas(1,11);
    	createCinePeliculas(6,11);
    	createCinePeliculas(4,11);
    	createCinePeliculas(6,12);
    	createCinePeliculas(3,13);
    	createCinePeliculas(1,13);
    	createCinePeliculas(5,13);
    	createCinePeliculas(3,15);
    	createCinePeliculas(1,16);
    	createCinePeliculas(6,14);//29
    	
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
