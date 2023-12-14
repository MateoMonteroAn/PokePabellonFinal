package com.mateomontero.pokepabellon.modelo;

import java.io.Serializable;

public class Usuario implements Serializable {

    int id;
    String nombre,correo,passward;
    boolean tipo;
    public final boolean ADMIN=false;
    public final boolean USER=true;

    public Usuario(String nombre, String correo, String passward) {
        super();
        this.nombre = nombre;
        this.correo = correo;
        this.passward = passward;
        this.tipo=USER;
        this.id=-1;
    }


    public void setId(int id){this.id=id;}
    public int getId(){return id;}
    public boolean isAdmin(){return tipo;}

    @Override
    public String toString() {
        return "Usuario [nombre=" + nombre + ", correo=" + correo + "]";
    }

    public String getPassward() {
        return passward;
    }
    public void setPassward(String passward) {
        this.passward = passward;
    }public Usuario() {
        super();

    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setAdmin(boolean b) {
        this.tipo=b;
    }

    public boolean getAdim() {
        return tipo;
    }
}
