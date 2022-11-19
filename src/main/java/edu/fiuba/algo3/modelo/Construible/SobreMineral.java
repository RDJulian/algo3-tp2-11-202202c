package edu.fiuba.algo3.modelo.Construible;

import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Recurso.Mineral;

public class SobreMineral implements ConstruibleSobreRecurso {
    @Override
    public void manejar(Class<?> recurso) {
        if (recurso != Mineral.class) {
            throw new ConstruccionNoValidaException();
        }
    }
}