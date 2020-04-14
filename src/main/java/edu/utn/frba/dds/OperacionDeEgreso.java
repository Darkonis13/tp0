package edu.utn.frba.dds;

import java.util.ArrayList;
import java.util.List;

public class OperacionDeEgreso {
    public OperacionDeEgreso(List<Item> items) {
        Items = items;
    }

    private List <Item> Items = new ArrayList<Item>();
    private Documento documentoComercial;
    private boolean cerrada;
    private double precio = 0;


    public boolean isCerrada() {
        return cerrada;
    }

    public double calcularValor(){
        if(cerrada) return precio;
        else{
            if(!Items.isEmpty())
                return precio = Items.stream().mapToDouble(i -> i.getValor()).sum();
            else
                return 0;
        }

    }

    public Documento getDocumentoComercial() {
        return documentoComercial;
    }

    public void cerrar() throws OperacionYaCerradaException{
        if(!isCerrada()){
            calcularValor();
            this.cerrada = true;
        }
        else{
            throw new OperacionYaCerradaException();
        }

    }

    public void generarRemito() throws OperacionYaCerradaException, NoHayItemsException {
        if(!Items.isEmpty()){
            if(Items.stream().allMatch(i -> i.isEsArticulo() ))
                if(isCerrada()){
                    documentoComercial = new Documento(calcularValor());
                }
                else{
                    cerrar();
                    documentoComercial = new Documento(calcularValor());
                }
        }
        else throw new NoHayItemsException();
    }


    public List<Item> getItems() {
        return Items;
    }

    public void setItems(List<Item> items) {
        Items = items;
    }

    public double getPrecio() {
        return precio;
    }

}
