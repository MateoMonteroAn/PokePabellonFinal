package com.mateomontero.pokepabellon.controlador;

import android.content.ContentValues;
import android.content.Context;

import com.mateomontero.pokepabellon.modelo.Direccion;
import com.mateomontero.pokepabellon.modelo.Producto;

public class BaseDatosDir extends BaseDatos{
    public BaseDatosDir(Context context) {
        super(context);
    }

    public void addDir(Direccion direccion) {
        ContentValues cv = new ContentValues();
        cv.put("ciudad",direccion.getCiudad());
        cv.put("calle",direccion.getCalle());
        cv.put("cp",direccion.getCp());
        cv.put("provincia",direccion.getProvincia());
        cv.put("pais",direccion.getPais());


        db.insert("direccion", null, cv);


    }
}
