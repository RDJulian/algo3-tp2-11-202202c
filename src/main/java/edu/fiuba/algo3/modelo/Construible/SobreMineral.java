package edu.fiuba.algo3.modelo.Construible;

import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValida;
import edu.fiuba.algo3.modelo.Recurso.Recurso;

public class SobreMineral implements ConstruibleSobreRecurso {
    @Override
    public void construible(Recurso recurso) {
        recurso.construible(this);
    }

    @Override
    public void construirEnGas() {
        throw new ConstruccionNoValida();
    }

    @Override
    public void construirEnMineral() {
        
    }
}
