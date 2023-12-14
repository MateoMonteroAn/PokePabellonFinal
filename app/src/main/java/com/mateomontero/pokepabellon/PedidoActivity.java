package com.mateomontero.pokepabellon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mateomontero.pokepabellon.controlador.BaseDatosPedido;
import com.mateomontero.pokepabellon.modelo.Datos;

public class PedidoActivity extends AppCompatActivity {
Datos datos;
int id_pedido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);

        try {
            Bundle b = getIntent().getExtras();
            datos=(Datos)b.getSerializable("capsula");
            id_pedido=(int) b.getInt("id_pedido");
        }
        catch (Exception e){}

        Button b_main=(Button) findViewById(R.id.pedidoActivity_PaginaPrincipal);
        Button b_estado=(Button) findViewById(R.id.pedidoActivityCambiarEstado);
        EditText estado=(EditText) findViewById(R.id.EstadoActivity_editTextEstado);

        b_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(PedidoActivity.this,MainAdminActivity.class);
                i.putExtra("capsula",datos);
                startActivity(i);

                finish();
            }
        });
        b_estado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cambio=estado.getText().toString();
                new BaseDatosPedido(v.getContext()).modificarPedido(id_pedido,cambio);
                Intent i=new Intent(PedidoActivity.this,GestionPedidosActivity.class);
                i.putExtra("capsula",datos);
                startActivity(i);

                finish();
            }
        });




    }
}