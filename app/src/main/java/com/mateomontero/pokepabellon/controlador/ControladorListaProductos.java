package com.mateomontero.pokepabellon.controlador;

import android.content.Context;

import com.mateomontero.pokepabellon.modelo.Producto;

import java.util.ArrayList;

public class ControladorListaProductos {

    public ArrayList<Producto> run(Context context) {
        return new BaseDatosProducto(context).getListaProducto();

    }



}
