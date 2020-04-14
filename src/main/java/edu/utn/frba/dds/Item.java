package edu.utn.frba.dds;

public class Item {
    private double valor;
    private boolean esArticulo;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) throws ValorNegativoException {
        if(valor>=0){
            this.valor = valor;
        }
        else throw new ValorNegativoException();
    }

    public boolean isEsArticulo() {
        return esArticulo;
    }

    public void setEsArticulo(boolean esArticulo) {
        this.esArticulo = esArticulo;
    }

}

