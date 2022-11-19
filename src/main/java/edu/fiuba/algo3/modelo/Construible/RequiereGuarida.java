package edu.fiuba.algo3.modelo.Construible;

import edu.fiuba.algo3.modelo.Estructura.Guarida;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;

public class RequiereGuarida implements RequiereOtraEstructura {
    @Override
    public void manejar(Class<?> estructura) {
        if (estructura != Guarida.class) {
            throw new ConstruccionNoValidaException();
        }
    }
}