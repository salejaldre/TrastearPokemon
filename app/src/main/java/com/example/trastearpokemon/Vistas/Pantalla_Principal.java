package com.example.trastearpokemon.Vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.trastearpokemon.R;

public class Pantalla_Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal);

        Button btnlistado = findViewById(R.id.btnlistado);
        Button btnequipo = findViewById(R.id.btnequipo);

        btnlistado.setOnClickListener(v->{
            Intent intent = new Intent(getApplicationContext(), Listado.class);
            startActivity(intent);
        });

        btnequipo.setOnClickListener(v->{
            Intent intent = new Intent(getApplicationContext(), Equipo.class);
            startActivity(intent);
        });
    }
}