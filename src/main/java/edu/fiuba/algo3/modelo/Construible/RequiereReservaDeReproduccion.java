package edu.fiuba.algo3.modelo.Construible;

import edu.fiuba.algo3.modelo.Entidad.Estructura.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;

public class RequiereReservaDeReproduccion implements Construible {
    @Override
    public void manejar(Class<?> estructura) {
        if (estructura != ReservaDeReproduccion.class) {
            throw new ConstruccionNoValidaException();
        }
    }
}