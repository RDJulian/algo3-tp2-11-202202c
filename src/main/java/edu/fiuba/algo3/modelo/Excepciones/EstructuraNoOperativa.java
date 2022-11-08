package edu.fiuba.algo3.modelo.Excepciones;

public class EstructuraNoOperativa extends RuntimeException {

    public EstructuraNoOperativa(){
        super("La estructura se encuentra en construcción");
    }

}
