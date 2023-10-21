package com.mateomontero.pokepabellon.modelo;

import java.io.Serializable;

public class Usuario implements Serializable {

    String nombre,correo,passward;

    public Usuario(String nombre, String correo, String passward) {
        super();
        this.nombre = nombre;
        this.correo = correo;
        this.passward = passward;
    }
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
}
