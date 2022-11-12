package edu.fiuba.algo3.modelo.Construible;

import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

public interface ConstruibleSobreRango {
    void construible(Piso piso, Posicion posicion);

    void construirEnPilon();

    void construirEnMoho();
}
