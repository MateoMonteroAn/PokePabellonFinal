package com.mateomontero.pokepabellon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.mateomontero.pokepabellon.controlador.BaseDatosPedido;
import com.mateomontero.pokepabellon.controlador.BaseDatosProducto;
import com.mateomontero.pokepabellon.modelo.Datos;
import com.mateomontero.pokepabellon.modelo.Pedido;
import com.mateomontero.pokepabellon.modelo.Producto;

import java.util.ArrayList;

public class GestionPedidosActivity extends AppCompatActivity {
    Datos datos;
    ArrayList<String> pedidos=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_pedidos);

        try {
            Bundle b = getIntent().getExtras();
            datos=(Datos)b.getSerializable("capsula");
        }
        catch (Exception e){}


        ListView listaPedidos= (ListView) findViewById(R.id.PedidoActivity_ListView);;
        Button b_main=(Button) findViewById(R.id.PedidoActivityPrincipal);

        ArrayList<String> names=constuirListaPedidos();


        b_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(GestionPedidosActivity.this, MainActivity.class);

                i.putExtra("capsula",datos);
                startActivity(i);

                finish();
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
        listaPedidos.setAdapter(adapter);

        listaPedidos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(GestionPedidosActivity.this,PedidoActivity.class);
                String p=pedidos.get(position);
                int id_pedido=position+1;
                i.putExtra("capsula",datos);
                i.putExtra("id_pedido",id_pedido);
                startActivity(i);
                finish();
            }
        });



    }
    private ArrayList<String> constuirListaPedidos() {
        pedidos=    new BaseDatosPedido(this).getListaPedido();
        ArrayList<String> lista=new ArrayList<String>();

        lista=pedidos;


        return lista;
    }
}