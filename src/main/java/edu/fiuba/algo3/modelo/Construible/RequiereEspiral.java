package edu.fiuba.algo3.modelo.Construible;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Espiral;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;

public class RequiereEspiral implements Construible {
    @Override
    public void manejar(Class<?> estructura) {
        if (estructura != Espiral.class) {
            throw new ConstruccionNoValidaException();
        }
    }
}