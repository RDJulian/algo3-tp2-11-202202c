package edu.fiuba.algo3.modelo.Construible;

import edu.fiuba.algo3.modelo.Estructura.Pilon;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

public class RangoMoho implements ConstruibleSobreRango {
    @Override
    public void construible(Pilon pilon, Posicion posicion) {
        //Para lanzar excepcion a futuro
    }

    @Override
    public void construible(Piso moho, Posicion posicion) {
        moho.enRango(posicion);
    }
}
