package edu.fiuba.algo3.modelo.Excepciones;

public class TerrenoIncompatible extends RuntimeException{

    public TerrenoIncompatible(){
        super("No se puede contruir esa estructura sobre este terreno");
    }
}
