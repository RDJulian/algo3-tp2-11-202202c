package edu.fiuba.algo3.modelo.Recurso;

import edu.fiuba.algo3.modelo.Construible.ConstruibleSobreRecurso;
import edu.fiuba.algo3.modelo.Reserva.Reserva;

public abstract class Recurso {
    protected int unidades;

    public abstract void construible(ConstruibleSobreRecurso sobreRecurso);

    public abstract void extraerRecurso(int unidades, Reserva reserva);
}