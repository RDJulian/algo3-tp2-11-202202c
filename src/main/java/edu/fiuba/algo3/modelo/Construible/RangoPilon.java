package edu.fiuba.algo3.modelo.Construible;

import edu.fiuba.algo3.modelo.Estructura.Pilon;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValida;
import edu.fiuba.algo3.modelo.Piso.Moho;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

public class RangoPilon implements ConstruibleSobreRango {
    @Override
    public void construible(Pilon pilon, Posicion posicion) {
        if (!(pilon.enRango(posicion))) {
            throw new ConstruccionNoValida();
        }
    }

    @Override
    public void construible(Moho moho, Posicion posicion) {
        //Para lanzar excepcion a futuro
    }
}
