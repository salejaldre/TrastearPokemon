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
import java.util.List;

public class Login extends AppCompatActivity {

    private EditText txtusuario;
    private EditText txtpass;
    private Button btnacceder;
    private Button btnregistrarse;

    private String user;
    private String pass;
    private static Usuario datosuser;
    private static Usuarios_ADO userado;

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

            userado = new Usuarios_ADO(getApplicationContext());

            List<Usuario> todosusers = userado.getAll();

            if (user.equals("") || pass.equals("")){
                Toast.makeText(this, "Debes introducir los dos campos", Toast.LENGTH_SHORT).show();
            } else {

                int hola = 0;
                boolean pez = true;

                if(todosusers.size() == 0){
                    objusuario(user, pass);
                } else {

                    do {
                        if (user.equals(todosusers.get(hola).getUser())) {
                            Toast.makeText(this, "Ese usuario ya esta registrado", Toast.LENGTH_SHORT).show();
                            pez = false;
                            break;
                        }

                        hola++;
                    } while (hola < todosusers.size());
                }

                if(pez == true){

                    objusuario(user, pass);

                    Toast.makeText(this, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show();

                    txtusuario.setText("");
                    txtpass.setText("");
                }
            }
        });

        btnacceder.setOnClickListener(v-> {

            user = txtusuario.getText().toString().trim();
            pass = txtpass.getText().toString().trim();

            if (user.equals("") || pass.equals("")) {
                Toast.makeText(this, "Debes introducir los dos campos", Toast.LENGTH_SHORT).show();
            } else{

                if (userado.validarLogin(user, pass)) {
                    txtusuario.setText("");
                    txtpass.setText("");
                    Intent intent = new Intent(getApplicationContext(), Pantalla_Principal.class);
                    startActivity(intent);
                } else {
                    if (Usuarios_ADO.datosusuario.size() == 0) {
                        Toast.makeText(getApplicationContext(), "No hay ningun usuario registrado aun, registrese antes", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(this, "LOGIN ERRONEO", Toast.LENGTH_SHORT).show();
                    }

                }
            }

        });

    }
    private static void objusuario(String user, String pass){
        datosuser = new Usuario(user, pass);
        userado.insertar(datosuser);
    }
}