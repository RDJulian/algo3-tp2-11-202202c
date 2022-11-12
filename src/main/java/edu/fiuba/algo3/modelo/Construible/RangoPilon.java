package edu.fiuba.algo3.modelo.Construible;

import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValida;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

public class RangoPilon implements ConstruibleSobreRango {
    @Override
    public void construible(Piso pilon, Posicion posicion) {
        pilon.construible(this);
        if (!pilon.enRango(posicion)) {
            throw new ConstruccionNoValida();
        }
    }

    @Override
    public void construirEnPilon() {

    }

    @Override
    public void construirEnMoho() {
        throw new ConstruccionNoValida();
    }
}
