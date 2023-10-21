package com.mateomontero.pokepabellon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mateomontero.pokepabellon.controlador.ControladorRecuperarPassword;
import com.mateomontero.pokepabellon.modelo.Carrito;
import com.mateomontero.pokepabellon.modelo.Usuario;

public class Recuperar_passwordActivity extends AppCompatActivity {
    Usuario usuario;
    Carrito carrito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_password);

        Button b_main = (Button) findViewById(R.id.RecuperarActivity_botonMain);
        b_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password="";
                String a=new ControladorRecuperarPassword().run(password);

                Intent i = new Intent(Recuperar_passwordActivity.this, MainActivity.class);
                startActivity(i);
                i.putExtra("usuario", usuario);
                i.putExtra("carrito", carrito);
                finish();
            }
        });
    }
}