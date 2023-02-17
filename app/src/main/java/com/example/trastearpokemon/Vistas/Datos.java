package com.example.trastearpokemon.Vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.trastearpokemon.Controladores.Controlador_Imagenes;
import com.example.trastearpokemon.Modelos.Pokemon;
import com.example.trastearpokemon.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Datos extends AppCompatActivity {

    private int posicion;
    List<Pokemon> datospokemon = new ArrayList<>();
    private TextView txturl;
    private ImageView imgpoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        imgpoke = findViewById(R.id.imgfotopoke);

        posicion = getIntent().getIntExtra("posicion", 0);
        datospokemon = (List<Pokemon>) getIntent().getSerializableExtra("array");

        mostrarImagen();

        }

    public void mostrarImagen(){
        List<String> urlsimagenes = Controlador_Imagenes.trabajarconfotos(getApplicationContext());


        for (int i = 0; i < urlsimagenes.size(); i++){
            urlsimagenes.get(i);
        }

        Picasso.get().load(urlsimagenes.get(posicion)).into(imgpoke);

        System.out.println();
    }
}