package com.mateomontero.pokepabellon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.mateomontero.pokepabellon.controlador.BaseDatosPedido;
import com.mateomontero.pokepabellon.controlador.BaseDatosProducto;
import com.mateomontero.pokepabellon.controlador.BaseDatosProductoP;
import com.mateomontero.pokepabellon.modelo.Carrito;
import com.mateomontero.pokepabellon.modelo.Datos;
import com.mateomontero.pokepabellon.modelo.Direccion;
import com.mateomontero.pokepabellon.modelo.Pedido;
import com.mateomontero.pokepabellon.modelo.Usuario;
import com.mateomontero.pokepabellon.modelo.Producto;


import java.util.ArrayList;

public class CarritoActivity extends AppCompatActivity {
Usuario usuario;
Carrito carrito;
Producto producto;
ArrayList<String> names=new ArrayList<String>();
ArrayList<String> productos=new ArrayList<String>();

Datos datos;
int precioFinal;
Pedido pedido;
int cantidad;
int precioP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);
        usuario=null;
        carrito=null;

        try {
            Bundle b = getIntent().getExtras();

            datos=(Datos) b.getSerializable("capsula");
            producto=(Producto) b.getSerializable("producto");
            usuario = (Usuario) b.getSerializable("usuario");
            carrito = (Carrito) b.getSerializable("carrito");
            pedido =(Pedido)  b.getSerializable("pedido");
            precioP=(int) b.getDouble("precio");
        }
        catch (Exception e){

        }
        RecyclerView listaFinal=(RecyclerView) findViewById(R.id.listaFinal);
        ListView listaProductos= (ListView) findViewById(R.id.CarritoActivity_ListView);;
        Button b_main=(Button) findViewById(R.id.CarritoActivity_botonMain);
        Button b_compra=(Button) findViewById(R.id.CarritoActivityBotonCompra);

        Button b_busqueda=(Button) findViewById(R.id.CarritoActivity_botonBusqueda);
        EditText pais= (EditText) findViewById(R.id.CarritoActivityeditTextTextPais);
        EditText ciudad= (EditText) findViewById(R.id.CarritoActivityeditTextTextCiudad);
        EditText cp= (EditText) findViewById(R.id.CarritoActivityeditTextTextCP);
        EditText calle= (EditText) findViewById(R.id.CarritoActivityeditTextTextCalle);;
        EditText provincia= (EditText) findViewById(R.id.CarritoActivityeditTextTextProvincia);;
        TextView precio=(TextView) findViewById(R.id.CArritoActivityPrecio);




                 names=constuirListaProductos();
                 precioFinal=datos.getCarrito().getPrecio();
        precio.setText(precioFinal+" €");









        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
        listaProductos.setAdapter(adapter);






        b_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(CarritoActivity.this, MainActivity.class);
                i.putExtra("usuario",usuario);
                i.putExtra("carrito",carrito);
                i.putExtra("pedido", pedido);
                i.putExtra("capsula",datos);
                startActivity(i);

                finish();
            }
        });
        b_compra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(CarritoActivity.this, MainActivity.class);
                datos.getCarrito().resetCarrito();
                i.putExtra("usuario",usuario);
                i.putExtra("carrito",carrito);
                i.putExtra("precioFinal",precioFinal);
                i.putExtra("pedido", pedido);
                i.putExtra("capsula",datos);
                startActivity(i);
               Direccion direccion=new Direccion(ciudad.getText().toString(),cp.getText().toString(),pais.getText().toString(),provincia.getText().toString(),calle.getText().toString());
                Pedido pedido=new Pedido(direccion.getId(),"hoy",precioFinal);
                new BaseDatosPedido(v.getContext()).addPedido(pedido);

                finish();
            }
        });


        b_busqueda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(CarritoActivity.this,MainActivity.class);
                i.putExtra("usuario",usuario);
                i.putExtra("carrito",carrito);
                i.putExtra("pedido", pedido);
                i.putExtra("capsula",datos);
                startActivity(i);

                finish();
            }
        });


    }
    private ArrayList<String> constuirListaProductos() {

        ArrayList<String> lista=new ArrayList<String>();
        lista=datos.getCarrito().getDatos();



        return lista;
    }

}