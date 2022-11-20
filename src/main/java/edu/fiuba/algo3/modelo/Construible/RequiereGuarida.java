package edu.fiuba.algo3.modelo.Construible;

import edu.fiuba.algo3.modelo.Estructura.Guarida;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;

public class RequiereGuarida implements Construible {
    @Override
    public void manejar(Class<?> estructura) {
        if (estructura != Guarida.class) {
            throw new ConstruccionNoValidaException();
        }
    }
}