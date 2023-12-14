package com.mateomontero.pokepabellon.controlador;

import android.content.ContentValues;
import android.content.Context;

import com.mateomontero.pokepabellon.modelo.Usuario;

public class ControladorRegistro extends BaseDatos{


    public ControladorRegistro(Context context){
        super(context);
    }

    public boolean run(Usuario usuario) {
// Gets the data repository in write mode
        ContentValues cv=new ContentValues();
        cv.put("nombre",usuario.getNombre().toString());
        cv.put("correo",usuario.getCorreo().toString());
        cv.put("password",usuario.getPassward().toString());
        cv.put("tipo",usuario.isAdmin());
        db.insert("Usuarios",null, cv);

        return usuario.isAdmin();
    }

}
