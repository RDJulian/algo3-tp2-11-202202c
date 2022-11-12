package edu.fiuba.algo3.modelo.Construible;

import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValida;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

public class NoSobreMoho implements ConstruibleSobreRango {

    @Override
    public void construible(Piso piso, Posicion posicion) {
        piso.construible(this);
    }

    @Override
    public void construirEnPilon() {

    }

    @Override
    public void construirEnMoho() {
        throw new ConstruccionNoValida();
    }
}
