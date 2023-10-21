package com.mateomontero.pokepabellon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mateomontero.pokepabellon.controlador.ControladorRegistro;
import com.mateomontero.pokepabellon.modelo.Carrito;
import com.mateomontero.pokepabellon.modelo.Usuario;

public class RegistrarActivity extends AppCompatActivity {

    Usuario usuario;
    Carrito carrito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        EditText T_Usuario=(EditText) findViewById(R.id.RegistroActivity_TextoUsuario);
        EditText T_password=(EditText) findViewById(R.id.RegistroActivity_TextoPassword);
        EditText T_correo=(EditText) findViewById(R.id.RegistroActivity_EditTextCorreo);
        Button botonRegistro=(Button) findViewById(R.id.RegistroActivity_botonRegistro);
        botonRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre=T_Usuario.toString();
                String password=T_password.toString();
                String correo=T_correo.toString();
                boolean r=new ControladorRegistro().run(nombre,correo,password);
                Intent i=new Intent(RegistrarActivity.this,MainActivity.class);
                i.putExtra("usuario",usuario);
                startActivity(i);

                finish();
            }
        });

    }
}