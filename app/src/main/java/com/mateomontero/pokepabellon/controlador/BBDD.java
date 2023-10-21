package com.mateomontero.pokepabellon.controlador;

import com.mateomontero.pokepabellon.modelo.Producto;
import com.mateomontero.pokepabellon.modelo.Usuario;

import java.util.ArrayList;

public class BBDD {

    ArrayList<Usuario> usuarios;
    ArrayList<Producto> productos;

    public BBDD() {
        usuarios = new ArrayList<Usuario>();
        cargarUsuarios();
        cargarProductos();

    }

    private void cargarUsuarios() {
        // TODO Auto-generated method stub
        usuarios.add(new Usuario("pepe@gmre.com", "pepe", "1234"));
        usuarios.add(new Usuario("jose@gmre.com", "jose", "2234"));
        usuarios.add(new Usuario("grillo@gmre.com", "grillo", "3234"));
        usuarios.add(new Usuario("serval@gmre.com", "serval", "4234"));
        usuarios.add(new Usuario("klee@gmre.com", "klee", "5234"));
        usuarios.add(new Usuario("sou@gmre.com", "sou", "6234"));
        usuarios.add(new Usuario("sam@gmre.com", "sam", "7234"));
        usuarios.add(new Usuario("kim@gmre.com", "kim", "8234"));
        usuarios.add(new Usuario("koko@gmre.com", "koko", "9234"));
        usuarios.add(new Usuario("karen@gmre.com", "karen", "1134"));
    }

    public void meterUsuarios(String nombre, String correo, String password) {
        // TODO Auto-generated method stub
        usuarios.add(new Usuario(correo, nombre, password));
    }


    public Usuario comprobarUsuarios(String correoC, String password) {
        for (Usuario u : usuarios) {
            if (u.getCorreo().equals(correoC)) {
                if (u.getPassward().equals(password)) {
                    return u;
                }
            }

        }


        return null;
    }

    public ArrayList<Producto> getProductos(){
        return productos;
    }
    private void cargarProductos() {
        // TODO Auto-generated method stub
        productos.add(new Producto("llavero",11.3,"llavero para cartera",1,11,20));
        productos.add(new Producto("peluche",11.5,"peluche",2,30,6));
        productos.add(new Producto("silla",11.3,"silla",3,33,30));
        productos.add(new Producto("alfombrilla",11.3,"alfombrilla para raton",4,13,10));
        productos.add(new Producto("usb",11.3,"usb",5,11,21));
        productos.add(new Producto("peluvhe torchic",11.3,"peluche torchic",6,11,22));

    }


}
