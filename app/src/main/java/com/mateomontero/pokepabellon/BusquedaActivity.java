package com.mateomontero.pokepabellon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mateomontero.pokepabellon.modelo.Carrito;
import com.mateomontero.pokepabellon.modelo.Usuario;

public class BusquedaActivity extends AppCompatActivity {
    Usuario usuario;
    Carrito carrito;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda);

        usuario=null;
        carrito=null;
        try {
            Bundle b = getIntent().getExtras();

            usuario = (Usuario) b.getSerializable("usuario");
            carrito = (Carrito) b.getSerializable("carrito");
        }
        catch (Exception e){

        }
        Button b_login=(Button) findViewById(R.id.BusquedaActivity_botonlogin);
        b_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(BusquedaActivity.this,UserActivity.class);
                i.putExtra("usuario",usuario);
                i.putExtra("carrito",carrito);
                startActivity(i);

                finish();
            }

        });

        Button b_carrito=(Button) findViewById(R.id.BusquedaActivity_botonCarrito);
        b_carrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BusquedaActivity.this, UserActivity.class);
                i.putExtra("usuario", usuario);
                i.putExtra("carrito", carrito);
                startActivity(i);

                finish();
            }
        });
    }
}