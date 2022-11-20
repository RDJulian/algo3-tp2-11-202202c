package edu.fiuba.algo3.modelo.Unidad;

import edu.fiuba.algo3.modelo.EstadoEntidad.EstadoEntidad;

public interface Daniable {
    void daniar(int danioTierra, int danioAire);

    //Como daniar puede llevar a cambiar de estado, tambien se pide setEstado().
    void setEstado(EstadoEntidad estado);
}
