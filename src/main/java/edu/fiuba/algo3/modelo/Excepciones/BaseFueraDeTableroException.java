package edu.fiuba.algo3.modelo.Excepciones;

public class BaseFueraDeTableroException extends RuntimeException {

    public BaseFueraDeTableroException() {
        super("La base que quiere generar esta fuera de los limites del tablero.");
    }
}
