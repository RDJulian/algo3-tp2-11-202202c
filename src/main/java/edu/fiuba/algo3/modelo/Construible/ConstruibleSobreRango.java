package edu.fiuba.algo3.modelo.Construible;

import edu.fiuba.algo3.modelo.Estructura.Pilon;
import edu.fiuba.algo3.modelo.Piso.Moho;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

public interface ConstruibleSobreRango {
    void construible(Pilon pilon, Posicion posicion);

    void construible(Moho moho, Posicion posicion);
}
