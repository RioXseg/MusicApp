package com.example.sergi.musicapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;


public final class Database extends SQLiteOpenHelper {

    //CONSTRUCTOR
    public Database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }



    //TABLAS
    //clase interna que define los elementos de una tabla de la base de datos.
    public static class tablaMusica implements BaseColumns {
        public static final String tableName = "Canciones";
        public static final String column_fileName = "Archivo";
        public static final String column_songName = "Cancion";
    }



    //FUNCIONES DE LA BASE DE DATOS
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Musica.db";

    public static final String crearTablaMusica = "CREATE TABLE " + tablaMusica.tableName + " (" + tablaMusica._ID + " INTEGER PRIMARY KEY," + tablaMusica.column_fileName + " TEXT," + tablaMusica.column_songName + " TEXT)";
    public static final String borrarTablaMusica = "DROP TABLE IF EXIST " + tablaMusica.tableName;


    //Se llama solo una vez en toda la app y es cuando se crea por primera vez la tabla
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //creamos las tablas al crear la base de datos
        sqLiteDatabase.execSQL(crearTablaMusica);
    }

    //Se llama cuando se cambia la version de la base de datos y mantiene los datos anteriores con la posibilidad de agregar mas datos en futuro
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //borramos la anterior y creamos una nueva
        sqLiteDatabase.execSQL(borrarTablaMusica);
        onCreate(sqLiteDatabase);
    }

}
