package edu.utn.frba.dds;

public class OperacionYaCerradaException extends Exception {
    public OperacionYaCerradaException(){
    }
    public OperacionYaCerradaException(String message){
        super(message);
    }
    public OperacionYaCerradaException(Throwable cause){
        super(cause);
    }
    public OperacionYaCerradaException(String message, Throwable cause){
        super(message, cause);
    }
    public OperacionYaCerradaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
        super(message,cause,enableSuppression,writableStackTrace);
    }
}
