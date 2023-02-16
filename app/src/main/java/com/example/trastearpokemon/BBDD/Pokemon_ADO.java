package com.example.trastearpokemon.BBDD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.trastearpokemon.Json.Json;
import com.example.trastearpokemon.Modelos.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class Pokemon_ADO implements AutoCloseable{

    private DBHelper_Pokemon helper;
    private SQLiteDatabase db;
    private Context context;

    public static List<Pokemon> datosPokemon = new ArrayList<>();


    public Pokemon_ADO(Context context){
        helper = new DBHelper_Pokemon(context);
        db = helper.getReadableDatabase();
    }

    public void dropTablePokemon(){
        db.execSQL("DROP TABLE IF EXISTS pokemon");

        db.execSQL("CREATE TABLE pokemon (id INTEGER PRIMARY KEY, name TEXT, type1 TEXT," +
                "type2 TEXT,hp TEXT,attack TEXT, defense TEXT, spattack TEXT, spdefense TEXT, speed TEXT )");


    }

    public void insertar(Pokemon pokemon){
        ContentValues valores = new ContentValues();

        valores.put("id",pokemon.getId());
        valores.put("name",pokemon.getName().replace("\"", ""));
        valores.put("type1",pokemon.getType1().replace("\"", ""));
        valores.put("type2",pokemon.getType2().replace("\"", ""));
        valores.put("hp",pokemon.getHp().replace("\"", ""));
        valores.put("attack",pokemon.getAttack().replace("\"", ""));
        valores.put("defense",pokemon.getDefense().replace("\"", ""));
        valores.put("spattack",pokemon.getSpattack().replace("\"", ""));
        valores.put("spdefense",pokemon.getSpdefense().replace("\"", ""));
        valores.put("speed",pokemon.getSpeed().replace("\"", ""));

        helper.getWritableDatabase().insert("pokemon",null,valores);

    }


    public void insertAll(){
        DBHelper_Pokemon helperPokemon = new DBHelper_Pokemon(context);

        helperPokemon.onCreate(db);

        for (int i = 0; i< Json.objpokemon.size(); i++){
            insertar(Json.objpokemon.get(i));
        }

    }

    public List<Pokemon> getAll(){
        String sql = "SELECT * FROM pokemon";
        Cursor cursor = db.rawQuery(sql,null);

        datosPokemon.clear();
        while(cursor.moveToNext()){

            Pokemon poke = new Pokemon();

            poke.setId(cursor.getInt(0));
            poke.setName(cursor.getString(1));
            poke.setType1(cursor.getString(2));
            poke.setType2(cursor.getString(3));
            poke.setHp(cursor.getString(4));
            poke.setAttack(cursor.getString(5));
            poke.setDefense(cursor.getString(6));
            poke.setSpattack(cursor.getString(7));
            poke.setSpdefense(cursor.getString(8));
            poke.setSpeed(cursor.getString(9));

            datosPokemon.add(poke);
        }

        return datosPokemon;
    }





    @Override
    public void close() throws Exception {

    }
}
