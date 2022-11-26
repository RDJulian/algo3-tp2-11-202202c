package edu.fiuba.algo3.modelo.Reserva;

import edu.fiuba.algo3.modelo.Excepciones.RecursoInsuficienteException;

public class Reserva {
    private int unidades;

    public Reserva() {
        this.unidades = 0;
    }

    public void agregarRecurso(int unidades) {
        this.unidades += unidades;
    }

    //Pensar en un nombre mejor.
    public void gastarRecurso(int unidades) {
        construible(unidades);
        this.unidades -= unidades;
    }

    public void construible(int unidades) {
        if (this.unidades - unidades < 0) {
            throw new RecursoInsuficienteException();
        }
    }
}
