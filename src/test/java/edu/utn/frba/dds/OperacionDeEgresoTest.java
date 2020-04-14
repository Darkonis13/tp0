package edu.utn.frba.dds;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OperacionDeEgresoTest {
    @Test
    public void testDeValor() throws ValorNegativoException {

        //Calcula el valor de los items que la operacion contiene

        //Precondicion
        double valor;

        Item unItem = new Item();
        Item otroItem = new Item();

        unItem.setValor(1500);
        otroItem.setValor(4000);

        List<Item> Items = new ArrayList<Item>();
        Items.add(unItem);
        Items.add(otroItem);

        OperacionDeEgreso Operacion = new OperacionDeEgreso(Items);

        //Operacion
        valor = Operacion.calcularValor();

        //Resultado
        assertEquals(5500,valor,0.1);
    }

    @Test
    public void testSinItems(){
        //Si la lista de items esta vacia, el valor calculado debe ser 0

        //Precondicion
        List<Item> ListaItemVacia = new ArrayList<Item>();
        OperacionDeEgreso Operacion = new OperacionDeEgreso(ListaItemVacia);
        double valor;

        //Operacion
        valor = Operacion.calcularValor();


        //Resultado
        assertEquals(0,valor,0.1);
    }

    @Test
    public void operacionCerrada() throws OperacionYaCerradaException, ValorNegativoException {
        //Una vez que la operacion esta cerrada, no se puede cambiar el precio
        //Precondicion


        Item unItem = new Item();
        unItem.setValor(100);

        List <Item> Items = new ArrayList<Item>();
        Items.add(unItem);
        OperacionDeEgreso Operacion = new OperacionDeEgreso(Items);
        Operacion.calcularValor();
        Operacion.cerrar();

        List<Item> ItemsVacios = new ArrayList<Item>();

        //Operacion
        Operacion.setItems(ItemsVacios);
        Operacion.calcularValor();

        //Resultado
        assertEquals(100,Operacion.getPrecio(),0.1);
    }

    @Test
    public void operacionYaCerrada() throws OperacionYaCerradaException, ValorNegativoException {
        //Una vez que ya se cerro la operacion, no se puede volver a cerrar y recalcular el precio

        List<Item> Items = new ArrayList<Item>();
        Item unItem = new Item();
        unItem.setValor(300);

        Items.add(unItem);
        OperacionDeEgreso Operacion = new OperacionDeEgreso(Items);
        Operacion.cerrar();

        //Operacion
        unItem.setValor(100000);
        OperacionYaCerradaException op = assertThrows(OperacionYaCerradaException.class,()->Operacion.cerrar());

        //Resultado
        assertEquals(300,Operacion.getPrecio(),0.1);
    }

    @Test
    public void GeneraDocumentotodosArticulos() throws OperacionYaCerradaException, NoHayItemsException {
        //Si todos los items son articulos, se genera el documento
        List<Item> Items = new ArrayList<Item>();
        Item unItem = new Item();
        unItem.setEsArticulo(true);
        Item otroItem = new Item();
        otroItem.setEsArticulo(true);

        Items.add(unItem);
        Items.add(otroItem);

        OperacionDeEgreso Operacion = new OperacionDeEgreso(Items);


        Operacion.generarRemito();
        Assertions.assertNotNull(Operacion.getDocumentoComercial());
    }

    @Test
    public void sinItems() throws NoHayItemsException{
        //si no hay items para verificar en la lista de items de la operacion, no se genera el documento y lanza un error

        List<Item> Items = new ArrayList<Item>();
        OperacionDeEgreso Operacion = new OperacionDeEgreso(Items);


        Assertions.assertThrows(NoHayItemsException.class,()->Operacion.generarRemito());
    }

}
