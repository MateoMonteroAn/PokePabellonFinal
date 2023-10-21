package com.mateomontero.pokepabellon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mateomontero.pokepabellon.modelo.Carrito;
import com.mateomontero.pokepabellon.modelo.Usuario;

public class CarritoActivity extends AppCompatActivity {
Usuario usuario;
Carrito carrito;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);
        usuario=null;
        carrito=null;
        try {
            Bundle b = getIntent().getExtras();

            usuario = (Usuario) b.getSerializable("usuario");
            carrito = (Carrito) b.getSerializable("carrito");
        }
        catch (Exception e){

        }



        Button b_main=(Button) findViewById(R.id.CarritoActivity_botonMain);
        b_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(CarritoActivity.this,MainActivity.class);
                i.putExtra("usuario",usuario);
                i.putExtra("carrito",carrito);
                startActivity(i);

                finish();
            }
        });


        Button b_busqueda=(Button) findViewById(R.id.CarritoActivity_botonBusqueda);
        b_busqueda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(CarritoActivity.this,BusquedaActivity.class);
                i.putExtra("usuario",usuario);
                i.putExtra("carrito",carrito);
                startActivity(i);

                finish();
            }
        });
    }
}