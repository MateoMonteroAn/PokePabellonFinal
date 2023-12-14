package com.mateomontero.pokepabellon.controlador;

import android.content.Context;

import com.mateomontero.pokepabellon.modelo.Producto;
import com.mateomontero.pokepabellon.modelo.Usuario;

public class BseeDatosReinicio {
    
    
    public void run(Context context) {
        new BaseDatosUsuario(context).deleteAllUsuarios();
        new BaseDatosProducto(context).deleteAllProductos();
        addProductos(context);
        añadirUsuarios(context);

    }
    
    
    private void añadirUsuarios(Context context){
         new BaseDatosUsuario(context).addUsuario(new Usuario("pepe", "pepe@gmre.com", "1234"));
         new BaseDatosUsuario(context).addUsuario(new Usuario("jose@gmre.com", "jose", "2234"));
         new BaseDatosUsuario(context).addUsuario(new Usuario("grillo@gmre.com", "grillo", "3234"));
         new BaseDatosUsuario(context).addUsuario(new Usuario("serval@gmre.com", "serval", "4234"));
         new BaseDatosUsuario(context).addUsuario(new Usuario("klee@gmre.com", "klee", "5234"));
         new BaseDatosUsuario(context).addUsuario(new Usuario("sou@gmre.com", "sou", "6234"));
         new BaseDatosUsuario(context).addUsuario(new Usuario("sam@gmre.com", "sam", "7234"));
         new BaseDatosUsuario(context).addUsuario(new Usuario("kim@gmre.com", "kim", "8234"));
         new BaseDatosUsuario(context).addUsuario(new Usuario("koko@gmre.com", "koko", "9234"));
         new BaseDatosUsuario(context).addUsuario(new Usuario("karen@gmre.com", "karen", "1134"));


    }
    private void addProductos(Context context){
        new BaseDatosProducto(context).addProducto(new Producto("llavero",11,"llavero para cartera",1,11,20));
        new BaseDatosProducto(context).addProducto(new Producto("peluche",11,"peluche",2,30,1));
        new BaseDatosProducto(context).addProducto(new Producto("silla",11,"silla",3,33,30));
        new BaseDatosProducto(context).addProducto(new Producto("alfombrilla",11,"alfombrilla para raton",4,13,10));
        new BaseDatosProducto(context).addProducto(new Producto("usb",10,"usb",5,11,21));
        new BaseDatosProducto(context).addProducto(new Producto("peluche torchic",12,"peluche torchic",6,11,22));
    }
    
    
}
