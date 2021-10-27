package com.example.conto;

import android.content.ContentValues;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.Date;

public class GestioneDB {

    //colonne
    static final String KEY_RIGAID = "id";     //colonna 0
    static final String KEY_SOLDI = "soldi";    //colonna 1
    static final String KEY_CASUALE = "casuale";    //colonna 2
    static final String KEY_DATA= "data";       //colonna 3

    static final String TAG = "GestioneDB";
    static final String DATABASE_NOME = "TestDB1";
    static final String DATABASE_TABELLA = "conto1";

    static final int DATABASE_VERSIONE = 1;



    static final String DATABASE_CREAZIONE =
            "CREATE TABLE conto1 (id integer primary key autoincrement, "
                    + "soldi float not null,casuale text not null, data text not null);";



    final Context context;
    DatabaseHelper DBHelper;
    SQLiteDatabase db;

    //per cambiare database tra mio e banca




    public GestioneDB(Context ctx)
    {
        this.context = ctx;

        DBHelper = new DatabaseHelper(context);
    }
//-------------------------------------------------------------------------------
    static class DatabaseHelper extends SQLiteOpenHelper
    {


        DatabaseHelper(Context context)
        {

            super(context, DATABASE_NOME, null, DATABASE_VERSIONE);

        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {

            try {

                    db.execSQL(DATABASE_CREAZIONE);


            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
            Log.w(DatabaseHelper.class.getName(),"Aggiornamento database dalla versione " + oldVersion + " alla "
                    + newVersion + ". I dati esistenti verranno eliminati.");
            db.execSQL("DROP TABLE IF EXISTS clienti");
            onCreate(db);
        }

    }
//-----------------------------------------------------------------------------------------------------------------

    public GestioneDB open() throws SQLException
    {

        db = DBHelper.getWritableDatabase();
        return this;
    }


    public void close()
    {
        DBHelper.close();
    }


    public long inserisciCliente(String soldi,String casuale,String data)
    {
        System.out.println(soldi+casuale+data);
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_SOLDI, soldi);
        initialValues.put(KEY_CASUALE, casuale);
        initialValues.put(KEY_DATA, data);

            return db.insert(DATABASE_TABELLA, null, initialValues);


    }

    public Cursor ottieniTutto()
    {

            return db.query(DATABASE_TABELLA, new String[] {KEY_RIGAID, KEY_SOLDI,KEY_CASUALE, KEY_DATA}, null, null, null, null, null);


    }

    /*
    public boolean cancellaCliente(long rigaId)
    {
        return db.delete(DATABASE_TABELLA, KEY_RIGAID + "=" + rigaId, null) > 0;
    }
    */




    /*
    public Cursor ottieniCliente(long rigaId) throws SQLException
    {
        Cursor mCursore = db.query(true, DATABASE_TABELLA, new String[] {KEY_RIGAID, KEY_SOLDI,KEY_CASUALE, KEY_DATA}, KEY_RIGAID + "=" + rigaId, null, null, null, null, null);
        if (mCursore != null) {
            mCursore.moveToFirst();
        }
        return mCursore;
    }


    public boolean aggiornaCliente(long rigaId, String name, String email)
    {
        ContentValues args = new ContentValues();
        args.put(KEY_CASUALE, name);
        args.put(KEY_DATA, email);
        return db.update(DATABASE_TABELLA, args, KEY_RIGAID + "=" + rigaId, null) > 0;
    }

     */

}
