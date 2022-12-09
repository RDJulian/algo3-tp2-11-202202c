package edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso;

import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Recurso.GasVespeno;
import edu.fiuba.algo3.modelo.Recurso.Mineral;
import edu.fiuba.algo3.modelo.Recurso.Nada;
import edu.fiuba.algo3.modelo.Recurso.Recurso;

public class SobreGasVespeno extends ConstruibleRecurso {
    @Override
    public boolean visitar(GasVespeno gasVespeno) {
        return true;
    }

    @Override
    public boolean visitar(Mineral mineral) {
        return false;
    }

    @Override
    public boolean visitar(Nada nada) {
        return false;
    }
}

