package edu.utn.frba.dds;

public class NoHayItemsException extends Exception{
    public NoHayItemsException(){
    }
    public NoHayItemsException(String message){
        super(message);
    }
    public NoHayItemsException(Throwable cause){
        super(cause);
    }
    public NoHayItemsException(String message, Throwable cause){
        super(message, cause);
    }
    public NoHayItemsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
        super(message,cause,enableSuppression,writableStackTrace);
    }
}

