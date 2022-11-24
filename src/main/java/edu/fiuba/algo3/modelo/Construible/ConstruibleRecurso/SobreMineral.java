package edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso;

import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Recurso.GasVespeno;
import edu.fiuba.algo3.modelo.Recurso.Mineral;
import edu.fiuba.algo3.modelo.Recurso.Nada;

public class SobreMineral implements ConstruibleRecurso {
    @Override
    public void visitar(GasVespeno recurso) {
        throw new ConstruccionNoValidaException();
    }

    @Override
    public void visitar(Mineral recurso) {

    }

    @Override
    public void visitar(Nada recurso) {
        throw new ConstruccionNoValidaException();
    }
}