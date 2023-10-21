package com.mateomontero.pokepabellon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mateomontero.pokepabellon.controlador.ControladorLogin;
import com.mateomontero.pokepabellon.modelo.Carrito;
import com.mateomontero.pokepabellon.modelo.Usuario;

public class UserActivity extends AppCompatActivity {
 Usuario usuario;
 Carrito carrito;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        EditText T_Usuario=(EditText) findViewById(R.id.UserActivity_TextoUsuario);
        EditText T_password=(EditText) findViewById(R.id.UserActivity_TextoPassword);
        EditText T_correo=(EditText) findViewById(R.id.UserActivity_EditTextCorreo);
        Button botonLogin=(Button) findViewById(R.id.UserActivity_botonInicioSesion);
        botonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String password=T_password.toString();
                String correo=T_correo.toString();
                Usuario u=new ControladorLogin().run(correo,password);
                Intent i=new Intent(UserActivity.this,MainActivity.class);
                i.putExtra("usuario",usuario);
                startActivity(i);

                finish();
            }
        });

        Button b_main=(Button) findViewById(R.id.UserActivity_botonMain);
        b_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(UserActivity.this,MainActivity.class);

                i.putExtra("usuario",usuario);
                i.putExtra("carrito",carrito);
                startActivity(i);

                finish();
            }
        });

        Button b_rp=(Button) findViewById(R.id.UserActivity_botonRecuperarPassword);
        b_rp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(UserActivity.this,Recuperar_passwordActivity.class);

                i.putExtra("usuario",usuario);
                i.putExtra("carrito",carrito);
                startActivity(i);

                finish();
            }
        });


    }
}