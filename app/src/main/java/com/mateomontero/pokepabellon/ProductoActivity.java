package com.mateomontero.pokepabellon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.mateomontero.pokepabellon.controlador.BasDatossProductoP;
import com.mateomontero.pokepabellon.controlador.BaseDatosProducto;
import com.mateomontero.pokepabellon.modelo.Carrito;
import com.mateomontero.pokepabellon.modelo.Datos;
import com.mateomontero.pokepabellon.modelo.Pedido;
import com.mateomontero.pokepabellon.modelo.Producto;
import com.mateomontero.pokepabellon.modelo.Usuario;

import java.util.ArrayList;

public class ProductoActivity extends AppCompatActivity {
    Usuario usuario;
    Carrito carrito;
    double precio;

    Producto producto;
    Pedido pedido;
    Datos datos;
    ArrayList<String> carritoExistente=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);

        try {
            Bundle b = getIntent().getExtras();
            datos=(Datos)b.getSerializable("capsula");
            producto=(Producto)b.getSerializable("producto");
            //nombre = (String) b.getSerializable("nombre");
            usuario = (Usuario) b.getSerializable("usuario");
            carrito = (Carrito) b.getSerializable("carrito");
            pedido=(Pedido) b.getSerializable("pedido");
        }
        catch (Exception e){

        }
        ListView listaCaracteristicas= (ListView) findViewById(R.id.ProductoActivity_ListView);;
        TextView nombre=(TextView) findViewById(R.id.productoActivity_nameLogin);
        TextView Tnombre=(TextView) findViewById(R.id.ProductoActivity_NombreProducto);
        Button botonMain=(Button) findViewById(R.id.ProductoActivity_PaginaPrincipal);
        Button botonMas=(Button) findViewById(R.id.ProductoActivity_mas);
        Button botonMenos=(Button) findViewById(R.id.ProductoActivity_menos);
        Button botonCarrito=(Button) findViewById(R.id.ProductoActivity_Carrito);
        EditText Numero=(EditText) findViewById(R.id.ProductoActivity_editTextNumber);

        if (usuario!=null){
            nombre.setText(usuario.getNombre());
        }
        else {
            nombre.setText(R.string.invitado);
        }


        ArrayList<String> names=constuirListaCaracteristicas();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
        listaCaracteristicas.setAdapter(adapter);

        botonMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              try {
                  int cantidad = Integer.parseInt(String.valueOf(Numero.getText()));
                  cantidad++;
                  Numero.setText(""+cantidad);
              }
              catch (Exception e){

              }

            }
        });


        botonMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int cantidad = Integer.parseInt(String.valueOf(Numero.getText()));
                    if (cantidad>0) {
                        cantidad--;
                        Numero.setText("" + cantidad);
                    }
                }
                catch (Exception e){

                }
            }
        });



        botonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ProductoActivity.this,MainActivity.class);
                i.putExtra("usuario",usuario);
                i.putExtra("carrito",carrito);
                i.putExtra("pedido", pedido);
                i.putExtra("capsula",datos);
                startActivity(i);
                finish();
            }
        });




        Tnombre.setText(datos.getProducto().getNombre());

    botonCarrito.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i=new Intent(ProductoActivity.this,CarritoActivity.class);
            int cantidad=Integer.parseInt(String.valueOf(Numero.getText()));
            int tope=new BaseDatosProducto(v.getContext()).getCantidadProducto(datos.getProducto().getId());
            boolean existe=false;
            carritoExistente=datos.getCarrito().getNombre();
            int ii=0;
            for (String existente:carritoExistente){
                existente=carritoExistente.get(ii);
                if(existente.equals(datos.getProducto().getNombre())){

                    existe=true;
                }
                ii++;
            }

            if(existe==false) {
                if (cantidad > 0 && cantidad <= tope) {
                    datos.getCarrito().addProducto(datos.getProducto(), cantidad, datos.getProducto().getPrecio());
                    precio=(datos.getProducto().getPrecio())*cantidad;
                    i.putExtra("capsula", datos);
                    i.putExtra("cantidad", cantidad);
                    i.putExtra("producto", producto);
                    i.putExtra("usuario", usuario);
                    i.putExtra("carrito", carrito);
                    i.putExtra("pedido", pedido);
                    i.putExtra("precio",precio);
                    /*new BasDatossProductoP(v.getContext()).addProducto(datos.getProducto(),cantidad,datos.getProducto().getPrecio());
                     */
                    startActivity(i);
                    finish();
                } else {
                    Toast.makeText(ProductoActivity.this, "el numero debe ser mayor a cero o inferior o igual a " + tope, Toast.LENGTH_SHORT).show();

                }
            }else{
                datos.getCarrito().modificarProducto(datos.getProducto(),cantidad);
                precio=(datos.getProducto().getPrecio())*cantidad;
                i.putExtra("capsula", datos);

                i.putExtra("producto", producto);
                i.putExtra("usuario", usuario);
                i.putExtra("carrito", carrito);
                i.putExtra("pedido", pedido);

                /*new BasDatossProductoP(v.getContext()).addProducto(datos.getProducto(),cantidad,datos.getProducto().getPrecio());
                 */
                Toast.makeText(ProductoActivity.this, "se ha modificado un producto existente " , Toast.LENGTH_SHORT).show();

                startActivity(i);
                finish();
            }
        }
    });


    }
    private ArrayList<String> constuirListaCaracteristicas() {

        ArrayList<String> lista=new ArrayList<String>();
        lista.add(datos.getProducto().getNombre());
        lista.add(datos.getProducto().getDescripcion());
        lista.add(String.valueOf(datos.getProducto().getPrecio())+" €");
        lista.add(String.valueOf(datos.getProducto().getSize())+" cm");
        lista.add(String.valueOf(datos.getProducto().getCantidad_en_stock())+" unidades en reserva");






        return lista;
    }
}