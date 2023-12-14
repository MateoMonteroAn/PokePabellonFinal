package com.mateomontero.pokepabellon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mateomontero.pokepabellon.controlador.BaseDatosUsuario;
import com.mateomontero.pokepabellon.modelo.Datos;
import com.mateomontero.pokepabellon.modelo.Usuario;

public class UserActivity extends AppCompatActivity {
    private Datos datos;
    private String user_root="root";
    private String password_root="root";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);



        try {
            Bundle b = getIntent().getExtras();
            datos=(Datos)b.getSerializable("capsula");
        }
        catch (Exception e){}



        EditText T_password=(EditText) findViewById(R.id.UserActivity_TextoPassword);
        EditText T_correo=(EditText) findViewById(R.id.UserActivity_EditTextCorreo);
        Button botonLogin=(Button) findViewById(R.id.UserActivity_botonInicioSesion);
        Button botonRegistro=(Button) findViewById(R.id.UserActivity_botonRegistro);
        Button b_main=(Button) findViewById(R.id.UserActivity_botonMain);
        Button b_rp=(Button) findViewById(R.id.UserActivity_botonRecuperarPassword);

        EditText T_UsuarioR=(EditText) findViewById(R.id.UserActivity_TextoUsuarioR);
        EditText T_passwordR=(EditText) findViewById(R.id.UserActivity_TextoPasswordR);
        EditText T_passwordDosR=(EditText) findViewById(R.id.UserActivity_TextoPasswordDos2R);
        EditText T_correoR=(EditText) findViewById(R.id.UserActivity_TextoCorreoR);
        botonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //tomo datos
                String passworduno=T_password.getText().toString();
                String correouno=T_correo.getText().toString();

                Usuario u=null;
                boolean root=false;
                if (passworduno.equals(user_root)&&correouno.equals(password_root)) {
                    root=true;
                    u=new Usuario("root","root","root");
                    u.setAdmin(true);
                }
                else{

                        u = new BaseDatosUsuario(v.getContext()).login(correouno, passworduno);
                    if(u!=null) {
                        u.setAdmin(false);
                    }
                    root=false;


                }

               if (u!=null ){


                   datos.setUsuario(u);
                   if (u.isAdmin()){
                       Intent i=new Intent(UserActivity.this,MainAdminActivity.class);
                       i.putExtra("capsula",datos);
                       startActivity(i);

                       finish();
                   }
                   else{
                       Intent i=new Intent(UserActivity.this,MainActivity.class);

                       i.putExtra("capsula",datos);

                       startActivity(i);

                       finish();
                   }
               }

                else {
                       Toast.makeText(UserActivity.this,R.string.falloLogin,Toast.LENGTH_SHORT).show();
                    }

                }



        });


        b_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(UserActivity.this,MainActivity.class);

                i.putExtra("capsula",datos);

                startActivity(i);

                finish();
            }
        });

        botonRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usario=T_UsuarioR.getText().toString();
                String password= T_passwordR.getText().toString();
                String passwordDos= T_passwordDosR.getText().toString();
                String correo=T_correoR.getText().toString();
                if(password.equals(passwordDos)) {
                    Usuario u=new Usuario(usario,correo,password);
                    u.setAdmin(false);
                    boolean registrado = new BaseDatosUsuario(v.getContext()).Registrar(u);
                    Intent i = new Intent(UserActivity.this, MainActivity.class);
                    i.putExtra("capsula", datos);

                    startActivity(i);

                    finish();

                }

            }
        });


        b_rp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(UserActivity.this,MainActivity.class);

                i.putExtra("capsula",datos);

                startActivity(i);

                finish();
            }
        });


    }
}