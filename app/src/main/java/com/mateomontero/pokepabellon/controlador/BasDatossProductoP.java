package com.mateomontero.pokepabellon.controlador;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.mateomontero.pokepabellon.modelo.Producto;

import java.util.ArrayList;

public class BasDatossProductoP extends BaseDatos{
    public BasDatossProductoP(Context context) {
        super(context);
    }

    public void deleteProducto(int id) {
        // Elimina la nota seleccionada
        db.delete("productosP", " _id = " + id, null);
    }

    public ArrayList<Producto> getListaProducto() {
        ArrayList<Producto> productos = new ArrayList<Producto>();
        String sentenciaSql = "SELECT *" +
                "" + " FROM productosP"   ;

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
                int precio = c.getInt(c.getColumnIndexOrThrow("precio"));
                String descripcion = c.getString(c.getColumnIndexOrThrow("descripcion"));
                double size = c.getDouble(c.getColumnIndexOrThrow("size"));
                int cantidad_en_stock = c.getInt(c.getColumnIndexOrThrow("cantidad_en_stock"));
                productos.add(new Producto(nombre,precio,descripcion,id,size,cantidad_en_stock));

            } while (c.moveToNext());
        }
        c.close();
        return productos;
    }

    //devuelve cantidad_en_stock producto pasando id
    public int getCantidadProducto(int id) {
        ArrayList<Producto> productos = new ArrayList<Producto>();
        String sentenciaSql = "SELECT *" +
                "" + " FROM productos WHERE _id="+id   ;

        Cursor c=null;
        try {
            c = db.rawQuery(sentenciaSql, null);
        }
        catch (Exception e){
            return 0;
        }
        c.moveToFirst();
        int cantidad_en_stock = c.getInt(c.getColumnIndexOrThrow("cantidad_en_stock"));
        c.close();
        return  cantidad_en_stock  ;


    }

    public void deleteAllProductos() {
        // Elimina la nota seleccionada
        db.delete("productosP", null, null);
    }


    public void addProducto(Producto producto, int cantidad, double precio) {
        ContentValues cv = new ContentValues();
        cv.put("nombre",producto.getNombre());
        cv.put("descripcion",producto.getDescripcion());
        cv.put("precio",precio*cantidad);
        cv.put("size",producto.getSize());
        cv.put("cantidad_en_stock",cantidad);

        db.insert("productosP", null, cv);


    }
}
