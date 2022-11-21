package edu.fiuba.algo3.modelo.Entidad;

import edu.fiuba.algo3.modelo.EstadoEntidad.EstadoEntidad;
import edu.fiuba.algo3.modelo.Posicion.Rango;

public interface Daniable { //Se puede potencialmente borrar si se usa una clase Entidad.
    void daniar(int danioTierra, int danioAire, Rango rango);

    //Como daniar puede llevar a cambiar de estado, tambien se pide setEstado().
    void setEstado(EstadoEntidad estado);
}
