package com.example.trastearpokemon.Vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.example.trastearpokemon.Json.Json;
import com.example.trastearpokemon.R;

public class MainActivity extends AppCompatActivity implements Json.DownloadJSONCallback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Json downloadJson = new Json(this);

        downloadJson.execute("https://raw.githubusercontent.com/fanzeyi/pokemon.json/master/pokedex.json");
    }

    @Override
    public void onDownloadJSONComplete(String result) {
        Handler handler = new Handler(Looper.myLooper());
        handler.postDelayed(()-> {
            Intent intent = new Intent(getApplicationContext(), Listado.class);
            startActivity(intent);
        }, 2500);

    }
}