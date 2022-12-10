package edu.fiuba.algo3.modelo.Area.EstadoOcupacion;

import edu.fiuba.algo3.modelo.Area.EstadoPiso.EstadoPiso;

public interface EstadoOcupacion {
    EstadoOcupacion ocupar();

    EstadoPiso ejecutar(EstadoPiso estadoPiso);
}
