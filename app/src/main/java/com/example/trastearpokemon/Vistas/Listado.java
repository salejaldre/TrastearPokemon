package com.example.trastearpokemon.Vistas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.trastearpokemon.BBDD.Pokemon_ADO;
import com.example.trastearpokemon.Controladores.Adaptador_Listado;
import com.example.trastearpokemon.Json.Json;
import com.example.trastearpokemon.Modelos.Pokemon;
import com.example.trastearpokemon.R;

import java.util.ArrayList;
import java.util.List;

public class Listado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        RecyclerView recyclerView;
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Pokemon_ADO ado = new Pokemon_ADO(this);

        List<Pokemon> pokemonlist = new ArrayList<>();
        pokemonlist= ado.getAll();

        recyclerView.setAdapter(new Adaptador_Listado(pokemonlist));
    }
}