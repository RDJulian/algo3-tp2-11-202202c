package edu.fiuba.algo3.modelo.Construible;

import edu.fiuba.algo3.modelo.Estructura.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;

public class RequiereReservaDeReproduccion implements RequiereOtraEstructura {
    @Override
    public void manejar(Class<?> estructura) {
        if (estructura != ReservaDeReproduccion.class) {
            throw new ConstruccionNoValidaException();
        }
    }
}