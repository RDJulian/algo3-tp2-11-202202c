package edu.fiuba.algo3.modelo.Construible;

import edu.fiuba.algo3.modelo.Estructura.Pilon;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;

public class RangoPilon implements ConstruibleSobreRango {
    public void manejar(Class<?> rango) {
        if (rango != Pilon.class) {
            throw new ConstruccionNoValidaException();
        }
    }
}
