package edu.fiuba.algo3.modelo.Construible;

import edu.fiuba.algo3.modelo.Reserva.Reserva;

public class Costo {
    private int costoGas;
    private int costoMineral;

    public Costo(int costoMineral, int costoGas) {
        this.costoGas = costoGas;
        this.costoMineral = costoMineral;
    }

    public void construible(Reserva reservaMineral, Reserva reservaGas) {
        reservaMineral.gastarRecurso(costoMineral);
        reservaGas.gastarRecurso(costoGas);
    }
}
