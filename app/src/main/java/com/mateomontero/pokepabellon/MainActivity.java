package com.mateomontero.pokepabellon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.mateomontero.pokepabellon.modelo.Carrito;
import com.mateomontero.pokepabellon.modelo.Usuario;

public class MainActivity extends AppCompatActivity {

    Usuario usuario;
    Carrito carrito;
    ListView  listaProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        usuario=null;
        carrito=null;
        try {
            Bundle b = getIntent().getExtras();

            usuario = (Usuario) b.getSerializable("usuario");
            carrito = (Carrito) b.getSerializable("carrito");
        }
        catch (Exception e){

        }
        Button b_busqueda=(Button) findViewById(R.id.MainActitity_botonBusqueda);
        b_busqueda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,BusquedaActivity.class);

                i.putExtra("usuario",usuario);
                i.putExtra("carrito",carrito);
                startActivity(i);

                finish();
            }
        });

        Button b_usuario=(Button) findViewById(R.id.MainActivity_botonlogin);
        b_usuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,UserActivity.class);
                i.putExtra("usuario",usuario);
                i.putExtra("carrito",carrito);
                startActivity(i);

                finish();
            }
        });
        Button b_carrito=(Button) findViewById(R.id.MainActivity_botonCarrito);
        b_carrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,CarritoActivity.class);
                i.putExtra("usuario",usuario);
                i.putExtra("carrito",carrito);


                startActivity(i);

                finish();
            }
        });
        Button b_registro=(Button) findViewById(R.id.MainActivity_botonRegistro);
        b_registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,RegistrarActivity.class);
                i.putExtra("usuario",usuario);
                i.putExtra("carrito",carrito);


                startActivity(i);

                finish();
            }
        });
    }




    }