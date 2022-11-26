package edu.fiuba.algo3.modelo.Construible.ConstruiblePiso;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Pilon;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Piso.Moho;
import edu.fiuba.algo3.modelo.Piso.Nada;

public class RangoNada implements ConstruiblePiso{
    @Override
    public void visitar(Pilon piso) {

    }

    @Override
    public void visitar(Moho piso) {
        throw new ConstruccionNoValidaException();
    }

    @Override
    public void visitar(Nada piso) {

    }
}
