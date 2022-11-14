package edu.fiuba.algo3.modelo.Construible;

import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValida;
import edu.fiuba.algo3.modelo.Recurso.Recurso;

public class SobreGasVespeno implements ConstruibleSobreRecurso {
    @Override
    public void construible(Recurso recurso) {
        recurso.construible(this);
    }

    @Override
    public void construirEnGas() {

    }

    @Override
    public void construirEnMineral() {
        throw new ConstruccionNoValida();
    }
}
