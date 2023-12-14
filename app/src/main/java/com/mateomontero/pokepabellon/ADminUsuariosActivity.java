package com.mateomontero.pokepabellon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.mateomontero.pokepabellon.controlador.BaseDatosUsuario;
import com.mateomontero.pokepabellon.modelo.Datos;

import java.util.ArrayList;

public class ADminUsuariosActivity extends AppCompatActivity {
Datos datos;
int id_usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_usuarios);

        try {
            Bundle b = getIntent().getExtras();
            datos=(Datos)b.getSerializable("capsula");
            id_usuario=(int) b.getInt("id_usuario");
        }
        catch (Exception e){}

        Button b_main=(Button) findViewById(R.id.AUserActivity_PaginaPrincipal);
        Button b_delete=(Button) findViewById(R.id.AUserActivityCambiarEstado);



        b_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new BaseDatosUsuario(v.getContext()).deleteUsuario(id_usuario);
                Intent i=new Intent(ADminUsuariosActivity.this,GestionUsarioActivity.class);

                i.putExtra("capsula",datos);
                startActivity(i);

                finish();
            }
        });

        b_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ADminUsuariosActivity.this,MainAdminActivity.class);
                i.putExtra("capsula",datos);
                startActivity(i);

                finish();
            }
        });
    }

    }
