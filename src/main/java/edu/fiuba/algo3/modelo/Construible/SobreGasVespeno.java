package edu.fiuba.algo3.modelo.Construible;

import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Recurso.GasVespeno;

public class SobreGasVespeno implements ConstruibleSobreRecurso {
    @Override
    public void manejar(Class<?> recurso) {
        if (recurso != GasVespeno.class) {
            throw new ConstruccionNoValidaException();
        }
    }
}