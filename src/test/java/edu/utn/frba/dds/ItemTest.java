package edu.utn.frba.dds;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ItemTest {
    @Test
    public void itemCambiaDePrecio() throws ValorNegativoException {
        //Si el precio de un articulo cambia y la operacion no esta cerrada, el valor de la operacion tambien va a cambiar
        List<Item> Items = new ArrayList<Item>();
        Item unItem = new Item();
        unItem.setValor(300);

        Items.add(unItem);
        OperacionDeEgreso Operacion = new OperacionDeEgreso(Items);
        Assertions.assertEquals(300,Operacion.calcularValor(),0.1);

        unItem.setValor(1500);
        Assertions.assertEquals(1500,Operacion.calcularValor(),0.1);
    }

    @Test
    public void precioNegativo(){
        //El precio no puede ser negativo
        Item unItem = new Item();
        double valor = -450;

       ValorNegativoException unValor = Assertions.assertThrows(ValorNegativoException.class, ()->unItem.setValor(valor));

    }
}
