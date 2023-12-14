package com.mateomontero.pokepabellon.controlador;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mateomontero.pokepabellon.modelo.Producto;
import com.mateomontero.pokepabellon.modelo.Usuario;

public class BaseDatos extends SQLiteOpenHelper {
        // If you change the database schema, you must increment the database version.
        public static final int DATABASE_VERSION = 4;
        public static final String DATABASE_NAME = "tienda.db";
        protected SQLiteDatabase db;

    Producto p=new Producto("llavero",11,"llavero para cartera",1,11,20);

    private static final String SQL_CREATE_ENTRIES ="CREATE TABLE usuarios" +
            " (_id integer  primary key autoincrement," +
            "nombre text not null, correo text not null,password text not null,tipo boolean not null);"  ;

    private static final String SQL_CREATE_PRODUCTS ="CREATE TABLE productos (_id integer  primary key autoincrement," +
                    "nombre text not null, precio double not null,descripcion text not null, size double not null, cantidad_en_stock integer not null)" +
                    ";";
    private static final String SQL_CREATE_DIR ="CREATE TABLE direccion (_id integer  primary key autoincrement," +
            "ciudad text not null, cp text not null,pais text not null, provincia text not null," +
            "calle text not null)" +
            ";";

    private static final String SQL_CREATE_PEDIDO ="CREATE TABLE pedidos (_id integer  primary key autoincrement," +
            "id_direccion int not null, fecha text not null, precio int not null, estado text not null)"+
            ";";
  /*  private static final String SQL_CREATE_PEDIDO_PRODUCTO ="CREATE TABLE producto_pedido (_id_pedido integer  primary key not null," +
            "id_producto int not null, fecha DATE)"+
            ";";*/

    private static final String SQL_CREATE_PRODUCTS_PEDIDO ="CREATE TABLE productosP (_id integer  primary key autoincrement," +
            "nombre text not null, precio double not null,descripcion text not null, size double not null, cantidad_en_stock integer not null)" +
            ";";

    private static final String SQL_DELETE_ENTRIES = "";



    public BaseDatos(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            db=this.getWritableDatabase();
        }



    public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE_ENTRIES);
            db.execSQL(SQL_CREATE_PRODUCTS);
            db.execSQL(SQL_CREATE_DIR);
            db.execSQL(SQL_CREATE_PEDIDO);
           /* db.execSQL(SQL_CREATE_PEDIDO_PRODUCTO);*/
            db.execSQL(SQL_CREATE_PRODUCTS_PEDIDO);

        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // This database is only a cache for online data, so its upgrade policy is
            // to simply to discard the data and start over
            db.execSQL("DROP TABLE IF EXISTS usuarios" );
            db.execSQL("DROP TABLE IF EXISTS productos");
            db.execSQL("DROP TABLE IF EXISTS pedidos");
            db.execSQL("DROP TABLE IF EXISTS direccion");
            db.execSQL("DROP TABLE IF EXISTS producto_pedido");
            db.execSQL("DROP TABLE IF EXISTS productosP");
            onCreate(db);
    }

          public void close(){
        db.close();
    }
         public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                onUpgrade(db, oldVersion, newVersion);
         }

    public void addPedidoInicio(Producto producto) {
        ContentValues cv = new ContentValues();
        cv.put("nombre",producto.getNombre());
        cv.put("descripcion",producto.getDescripcion());
        cv.put("precio",producto.getPrecio());
        cv.put("size",producto.getSize());
        cv.put("cantidad_en_stock",producto.getCantidad_en_stock());

        db.insert("productos", null, cv);


    }
}
