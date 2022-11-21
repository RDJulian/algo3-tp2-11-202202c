package edu.fiuba.algo3.modelo.Construible;

import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Recurso.GasVespeno;
import edu.fiuba.algo3.modelo.Recurso.Mineral;

public class NoSobreRecurso implements Construible {
    @Override
    public void manejar(Class<?> recurso) {
        if (recurso == Mineral.class || recurso == GasVespeno.class) {
            throw new ConstruccionNoValidaException();
        }
    }
}
