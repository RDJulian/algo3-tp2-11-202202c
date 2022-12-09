package edu.fiuba.algo3.modelo.Posicion.EstadoOcupado;

public class Desocupada implements EstadoPosicion {
    @Override
    public EstadoPosicion ocupar() {
        return new Ocupada();
    }
}
