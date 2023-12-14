package com.mateomontero.pokepabellon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.mateomontero.pokepabellon.controlador.BaseDatosProducto;
import com.mateomontero.pokepabellon.controlador.BaseDatosUsuario;
import com.mateomontero.pokepabellon.modelo.Datos;
import com.mateomontero.pokepabellon.modelo.Producto;

import java.util.ArrayList;

public class GestionProductoActivity extends AppCompatActivity {
Datos datos;

ArrayList<Producto> productos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_producto);

        //recup
        try {
            Bundle b = getIntent().getExtras();
            datos=(Datos)b.getSerializable("capsula");
        }
        catch (Exception e){}

        Button b_main=(Button) findViewById(R.id.GestionActivityProdbotonMain);
        Button b_Add=(Button) findViewById(R.id.GProductoActivityAddPedido);
        ListView listaProductos=(ListView) findViewById(R.id.ProductList);
        b_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(GestionProductoActivity.this,MainAdminActivity.class);
                i.putExtra("capsula",datos);
                startActivity(i);

                finish();
            }
        });

        b_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(GestionProductoActivity.this,AddPedidosActivity.class);
                i.putExtra("capsula",datos);
                startActivity(i);

                finish();
            }
        });



        ArrayList<String> names=constuirListaProductos();




        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
        listaProductos.setAdapter(adapter);

        listaProductos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(GestionProductoActivity.this,RemoveProductoActivity.class);
                Producto p=productos.get(position);
                datos.setProducto(p);
                int id_producto=new BaseDatosProducto(view.getContext()).getProductoId(productos.get(position).getNombre());
                i.putExtra("id_producto",id_producto);
                i.putExtra("capsula",datos);
                startActivity(i);
                finish();
            }
        });


    }
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