package com.mateomontero.pokepabellon.controlador;

import android.content.Context;
import android.database.Cursor;

import com.mateomontero.pokepabellon.modelo.Usuario;

import java.util.ArrayList;

public class ControladorLogin extends BaseDatos {

    public ControladorLogin(Context context){
        super(context);
    }

        public Usuario run( String correo, String password) {

            String sentenciaSql = "SELECT *" +
                    "" + " FROM usuarios"   ;

            Cursor c=null;
            try {
                c = db.rawQuery(sentenciaSql, null);
            }
            catch (Exception e){
                return null;
            }
            if (c != null && c.getCount() > 0) {
                c.moveToFirst();
                do {
                    int id = c.getInt(c.getColumnIndexOrThrow("_id"));
                    String nombre = c.getString(c.getColumnIndexOrThrow("nombre"));
                    String correo2 = c.getString(c.getColumnIndexOrThrow("correo"));
                    String password2 = c.getString(c.getColumnIndexOrThrow("password"));

                    if (correo2.equals(correo) && password2.equals(password)){
                        Usuario u=new Usuario(nombre,correo,password);
                        u.setId(id);
                        return u;
                    }
                       } while (c.moveToNext());
            }
            c.close();
            return null;
        }



}
