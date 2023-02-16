package com.example.trastearpokemon.Controladores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trastearpokemon.Json.Json;
import com.example.trastearpokemon.Modelos.Pokemon;
import com.example.trastearpokemon.R;

import java.util.List;

public class Adaptador_Listado extends RecyclerView.Adapter<Adaptador_Listado.ViewHolder> {
    List<Pokemon> lista;

    public Adaptador_Listado(List<Pokemon> listita) {
        this.lista = listita;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View vista = inflater.inflate(R.layout.lista_layout, parent, false);
        return new ViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nombre.setText(lista.get(position).getName());
        holder.type.setText(lista.get(position).getType1());
    }

    @Override
    public int getItemCount() {return lista.size();}

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView nombre;
        TextView type;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.txtnombre);
            type = itemView.findViewById(R.id.txttype);
        }
    }
}
