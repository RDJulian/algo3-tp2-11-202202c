package edu.fiuba.algo3.modelo.Construible;

import edu.fiuba.algo3.modelo.Entidad.Estructura.PuertoEstelar;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;

public class RequierePuertoEstelar implements Construible {
    @Override
    public void manejar(Class<?> estructura) {
        if (estructura != PuertoEstelar.class) {
            throw new ConstruccionNoValidaException();
        }
    }
}