package edu.utn.frba.dds;

public class Documento {

    public Documento(double valor) {
        this.valor = valor;
    }

    private double valor = 0;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
