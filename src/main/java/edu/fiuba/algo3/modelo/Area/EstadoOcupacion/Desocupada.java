package edu.fiuba.algo3.modelo.Area.EstadoOcupacion;

import edu.fiuba.algo3.modelo.Area.EstadoPiso.EstadoPiso;

public class Desocupada implements EstadoOcupacion {
    @Override
    public EstadoOcupacion ocupar() {
        return new Ocupada();
    }

    @Override
    public EstadoPiso ejecutar(EstadoPiso estadoPiso) {
        return estadoPiso.cubrirConMoho();
    }
}
