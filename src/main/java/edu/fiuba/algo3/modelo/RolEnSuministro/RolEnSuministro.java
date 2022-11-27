package edu.fiuba.algo3.modelo.RolEnSuministro;

import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.*;

public abstract class RolEnSuministro {

    public abstract int afectarSuministro(int suministroActual, EstadoEntidad estadoEntidad);

    //Buscar mejor solucion.
    public boolean visitar(Destruido estadoEntidad) {
        return false;
    }

    public boolean visitar(EnConstruccion estadoEntidad) {
        return false;
    }

    public boolean visitar(Operativa estadoEntidad) {
        return true;
    }

    public boolean visitar(SinEnergia estadoEntidad) {
        return false;
    }
}
