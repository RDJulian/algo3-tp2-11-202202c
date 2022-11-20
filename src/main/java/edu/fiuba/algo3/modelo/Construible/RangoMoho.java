package edu.fiuba.algo3.modelo.Construible;

import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Piso.Moho;

public class RangoMoho implements Construible {
    @Override
    public void manejar(Class<?> rango) {
        if (rango != Moho.class) {
            throw new ConstruccionNoValidaException();
        }
    }
}
