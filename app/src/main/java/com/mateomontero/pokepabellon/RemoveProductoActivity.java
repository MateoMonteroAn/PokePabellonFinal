package com.mateomontero.pokepabellon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mateomontero.pokepabellon.controlador.BaseDatosProducto;
import com.mateomontero.pokepabellon.modelo.Datos;

public class RemoveProductoActivity extends AppCompatActivity {
Datos datos;
    int id_producto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_producto);


        try {
            Bundle b = getIntent().getExtras();
            datos=(Datos)b.getSerializable("capsula");
            id_producto=(int) b.getInt("id_producto");
        }
        catch (Exception e){}

        Button e=(Button) findViewById(R.id.RemoveButton);


       e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(RemoveProductoActivity.this,GestionProductoActivity.class);
                new BaseDatosProducto(v.getContext()).deleteProducto(id_producto);
                i.putExtra("capsula",datos);
                startActivity(i);

                finish();
            }
        });

    }

}