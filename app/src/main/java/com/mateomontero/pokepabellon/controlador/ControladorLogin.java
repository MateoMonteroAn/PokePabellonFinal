package com.mateomontero.pokepabellon.controlador;

import com.mateomontero.pokepabellon.modelo.Usuario;

public class ControladorLogin {



        public Usuario run( String correo, String password) {

            Usuario usuario = new BBDD().comprobarUsuarios(correo,password);
            return usuario;
        }



}
