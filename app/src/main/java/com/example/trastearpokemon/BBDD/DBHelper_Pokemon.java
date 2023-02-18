package com.example.trastearpokemon.BBDD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper_Pokemon extends SQLiteOpenHelper {
    public DBHelper_Pokemon(@Nullable Context context) {
        super(context, "bbdd_pokemon.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS equipo");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS pokemon");
        //sqLiteDatabase.execSQL("DROP TABLE IF EXISTS usuarios");

        sqLiteDatabase.execSQL("CREATE TABLE pokemon (id INTEGER PRIMARY KEY, name TEXT, type1 TEXT, " +
                "type2 TEXT,hp TEXT,attack TEXT, defense TEXT, spattack TEXT, spdefense TEXT, speed TEXT, url TEXT )");

        sqLiteDatabase.execSQL("CREATE TABLE equipo (id INTEGER PRIMARY KEY AUTOINCREMENT, pokemon1 TEXT, " +
                "pokemon2 TEXT, pokemon3 TEXT, pokemon4 TEXT, pokemon5 TEXT, " +
                "pokemon6 TEXT)");

        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS usuarios (id INTEGER PRIMARY KEY AUTOINCREMENT, usuario TEXT UNIQUE, " +
                "password TEXT)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
