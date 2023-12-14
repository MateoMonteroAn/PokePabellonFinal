package com.mateomontero.pokepabellon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mateomontero.pokepabellon.controlador.BaseDatosProducto;
import com.mateomontero.pokepabellon.modelo.Datos;
import com.mateomontero.pokepabellon.modelo.Producto;

public class AddPedidosActivity extends AppCompatActivity {

    Datos datos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pedidos);
        try {
            Bundle b = getIntent().getExtras();
            datos=(Datos)b.getSerializable("capsula");
        }
        catch (Exception e){}

        Button b_main=(Button) findViewById(R.id.GAddPRoductobotonMain);
        Button b_addP=(Button) findViewById(R.id.GAddPRoductobotonAdd);
        EditText nombre=(EditText) findViewById(R.id.GAddPRoductoEditTextNombre);
        EditText descripcion=(EditText) findViewById(R.id.GAddPRoductoextoDescripion);
        EditText precio=(EditText) findViewById(R.id.GAddPRoductoeditTextNumberPrecio);
        EditText size=(EditText) findViewById(R.id.GAddPRoductoeditTextNumberSize);
        EditText cantidad=(EditText) findViewById(R.id.GAddPRoductoeditTextNumberCantidad);
        b_addP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(AddPedidosActivity.this,GestionProductoActivity.class);
                Producto p=new Producto(nombre.getText().toString(),Integer.parseInt(String.valueOf(precio.getText())),descripcion.getText().toString(),0,Integer.parseInt(String.valueOf(size.getText())),Integer.parseInt(String.valueOf(cantidad.getText())));
                new BaseDatosProducto(v.getContext()).addProducto(p);
                i.putExtra("capsula",datos);
                startActivity(i);

                finish();
            }
        });



        b_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(AddPedidosActivity.this,MainActivity.class);
                i.putExtra("capsula",datos);
                startActivity(i);

                finish();
            }
        });
    }
}