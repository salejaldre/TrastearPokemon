package com.example.trastearpokemon.Vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.trastearpokemon.BBDD.Usuarios_ADO;
import com.example.trastearpokemon.Modelos.Usuario;
import com.example.trastearpokemon.R;

import java.io.DataOutputStream;

public class Login extends AppCompatActivity {

    private EditText txtusuario;
    private EditText txtpass;
    private Button btnacceder;
    private Button btnregistrarse;

    private String user;
    private String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtusuario = findViewById(R.id.txtusuario);
        txtpass = findViewById(R.id.txtpass);
        btnacceder = findViewById(R.id.btnacceder);
        btnregistrarse = findViewById(R.id.btnregistrarse);

        btnregistrarse.setOnClickListener(v->{

            user = txtusuario.getText().toString().trim();
            pass = txtpass.getText().toString().trim();

            if (user.equals("") || pass.equals("")){
                Toast.makeText(this, "Debes introducir los dos campos", Toast.LENGTH_SHORT).show();
            } else{
                Usuario nuevouser = new Usuario(user, pass);
                Usuarios_ADO userado = new Usuarios_ADO(getApplicationContext());
                userado.insertar(nuevouser);

                txtusuario.setText("");
                txtpass.setText("");
            }

        });

        btnacceder.setOnClickListener(v->{

            user = txtusuario.getText().toString().trim();
            pass = txtpass.getText().toString().trim();

            Usuarios_ADO userado = new Usuarios_ADO(getApplicationContext());
            if(userado.validarLogin(user,pass)){
                Intent intent = new Intent(getApplicationContext(), Pantalla_Principal.class);
                startActivity(intent);
            } else{
                if(Usuarios_ADO.datosusuario.size() == 0){
                    Toast.makeText(getApplicationContext(), "No hay ningun usuario registrado aun, registrese antes", Toast.LENGTH_SHORT).show();

                } else{
                    Toast.makeText(this, "MAL LOGIN", Toast.LENGTH_SHORT).show();
                }

            }

        });
    }
}