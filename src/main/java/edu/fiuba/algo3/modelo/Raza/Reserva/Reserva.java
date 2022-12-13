package edu.fiuba.algo3.modelo.Raza.Reserva;

import edu.fiuba.algo3.modelo.Excepciones.RecursoInsuficienteException;

public class Reserva {
    private int unidades;

    public Reserva() {
        this.unidades = 0;
    }

    public void agregarRecurso(int unidades) {
        this.unidades += unidades;
    }

    public void gastarRecurso(int unidades) {
        if (!construible(unidades)) {
            throw new RecursoInsuficienteException();
        }
        this.unidades -= unidades;
    }

    private boolean construible(int unidades) {
        return this.unidades - unidades >= 0;
    }
}
