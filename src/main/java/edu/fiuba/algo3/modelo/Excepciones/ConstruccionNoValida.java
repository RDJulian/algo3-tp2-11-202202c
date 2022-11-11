package edu.fiuba.algo3.modelo.Excepciones;

public class ConstruccionNoValida extends RuntimeException {

    public ConstruccionNoValida() {
        super("No se puede contruir sobre este terreno");
    }
}
