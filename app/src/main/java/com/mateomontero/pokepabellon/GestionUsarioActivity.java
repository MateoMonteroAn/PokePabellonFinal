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
import com.mateomontero.pokepabellon.controlador.BaseDatosPedidoProducto;
import com.mateomontero.pokepabellon.controlador.BaseDatosUsuario;
import com.mateomontero.pokepabellon.modelo.Datos;
import com.mateomontero.pokepabellon.modelo.Usuario;

import java.util.ArrayList;

public class GestionUsarioActivity extends AppCompatActivity {
Datos datos;
ArrayList<String> usuarios;
    ArrayList<Usuario> usuariosS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_usario);

        //recup
        try {
            Bundle b = getIntent().getExtras();
            datos=(Datos)b.getSerializable("capsula");
        }
        catch (Exception e){}

        Button b_main=(Button) findViewById(R.id.GestionUActivitybotonP);
        ListView listaUsuarios=(ListView) findViewById(R.id.USerList);
        ArrayList<String> names=constuirListaUsuarios();



        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
        listaUsuarios.setAdapter(adapter);

        listaUsuarios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(GestionUsarioActivity.this,ADminUsuariosActivity.class);

                Usuario uu=usuariosS.get(position);
                int id_usuario=new BaseDatosUsuario(view.getContext()).getUsuarioId(uu.getCorreo());
                i.putExtra("capsula",datos);
                i.putExtra("id_usuario",id_usuario);
                startActivity(i);
                finish();
            }
        });
        b_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(GestionUsarioActivity.this,MainAdminActivity.class);
                i.putExtra("capsula",datos);
                startActivity(i);

                finish();
            }
        });
    }
    private ArrayList<String> constuirListaUsuarios() {
        usuariosS=    new BaseDatosUsuario(this).getListaUsuariosS();
        usuarios=    new BaseDatosUsuario(this).getListaUsuarios();
        ArrayList<String> lista=new ArrayList<String>();

        lista=usuarios;


        return lista;
    }
    private ArrayList<Usuario> constuirListaUsuariosS() {
        usuariosS=    new BaseDatosUsuario(this).getListaUsuariosS();
        ArrayList<Usuario> lista=new ArrayList<Usuario>();

        lista=usuariosS;


        return lista;
    }
}