package com.example.trastearpokemon.Controladores;
import static com.example.trastearpokemon.Json.Json.objpokemon;
import static com.example.trastearpokemon.Vistas.Equipo.equipolocal;
import static com.example.trastearpokemon.Vistas.Equipo.posicion;
import static com.example.trastearpokemon.Vistas.Equipo.seleccionado;
import static com.example.trastearpokemon.Vistas.Equipo.seleccionado;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.example.trastearpokemon.R;
import com.example.trastearpokemon.R;

public class Controlador_AlertDialog extends AppCompatActivity {

    public void mostraralerta(Context context){

        AlertDialog.Builder alerta = new AlertDialog.Builder(context);
        LayoutInflater inflater = getLayoutInflater();
        View vista = inflater.inflate(R.layout.editarequipo_layout,null);
        alerta.setView(vista);

        EditText nombre = vista.findViewById(R.id.camponombre);

        nombre.setText(seleccionado);

        alerta.setPositiveButton("Añadir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                comprobar(nombre);
            }
        });
    }

    private void comprobar(EditText campo) {
        String nombre = campo.getText().toString();
        if(!nombre.trim().equals("")){

            for(int q=0;q<objpokemon.size();q++){
                if(nombre.equals(objpokemon.get(q).getName())){

                    equipolocal.add(posicion,objpokemon.get(q));
                    equipolocal.remove(posicion+1);
                }
            }
        }
    }

    public static boolean comprobarseleccion(RadioButton boton){
        return boton.isChecked();
    }
}