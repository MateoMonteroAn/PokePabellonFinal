package com.mateomontero.pokepabellon.controlador;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.mateomontero.pokepabellon.modelo.Direccion;
import com.mateomontero.pokepabellon.modelo.Pedido;
import com.mateomontero.pokepabellon.modelo.Producto;

import java.util.ArrayList;

public class BaseDatosPedido extends BaseDatos{
    public BaseDatosPedido(Context context) {
        super(context);
    }

    public void addPedido(Pedido pedido) {
        ContentValues cv = new ContentValues();
        cv.put("id_direccion",pedido.getId_direccion());
        cv.put("fecha",pedido.getFecha());
        cv.put("precio",pedido.getPrecio());
        cv.put("estado","generado");


        db.insert("pedidos", null, cv);


    }
    public void modificarPedido(int id, String estado) {
        ContentValues cv = new ContentValues();


        cv.put("estado",estado);



        db.update("pedidos", cv,  " _id = " + id, null);


    }
    public ArrayList<String> getListaPedido() {
        ArrayList<String> pedidos = new ArrayList<String>();
        String sentenciaSql = "SELECT *" +
                "" + " FROM pedidos"   ;

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
                String fecha = c.getString(c.getColumnIndexOrThrow("fecha"));
                int precio = c.getInt(c.getColumnIndexOrThrow("precio"));
                String estado=c.getString(c.getColumnIndexOrThrow("estado"));

                pedidos.add(id+" - "+fecha+" - "+precio+"€ - "+estado);

            } while (c.moveToNext());
        }
        c.close();
        return pedidos;
    }

}
