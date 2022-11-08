package edu.fiuba.algo3.modelo.Exceptions;

public class CombinacionDeEstructurasInvalida extends RuntimeException{

    public CombinacionDeEstructurasInvalida(){
        super("No se puede contruir sobre este terreno");
    }
}
