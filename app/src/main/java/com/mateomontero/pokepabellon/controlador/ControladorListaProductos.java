package com.mateomontero.pokepabellon.controlador;

import com.mateomontero.pokepabellon.modelo.Producto;

import java.util.ArrayList;

public class ControladorListaProductos {

    public ArrayList<Producto> run() {
        return new BBDD().getProductos();

    }
}
