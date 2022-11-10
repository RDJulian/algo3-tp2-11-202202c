package edu.fiuba.algo3.modelo.Construible;

import edu.fiuba.algo3.modelo.Recurso.Recurso;

public class Construible {
    ConstruibleSobreRecurso sobreRecurso;

    public Construible(ConstruibleSobreRecurso sobreRecurso) {
        this.sobreRecurso = sobreRecurso;
    }

    public void construible(Recurso recurso) {
        this.sobreRecurso.construible(recurso);
    }
}