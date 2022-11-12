package edu.fiuba.algo3.modelo.Construible;

import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

public interface ConstruibleSobreRango {
    //Revisar comportamiento. Moho y Pilon son mutuamente excluyentes y capaz no deberian.
    void construible(Piso piso, Posicion posicion);

    void construirEnPilon();

    void construirEnMoho();
}
