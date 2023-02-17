package com.example.trastearpokemon.Controladores;

import android.content.Context;

import com.example.trastearpokemon.BBDD.Pokemon_ADO;
import com.example.trastearpokemon.Json.Json;
import com.example.trastearpokemon.Modelos.Pokemon;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;
import java.util.List;



public class Controlador_Imagenes {

    public static List<String> urls = new ArrayList<>();



    public static List<String> trabajarconfotos(Context context){

        Pokemon_ADO ado = new Pokemon_ADO(context);
        List<Pokemon> datospokemon = ado.getAll();

        for(int i = 0; i < Json.objpokemon.size(); i++){
            urls.add(datospokemon.get(i).getUrl());
        }

        return  urls;
    }
}


