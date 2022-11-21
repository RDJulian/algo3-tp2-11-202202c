package edu.fiuba.algo3.modelo.Construible;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;

public class RequiereCriadero implements Construible {
    @Override
    public void manejar(Class<?> estructura) {
        if (estructura != Criadero.class) {
            throw new ConstruccionNoValidaException();
        }
    }
}