package edu.fiuba.algo3.modelo.Reserva;

import edu.fiuba.algo3.modelo.Excepciones.RecursoInsuficiente;

public class Reserva {
    private int unidades;

    public Reserva() {
        this.unidades = 0;
    }

    public Reserva(int unidades) { // Utilitario.
        this.unidades = unidades;
    }

    public int getRecurso() {
        return this.unidades;
    }

    public void agregarRecurso(int unidades) {
        this.unidades += unidades;
    }

    public void gastarRecurso(int costoGas) {
        int nuevasUnidades = this.unidades - costoGas;
        if (nuevasUnidades < 0) {
            throw new RecursoInsuficiente();
        }
        this.unidades = nuevasUnidades;
    }
}
