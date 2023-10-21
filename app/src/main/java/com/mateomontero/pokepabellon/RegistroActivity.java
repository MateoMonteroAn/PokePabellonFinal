package com.mateomontero.pokepabellon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mateomontero.pokepabellon.R;
import com.mateomontero.pokepabellon.logica.ControladorRegistro;
import com.mateomontero.pokepabellon.logica.controladorLogin;
import com.mateomontero.pokepabellon.modelo.Carrito;
import com.mateomontero.pokepabellon.modelo.Usuario;

public class RegistroActivity extends AppCompatActivity {
    Usuario usuario;
    Carrito carrito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);


        EditText T_Usuario=(EditText) findViewById(R.id.RegistroActivity_TextoUsuario);
        EditText T_password=(EditText) findViewById(R.id.RegistroActivity_TextoPassword);
        EditText T_correo=(EditText) findViewById(R.id.RegistroActivity_TectoCorreo);
        Button botonLogin=(Button) findViewById(R.id.RegistroActivity_botonInicioSesion);
        botonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre=T_Usuario.toString();
                String correo=T_correo.toString();
                String password=T_password.toString();
                boolean comp=new ControladorRegistro().run(nombre,correo,password);
                Intent i=new Intent(RegistroActivity.this,MainActivity.class);
                i.putExtra("boolean",comp);

                startActivity(i);

                finish();
            }
        });

        Button b_main=(Button) findViewById(R.id.RegistroActivity_botonMain);
        b_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(RegistroActivity.this,MainActivity.class);
                i.putExtra("usuario",usuario);
                i.putExtra("carrito",carrito);
                startActivity(i);

                finish();
            }
        });
    }
}