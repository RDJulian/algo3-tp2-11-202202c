package edu.fiuba.algo3.modelo.Construible;

import edu.fiuba.algo3.modelo.Estructura.Pilon;
import edu.fiuba.algo3.modelo.Piso.Moho;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

public class RangoPilon implements ConstruibleSobreRango {
    @Override
    public void construible(Pilon pilon, Posicion posicion) {
        pilon.enRango(posicion);
    }

    @Override
    public void construible(Moho moho, Posicion posicion) {
        //Para lanzar excepcion a futuro
    }
}
