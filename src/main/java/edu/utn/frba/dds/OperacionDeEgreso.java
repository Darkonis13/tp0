package edu.utn.frba.dds;

import java.util.ArrayList;
import java.util.List;

public class OperacionDeEgreso {
    private List <Item> Items = new ArrayList<Item>();
    private Documento documentoComercial;
    private boolean cerrada;
    private double precio;


    public double calcularValor(){
        if(cerrada) return precio;
        else return precio = Items.stream().mapToDouble(i -> i.getValor()).sum();

    }

    public void cerrar(){
        this.cerrada = true;
    }

    public void generarRemito(){
       if(Items.stream().allMatch(i -> i.isEsArticulo() ))
           documentoComercial = new Documento();
    }
}
