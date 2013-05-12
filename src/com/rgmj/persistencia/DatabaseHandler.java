package com.rgmj.persistencia;
/**
 * Develop by Rubén Mendoza
 */

import java.util.ArrayList;
import java.util.List;

import com.rgmj.beans.CineBean;
import com.rgmj.beans.PeliculaBean;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHandler extends SQLiteOpenHelper {

	public static final String DATABASE_NAME = "cineupcsm.db"; //$NON-NLS-1$

    public static final int DATABASE_VERSION = 1;
    
    private static final String TAG = "Creacion bases de datos";
        
    private static final String CREATE_TABLE_PELICULA =
    	       "create table pelicula (idPelicula integer primary key autoincrement, " //$NON-NLS-1$
    	    + PeliculaDBHandler.NOM_PELICULA + " varchar(100), " 
    	    + PeliculaDBHandler.GEN_PELICULA + " varchar(100), "
    	    + PeliculaDBHandler.DIREC_PELICULA + " varchar(100), "
    	    + PeliculaDBHandler.DESCP_PELICULA + " varchar(100), "
    	    + PeliculaDBHandler.ES_CARTELERA + " INTEGER);"; //$NON-NLS-1$
    
    private static final String CREATE_TABLE_CINE =
 	       "create table cine (idCine integer primary key autoincrement, " //$NON-NLS-1$
 	    + CineDBHandler.NOM_CINE + " varchar(100), " 
 	    + CineDBHandler.DESC_CINE + " varchar(100), "
 	    + CineDBHandler.DIR_CINE + " varchar(100));"; //$NON-NLS-1$
    
    private static final String CREATE_TABLE_CINE_X_PELICULA = 
  	       "create table cinexpelicula (idCinepeli integer primary key autoincrement, " //$NON-NLS-1$
    	+ CinePeliculaDBHandler.ID_PELICULA + " INTEGER, " 
    	+ CinePeliculaDBHandler.ID_CINE + " INTEGER, " 
  	    + "foreign key (" + CinePeliculaDBHandler.ID_PELICULA +") references pelicula(" + PeliculaDBHandler.ROW_ID +"), "
  	    + "foreign key (" + CinePeliculaDBHandler.ID_CINE +") references cine(" + CineDBHandler.ROW_ID +"));"; //$NON-NLS-1$
    
    private static final String CREATE_TABLE_HORARIOS = 
    		"create table horario (idHorario integer primary key autoincrement, " //$NON-NLS-1$
    								+ HorariosDBHandler.INI_HORARIO + " varchar(100), " //$NON-NLS-1$
    								+ HorariosDBHandler.FIN_HORARIO + " varchar(100));"; //$NON-NLS-1$
    
    private static final String CREATE_TABLE_HORARIO_X_CINEPELICULA = 
    	       "create table horarioxcinepelicula (idHorariocp integer primary key autoincrement, " //$NON-NLS-1$
    	    + HorariosCPDBHandler.ROW_ID_CINEPELI + " INTEGER, " 
    	    + HorariosCPDBHandler.ROW_ID_HORARIO + " INTEGER, " 
    	    + "foreign key (" + HorariosCPDBHandler.ROW_ID_CINEPELI +") references cinexpelicula(" + CinePeliculaDBHandler.ROW_ID +"), "
    	    + "foreign key (" + HorariosCPDBHandler.ROW_ID_HORARIO +") references horario(" + HorariosDBHandler.ROW_ID +"));"; //$NON-NLS-1$
    
    private static final String CREATE_TABLE_SALA =
  	       "create table sala (idSala integer primary key autoincrement, " //$NON-NLS-1$
  	    + SalaDBHandler.NOM_SALA + " varchar(100), " 
  	    + SalaDBHandler.DESC_SALA + " varchar(100));"; //$NON-NLS-1$
    
    private static final String CREATE_TABLE_SALA_X_HORARIOCINEPELICULA = 
 	       "create table salaxhorariocinepelicula (idSalahcp integer primary key autoincrement, " //$NON-NLS-1$
 	    + SalaHCPDBHandler.ROW_HORARIOCP + " INTEGER, " 
 	    + SalaHCPDBHandler.ROW_SALA + " INTEGER, " 
 	    + "foreign key (" + SalaHCPDBHandler.ROW_HORARIOCP +") references horarioxcinepelicula(" + HorariosCPDBHandler.ROW_HORARIOCP +"), "
    	+ "foreign key (" + SalaHCPDBHandler.ROW_SALA +") references sala(" + SalaDBHandler.ROW_ID +"));";//$NON-NLS-1$
    
    public DatabaseHandler(Context ctx){
    	super(ctx, DATABASE_NAME, null, DATABASE_VERSION);
    }
    
    public void deleteDatabase(Context ctx){
		ctx.deleteDatabase("Cineplanetupc");	
	}
    
    public List<PeliculaBean> getAllPeliculas(){
    	List<PeliculaBean> listpelas = new ArrayList<PeliculaBean>();
    	 String selectQuery = "SELECT * FROM " + PeliculaDBHandler.DATABASE_TABLE;
    	 SQLiteDatabase db = this.getWritableDatabase();
    	 Cursor cur = db.rawQuery(selectQuery, null);
    	 if(cur.moveToFirst()){
    		 do{
    			 PeliculaBean pel = new PeliculaBean();
    			 pel.setIdPelicula(Integer.parseInt(cur.getString(0)));
    			 pel.setNombrePelicula(cur.getString(1));
    			 pel.setGeneroPelicula(cur.getString(2));
    			 pel.setDirectorPelicula(cur.getString(3));
    			 pel.setDescripcionPelicula(cur.getString(4));
    			 pel.setEsCartelera(Integer.parseInt(cur.getString(5)));
    			 listpelas.add(pel);
    		 }while(cur.moveToNext());
    	 }
    	 return listpelas;    	 
    }
    
    
    public Cursor getAllPeliculasCursor(){
    	 String selectQuery = "SELECT idPelicula AS _id, nombrePelicula FROM " + PeliculaDBHandler.DATABASE_TABLE;
    	 SQLiteDatabase db = this.getWritableDatabase();
    	 Cursor cur = db.rawQuery(selectQuery, null);	 
    	 return cur;    	 
    }
    
    
    public List<PeliculaBean> getAllPeliculasCartelera(){
    	List<PeliculaBean> listpelas = new ArrayList<PeliculaBean>();
    	 String selectQuery = "SELECT * FROM pelicula p WHERE p.esCartelera = 1";
    	 SQLiteDatabase db = this.getWritableDatabase();
    	 Cursor cur = db.rawQuery(selectQuery, null);
    	 if(cur.moveToFirst()){
    		 do{
    			 PeliculaBean pel = new PeliculaBean();
    			 pel.setIdPelicula(Integer.parseInt(cur.getString(0)));
    			 pel.setNombrePelicula(cur.getString(1));
    			 pel.setGeneroPelicula(cur.getString(2));
    			 pel.setDirectorPelicula(cur.getString(3));
    			 pel.setDescripcionPelicula(cur.getString(4));
    			 pel.setEsCartelera(Integer.parseInt(cur.getString(5)));
    			 listpelas.add(pel);
    		 }while(cur.moveToNext());
    	 }
    	 return listpelas;    	 
    }
    
    public List<CineBean> getAllLocales(){
    	List<CineBean> listlocales = new ArrayList<CineBean>();
    	 String selectQuery = "SELECT * FROM " + CineDBHandler.DATABASE_TABLE;
    	 SQLiteDatabase db = this.getWritableDatabase();
    	 Cursor cur = db.rawQuery(selectQuery, null);
    	 if(cur.moveToFirst()){
    		 do{
    			 CineBean local = new CineBean();
    			 local.setIdCine(Integer.parseInt(cur.getString(0)));
    			 local.setNombreCine(cur.getString(1));
    			 local.setDescCine(cur.getString(2));
    			 local.setDirecCine(cur.getString(3));
    			 listlocales.add(local);
    		 }while(cur.moveToNext());
    	 }
    	 return listlocales;    	 
    }
    
    public Cursor getAllLocalesCursor(){
    	 String selectQuery = "SELECT idCine AS _id, nombreCine FROM " + CineDBHandler.DATABASE_TABLE;
    	 SQLiteDatabase db = this.getWritableDatabase();
    	 Cursor cur = db.rawQuery(selectQuery, null);
    	 return cur;   	 
    }
    
    public void createDatabase(){
    	SQLiteDatabase db = this.getWritableDatabase();
    	db.execSQL(CREATE_TABLE_PELICULA);
		Log.w(TAG, DATABASE_NAME);
        db.execSQL(CREATE_TABLE_CINE);
        Log.w(TAG, DATABASE_NAME);
        db.execSQL(CREATE_TABLE_CINE_X_PELICULA);
        Log.w(TAG, DATABASE_NAME);
        db.execSQL(CREATE_TABLE_HORARIOS);
		Log.w(TAG, DATABASE_NAME);
        db.execSQL(CREATE_TABLE_HORARIO_X_CINEPELICULA);
        Log.w(TAG, DATABASE_NAME);
        db.execSQL(CREATE_TABLE_SALA);
        Log.w(TAG, DATABASE_NAME);
        db.execSQL(CREATE_TABLE_SALA_X_HORARIOCINEPELICULA);
        Log.w(TAG, DATABASE_NAME);  	
    }

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}	
}
