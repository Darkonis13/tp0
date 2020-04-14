package edu.utn.frba.dds;

public class ArticuloNegativoException extends Exception {
    public ArticuloNegativoException(){
    }
    public ArticuloNegativoException(String message){
        super(message);
    }
    public ArticuloNegativoException(Throwable cause){
        super(cause);
    }
    public ArticuloNegativoException(String message, Throwable cause){
        super(message, cause);
    }
    public ArticuloNegativoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
        super(message,cause,enableSuppression,writableStackTrace);
    }
}