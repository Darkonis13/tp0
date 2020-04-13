package edu.utn.frba.dds;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

public class OperacionDeEgresoTest {
    @Test
    public void testDeValor(){

        //Calcula el valor de los items que la operacion contiene

        //Precondicion
        double valor;

        Item unItem = new Item();
        Item otroItem = new Item();

        unItem.setValor(1500);
        otroItem.setValor(4000);

        List<Item> Items;
        Items.add(unItem);
        Items.add(otroItem);

        OperacionDeEgreso Operacion = new OperacionDeEgreso(Items);

        //Operacion
        valor = Operacion.calcularValor();

        //Resultado
        Assertions.assertEquals(5500,valor,0.1);
    }

    @Test
    public void testSinItems(){
        //Si la lista de items esta vacia, el valor calculado debe ser 0

        //Precondicion
        OperacionDeEgreso Operacion = new OperacionDeEgreso();
        double valor;

        //Operacion
        valor = Operacion.calcularValor();


        //Resultado
        Assertions.assertEquals(0,valor,0.1);
    }

    @Test
    public void operacionCerrada(){
        //Una vez que la operacion esta cerrada, no se puede cambiar el precio
        //Precondicion


        Item unItem = new Item();
        unItem.setValor(100);

        List <Item> Items;
        Items.add(unItem);
        OperacionDeEgreso Operacion = new OperacionDeEgreso(Items);
        Operacion.calcularValor();
        Operacion.cerrar();

        //Operacion
        Operacion.Items.remove(unItem);
        Operacion.calcularValor();

        //Resultado
        Assertions.assertEquals(100,Operacion.getPrecio(),0.1);
    }

    @Test
    public void operacionYaCerrada() throws OperacionYaCerradaException{
        //Una vez que ya se cerro la operacion, no se puede volver a cerrar y recalcular el precio

        List<Item> Items;
        Items Item = new Items();
        Item.valor = 300;

        Items.add(Item);
        OperacionDeEgreso Operacion = new OperacionDeEgreso(Items);
        Operacion.cerrar();

        //Operacion
        Operacion.cerrar();

        //Resultado
        Assertions.AssertTrue(Operacion.isCerrada());

    }

}
