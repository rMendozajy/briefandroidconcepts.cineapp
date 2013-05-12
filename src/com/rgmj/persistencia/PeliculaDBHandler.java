package com.rgmj.persistencia;

import java.util.ArrayList;
import java.util.List;

import com.rgmj.beans.PeliculaBean;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteOpenHelper;


public class PeliculaDBHandler extends SQLiteOpenHelper {
	
	public static final String ROW_ID = "idPelicula";
	public static final String NOM_PELICULA = "nombrePelicula";
	public static final String GEN_PELICULA = "generoPelicula";
	public static final String DIREC_PELICULA = "directorPelicula";
	public static final String DESCP_PELICULA = "descripcionPelicula";
	public static final String ES_CARTELERA = "esCartelera";
	
	
	public static final String DATABASE_TABLE = "pelicula";
	
    private SQLiteDatabase mDb;
    
    
    public PeliculaDBHandler(Context ctx){
    	super(ctx, "cineupcsm.db", null, 1);
    }
    
	public void createPelicula (String nombrePelicula, String generoPelicula, String directorPelicula, String descripcionPelicula, int esCartelera ){
		
		SQLiteDatabase db = getWritableDatabase();
		db.execSQL("INSERT INTO pelicula VALUES (null,'" + nombrePelicula + "', '" + generoPelicula + "', '" + directorPelicula + "', '" + descripcionPelicula + "', " + esCartelera + " )");
		
	}
    
    public boolean deletePelicula(long rowID){
    	return this.mDb.delete(DATABASE_TABLE,ROW_ID + "=" + rowID , null) > 0;
    }
    
    public Cursor getAllMovies(){
    	return this.mDb.query( DATABASE_TABLE, new String[]{ROW_ID, NOM_PELICULA, GEN_PELICULA,DIREC_PELICULA,DESCP_PELICULA}, null,null,null,null,null);
    }
    
    public List<PeliculaBean> getAllPeliculas(){
    	List<PeliculaBean> listpelas = new ArrayList<PeliculaBean>();
    	 String selectQuery = "SELECT * FROM " + DATABASE_TABLE;
    	 this.mDb = this.getWritableDatabase();
    	 Cursor cur = mDb.rawQuery(selectQuery, null);
    	 if(cur.moveToFirst()){
    		 do{
    			 PeliculaBean pel = new PeliculaBean();
    			 pel.setIdPelicula(Integer.parseInt(cur.getString(0)));
    			 pel.setNombrePelicula(cur.getString(1));
    			 pel.setGeneroPelicula(cur.getString(2));
    			 pel.setDirectorPelicula(cur.getString(3));
    			 pel.setDescripcionPelicula(cur.getString(4));
    			 listpelas.add(pel);
    		 }while(cur.moveToNext());
    	 }
    	 return listpelas;    	 
    }
    
    public Cursor getMovie(long rowId) throws SQLException {
    	Cursor mcursor = 
    			this.mDb.query(true, DATABASE_TABLE, new String[] {ROW_ID,NOM_PELICULA,GEN_PELICULA,DIREC_PELICULA,DESCP_PELICULA}, ROW_ID + "=" + rowId, null, null, null, null, null);
    	if(mcursor != null){
    		mcursor.moveToFirst();
    	}
    	return mcursor;   
    }
    
    public void InsertarPelículas(){
    	//Si se desea puede alterar está información teniendo en cuenta los tipos de dato correspondientes.
    	createPelicula("Asu Mare", "Comedia", "Pataclaun", "Es una película peruana...",1);//1
    	createPelicula("Fast and Furious 6", "Acción", "Pablo Méndez", "Sexta entrega de....",1);//2
    	createPelicula("Star War 1", "Acción", "George Lucas", "Es una película que...",0);//3
    	createPelicula("Star War 2", "Acción", "George Lucas", "Es una película que...",0);//4
    	createPelicula("Star War 3", "Acción", "George Lucas", "Es una película que...",0);//5
    	createPelicula("Star War 4", "Acción", "George Lucas", "Es una película que...",0);//6
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
