package com.rgmj.persistencia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class HorariosDBHandler extends SQLiteOpenHelper {
	public static final String ROW_ID = "idHorario";
	public static final String INI_HORARIO = "comienzoHorario";
	public static final String FIN_HORARIO = "finHorario";
		
	private static final String DATABASE_TABLE = "horario";
	
     
    public HorariosDBHandler(Context ctx){
    	super(ctx, "cineupcsm.db", null, 1);
    }
    
    public void createHorario(String iniHorario, String finHorario){
    	SQLiteDatabase db = getWritableDatabase();
    	db.execSQL("INSERT INTO horario VALUES (null,'" + iniHorario + "', '" + finHorario + "')");
    }
    
    public boolean deleteHorario(long rowID){
    	SQLiteDatabase db = getWritableDatabase();
    	return db.delete(DATABASE_TABLE,ROW_ID + "=" + rowID , null) > 0;
    }
    
    public void InsertarHorarios(){
    	createHorario("12:00", "14:00");//1
    	createHorario("12:15", "14:15");//2
    	createHorario("12:30", "14:30");//3
    	createHorario("12:45", "14:45");//4
    	createHorario("13:00", "15:00");//5
    	createHorario("13:15", "15:15");//6
    	createHorario("13:30", "15:30");//7
    	createHorario("13:45", "15:45");//8
    	createHorario("14:00", "16:00");//9
    	createHorario("14:15", "16:15");//10
    	createHorario("14:30", "16:30");//11
    	createHorario("14:45", "16:45");//12
    	createHorario("15:00", "17:00");//13
    	createHorario("15:15", "17:15");//14
  	
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
