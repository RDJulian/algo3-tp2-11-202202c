package edu.fiuba.algo3.modelo.Construible;

import edu.fiuba.algo3.modelo.Estructura.Acceso;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;

public class RequiereAcceso implements RequiereOtraEstructura {
    @Override
    public void manejar(Class<?> estructura) {
        if (estructura != Acceso.class) {
            throw new ConstruccionNoValidaException();
        }
    }
}