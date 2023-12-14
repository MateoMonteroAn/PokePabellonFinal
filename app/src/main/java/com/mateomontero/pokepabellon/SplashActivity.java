package com.mateomontero.pokepabellon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.mateomontero.pokepabellon.controlador.BasDatossProductoP;
import com.mateomontero.pokepabellon.controlador.BaseDatosProducto;
import com.mateomontero.pokepabellon.modelo.Carrito;
import com.mateomontero.pokepabellon.modelo.Datos;
import com.mateomontero.pokepabellon.modelo.Producto;

public class SplashActivity extends AppCompatActivity {
Carrito carrito=new Carrito();
Datos datos=new Datos();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new BasDatossProductoP(this).deleteAllProductos();
        long time=1500;
        //retardo de tiempo
        datos.setCarrito(carrito);
        new Handler().postDelayed(()->{
                Intent i=new Intent(SplashActivity.this,MainActivity.class);
                i.putExtra("carrito",carrito);
                i.putExtra("capsula",datos);
                startActivity(i);
                finish();
        },time);



    }
}