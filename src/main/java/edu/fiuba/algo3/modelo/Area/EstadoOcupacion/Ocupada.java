package edu.fiuba.algo3.modelo.Area.EstadoOcupacion;

import edu.fiuba.algo3.modelo.Area.EstadoPiso.EstadoPiso;
import edu.fiuba.algo3.modelo.Excepciones.PosicionOcupadaException;

public class Ocupada implements EstadoOcupacion {
    @Override
    public EstadoOcupacion ocupar() {
        throw new PosicionOcupadaException();
    }

    @Override
    public EstadoPiso ejecutar(EstadoPiso estadoPiso) {
        return estadoPiso;
    }
}
