package edu.fiuba.algo3.modelo.Construible;

import edu.fiuba.algo3.modelo.Recurso.Recurso;

public interface ConstruibleSobreRecurso {
    void construible(Recurso recurso);

    void construirEnGas();

    void construirEnMineral();
}
