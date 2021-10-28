package com.example.conto;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseRicorda {

    //colonne
    static final String KEY_RIGAID = "id";     //colonna 0
    static final String KEY_RICORDO = "ricorda";    //colonna 2
    static final String KEY_DATA= "data";       //colonna 3

    static final String TAG = "DatabaseRicoda";
    static final String DATABASE_NOME = "TestDBBRico";
    static final String DATABASE_TABELLA = "ricorda";
    static final int DATABASE_VERSIONE = 2;



    static final String DATABASE_CREAZIONE =
            "CREATE TABLE ricorda (id integer primary key autoincrement, "
                    + "ricorda text not null, data text not null);";



    final Context contextB;
    DatabaseRicorda.DatabaseHelperB DBHelperB;
    SQLiteDatabase dbB;


    public DatabaseRicorda(Context ctx)
    {
        this.contextB = ctx;

        DBHelperB = new DatabaseRicorda.DatabaseHelperB(contextB);
    }

    //-------------------------------------------------------------------------------
    private static class DatabaseHelperB extends SQLiteOpenHelper
    {


        DatabaseHelperB(Context context)
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
            Log.w(DatabaseRicorda.DatabaseHelperB.class.getName(),"Aggiornamento database dalla versione " + oldVersion + " alla "
                    + newVersion + ". I dati esistenti verranno eliminati.");
            db.execSQL("DROP TABLE IF EXISTS clienti");
            onCreate(db);
        }

    }
//-----------------------------------------------------------------------------------------------------------------

    public DatabaseRicorda open() throws SQLException
    {
        dbB = DBHelperB.getWritableDatabase();
        return this;
    }


    public void close()
    {
        DBHelperB.close();
    }


    public long inserisciCliente(String casuale,String data)
    {
        System.out.println(casuale+data);
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_RICORDO, casuale);
        initialValues.put(KEY_DATA, data);

        return dbB.insert(DATABASE_TABELLA, null, initialValues);


    }

    public Cursor ottieniTutto()
    {

        return dbB.query(DATABASE_TABELLA, new String[] {KEY_RIGAID, KEY_RICORDO, KEY_DATA}, null, null, null, null, null);


    }

    public boolean cancellaCliente(long rigaId)
    {
        return dbB.delete(DATABASE_TABELLA, KEY_RIGAID + "=" + rigaId, null) > 0;
    }

}
