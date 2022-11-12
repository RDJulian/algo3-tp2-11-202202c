package edu.fiuba.algo3.modelo.Construible;

import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValida;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

public class RangoMoho implements ConstruibleSobreRango {
    @Override
    public void construible(Piso moho, Posicion posicion) {
        moho.construible(this);
        if (!moho.enRango(posicion)) {
            throw new ConstruccionNoValida();
        }
    }

    @Override
    public void construirEnPilon() {
        throw new ConstruccionNoValida();
    }

    @Override
    public void construirEnMoho() {

    }
}
