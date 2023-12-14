package com.mateomontero.pokepabellon.controlador;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.mateomontero.pokepabellon.modelo.Usuario;

import java.util.ArrayList;

public class BaseDatosUsuario  extends BaseDatos{


    public BaseDatosUsuario(Context context) {
        super(context);
    }
    //añadir usuario
    public void actualizarUsuario(Usuario usuario){
        ContentValues cv=new ContentValues();
        cv.put("nombre",usuario.getNombre());
        cv.put("correo",usuario.getCorreo());
        cv.put("password",usuario.getPassward());
        cv.put("tipo",usuario.isAdmin());
        db.update("Usuarios", cv,  " _id = " + usuario.getId(), null);

    }
    public int getUsuarioId(String correo){
        String sentenciaSql = "SELECT *" +
                "" + " FROM usuarios WHERE correo = "+"'"+correo+"'";
        int id_user=0;

        Cursor c=null;
        try {
            c = db.rawQuery(sentenciaSql, null);
        }
        catch (Exception e){
            return 0;
        }
        if (c != null && c.getCount() > 0) {
            c.moveToFirst();

            id_user = c.getInt(c.getColumnIndexOrThrow("_id"));




        }
        c.close();
        return id_user;

    }

    //eliminar usuario dando el id
    public void deleteUsuario(int id) {
        // Elimina la nota seleccionada
        db.delete("usuarios", " _id = " + id, null);
    }



    public void deleteAllUsuarios() {
        // Elimina la nota seleccionada
        db.delete("usuarios",null, null);
    }


    public void addUsuario(Usuario usuario) {
        ContentValues cv=new ContentValues();
        cv.put("nombre",usuario.getNombre());
        cv.put("correo",usuario.getCorreo());
        cv.put("password",usuario.getPassward());
        cv.put("tipo",usuario.isAdmin());
        db.insert("Usuarios", null,cv);


    }

    public Usuario login( String correo, String password) {

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
    public boolean Registrar(Usuario usuario) {
// Gets the data repository in write mode
        ContentValues cv=new ContentValues();
        cv.put("nombre",usuario.getNombre().toString());
        cv.put("correo",usuario.getCorreo().toString());
        cv.put("password",usuario.getPassward().toString());
        cv.put("tipo",usuario.isAdmin());
        db.insert("Usuarios",null, cv);

        return usuario.isAdmin();
    }
    public ArrayList<String> getListaUsuarios() {
        ArrayList<String> usuarios = new ArrayList<String>();
        String sentenciaSql = "SELECT *" +
                "" + " FROM usuarios";

        Cursor c = null;
        try {
            c = db.rawQuery(sentenciaSql, null);
        } catch (Exception e) {
            return null;
        }
        if (c != null && c.getCount() > 0) {
            c.moveToFirst();
            do {

                String nombre = c.getString(c.getColumnIndexOrThrow("nombre"));
                int id_usuario=c.getInt(c.getColumnIndexOrThrow("_id"));
                usuarios.add(id_usuario+"- "+nombre);

            } while (c.moveToNext());
        }
        c.close();
        return usuarios;
    }
    public ArrayList<Usuario> getListaUsuariosS() {
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        String sentenciaSql = "SELECT *" +
                "" + " FROM usuarios";

        Cursor c = null;
        try {
            c = db.rawQuery(sentenciaSql, null);
        } catch (Exception e) {
            return null;
        }
        if (c != null && c.getCount() > 0) {
            c.moveToFirst();
            do {

                String nombre = c.getString(c.getColumnIndexOrThrow("nombre"));
                String correo = c.getString(c.getColumnIndexOrThrow("correo"));
                String password = c.getString(c.getColumnIndexOrThrow("password"));
                int id_usuario=c.getInt(c.getColumnIndexOrThrow("_id"));
                Usuario u=new Usuario(nombre,correo,password);
                usuarios.add(u);

            } while (c.moveToNext());
        }
        c.close();
        return usuarios;
    }

}
