package edu.fiuba.algo3.modelo.Area.EstadoOcupacion;

public class Desocupada implements EstadoOcupacion {
    @Override
    public EstadoOcupacion ocupar() {
        return new Ocupada();
    }
}
