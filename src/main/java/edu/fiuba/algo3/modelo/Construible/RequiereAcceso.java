package edu.fiuba.algo3.modelo.Construible;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Acceso;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;

public class RequiereAcceso implements Construible {
    @Override
    public void manejar(Class<?> estructura) {
        if (estructura != Acceso.class) {
            throw new ConstruccionNoValidaException();
        }
    }
}