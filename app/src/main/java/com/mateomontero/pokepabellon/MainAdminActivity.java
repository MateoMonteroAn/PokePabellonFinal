package com.mateomontero.pokepabellon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mateomontero.pokepabellon.controlador.BaseDatos;
import com.mateomontero.pokepabellon.controlador.BseeDatosReinicio;
import com.mateomontero.pokepabellon.modelo.Carrito;
import com.mateomontero.pokepabellon.modelo.Datos;


public class MainAdminActivity extends AppCompatActivity {
    private Datos datos;
    Carrito carrito;
    private BaseDatos baseDatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);

        //recup
        try {
            Bundle b = getIntent().getExtras();
            datos=(Datos)b.getSerializable("capsula");
        }
        catch (Exception e){}

        Button b_main=(Button) findViewById(R.id.AdminActivityPrincipal);
        Button reset=(Button) findViewById(R.id.AdminActivityResetBBDD);
        Button pedidos=(Button) findViewById(R.id.AdminActivityGestionPedido);
        Button b_usuarios=(Button) findViewById(R.id.AdminActivityGestionUsuario);
        Button b_productos=(Button) findViewById(R.id.adminActivityGestionProductos);


        pedidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainAdminActivity.this,GestionPedidosActivity.class);
                i.putExtra("capsula",datos);
                startActivity(i);

                finish();
            }
        });
        b_usuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainAdminActivity.this,GestionUsarioActivity.class);
                i.putExtra("capsula",datos);
                startActivity(i);

                finish();
            }
        });
        b_productos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainAdminActivity.this,GestionProductoActivity.class);
                i.putExtra("capsula",datos);
                startActivity(i);

                finish();
            }
        });



        b_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainAdminActivity.this,MainActivity.class);
                i.putExtra("capsula",datos);
                startActivity(i);

                finish();
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new BseeDatosReinicio().run(v.getContext());
                datos.getCarrito().resetCarrito();


            }
        });
    }
}