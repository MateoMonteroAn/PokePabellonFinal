package com.mateomontero.pokepabellon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.mateomontero.pokepabellon.controlador.BaseDatos;
import com.mateomontero.pokepabellon.controlador.BaseDatosProducto;
import com.mateomontero.pokepabellon.controlador.ControladorListaProductos;
import com.mateomontero.pokepabellon.modelo.Carrito;
import com.mateomontero.pokepabellon.modelo.Datos;
import com.mateomontero.pokepabellon.modelo.Pedido;
import com.mateomontero.pokepabellon.modelo.Producto;
import com.mateomontero.pokepabellon.modelo.Usuario;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    Datos datos;

    Usuario usuario;
    Carrito carrito;

    ArrayList<Producto> productos;
    BaseDatos baseDatos;
    Pedido pedido;

   // ArrayList<Usuario> users=new ControldorUsuarios().run();

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //recup
        try {
            Bundle b = getIntent().getExtras();
            datos=(Datos)b.getSerializable("capsula");
         }
        catch (Exception e){}

        if (datos==null) datos=new Datos();
        //findViewById
        ListView  listaProductos= (ListView) findViewById(R.id.MainActivity_ListView);;
        TextView texto_usuario=(TextView)findViewById(R.id.MaintextViewUsuario);
        Button b_busqueda=(Button) findViewById(R.id.MainActitity_botonBusqueda);
        Button b_usuario=(Button) findViewById(R.id.MainActivity_botonlogin);
        Button b_carrito=(Button) findViewById(R.id.MainActivity_botonCarrito);
        productos=new ArrayList<Producto>();


        if (datos.getUsuario()==null)
            texto_usuario.setText(R.string.invitado);
        else
            texto_usuario.setText(datos.getUsuario().getNombre());


        ArrayList<String> names=constuirListaProductos();




       ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
        listaProductos.setAdapter(adapter);

        listaProductos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(MainActivity.this,ProductoActivity.class);
                Producto p=productos.get(position);
                datos.setProducto(p);
                i.putExtra("capsula",datos);
                startActivity(i);
                finish();
            }
        });


        b_busqueda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

         b_usuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,UserActivity.class);
                i.putExtra("capsula",datos);
                startActivity(i);
                finish();
            }
        });

        b_carrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,CarritoActivity.class);
                i.putExtra("usuario",usuario);
                i.putExtra("carrito",carrito);
                i.putExtra("pedido", pedido);
                i.putExtra("capsula",datos);
               startActivity(i);
                finish();
            }
        });




        productos=    new BaseDatosProducto(this).getListaProducto();
        ListAdapter listAdapter = new ListAdapter(productos,MainActivity.this, new ListAdapter.OnItemClickListener() {


            @Override
            public void onItemClick(Producto producto) {
                Intent i=new Intent(MainActivity.this,ProductoActivity.class);

            }
        });
        RecyclerView recyclerView = findViewById(R.id.lista);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setAdapter(listAdapter);



    }




    //**********************************************************************************
    //TODO: esto hay que modificarlo en el futuro
    //**********************************************************************************
    private ArrayList<String> constuirListaProductos() {
       productos=    new BaseDatosProducto(this).getListaProducto();
        ArrayList<String> lista=new ArrayList<String>();

        String todo;
        for (Producto p:productos){
            todo=p.getNombre()+" - "+p.getDescripcion()+" - "+p.getPrecio()+"€ - "+p.getSize()+" cm";
            lista.add(todo);
        }


        return lista;
    }


}