package edu.fiuba.algo3.modelo.Area.EstadoOcupacion;

import edu.fiuba.algo3.modelo.Area.EstadoPiso.EstadoPiso;

public interface EstadoOcupacion {
    EstadoOcupacion ocupar();

    //Si se cubre de moho o no depende de si esta ocupada.
    EstadoPiso cubrirConMoho(EstadoPiso estadoPiso);
}
