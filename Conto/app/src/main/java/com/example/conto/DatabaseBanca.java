package com.example.conto;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseBanca {


    //colonne
    static final String KEY_RIGAID = "id";     //colonna 0
    static final String KEY_SOLDI = "soldi";    //colonna 1
    static final String KEY_CASUALE = "casuale";    //colonna 2
    static final String KEY_DATA= "data";       //colonna 3

    static final String TAG = "DatabaseBanca";
    static final String DATABASE_NOME = "TestDBB";
    static final String DATABASE_TABELLA = "banca";
    static final int DATABASE_VERSIONE = 2;



    static final String DATABASE_CREAZIONE =
            "CREATE TABLE banca (id integer primary key autoincrement, "
                    + "soldi float not null,casuale text not null, data text not null);";



    final Context contextB;
    DatabaseBanca.DatabaseHelperB DBHelperB;
    SQLiteDatabase dbB;


    public DatabaseBanca(Context ctx)
    {
        this.contextB = ctx;

        DBHelperB = new DatabaseBanca.DatabaseHelperB(contextB);
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
            Log.w(DatabaseBanca.DatabaseHelperB.class.getName(),"Aggiornamento database dalla versione " + oldVersion + " alla "
                    + newVersion + ". I dati esistenti verranno eliminati.");
            db.execSQL("DROP TABLE IF EXISTS clienti");
            onCreate(db);
        }

    }
//-----------------------------------------------------------------------------------------------------------------

    public DatabaseBanca open() throws SQLException
    {
        dbB = DBHelperB.getWritableDatabase();
        return this;
    }


    public void close()
    {
        DBHelperB.close();
    }


    public long inserisciCliente(String soldi,String casuale,String data)
    {
        System.out.println(soldi+casuale+data);
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_SOLDI, soldi);
        initialValues.put(KEY_CASUALE, casuale);
        initialValues.put(KEY_DATA, data);

            return dbB.insert(DATABASE_TABELLA, null, initialValues);


    }

    public Cursor ottieniTutto()
    {

            return dbB.query(DATABASE_TABELLA, new String[] {KEY_RIGAID, KEY_SOLDI,KEY_CASUALE, KEY_DATA}, null, null, null, null, null);


    }



}
