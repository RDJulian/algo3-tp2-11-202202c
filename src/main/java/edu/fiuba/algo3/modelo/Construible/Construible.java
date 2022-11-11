package edu.fiuba.algo3.modelo.Construible;

import edu.fiuba.algo3.modelo.Estructura.Pilon;
import edu.fiuba.algo3.modelo.Piso.Moho;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Recurso.Recurso;

public class Construible {
    ConstruibleSobreRecurso sobreRecurso;
    ConstruibleSobreRango sobreRango;

    public Construible(ConstruibleSobreRecurso sobreRecurso, ConstruibleSobreRango sobreRango) {
        this.sobreRecurso = sobreRecurso;
        this.sobreRango = sobreRango;
    }

    public void construible(Recurso recurso) {
        this.sobreRecurso.construible(recurso);
    }

    public void construible(Pilon pilon, Posicion posicion) {
        this.sobreRango.construible(pilon, posicion);
    }

    public void construible(Moho moho, Posicion posicion) {
        this.sobreRango.construible(moho, posicion);
    }
}