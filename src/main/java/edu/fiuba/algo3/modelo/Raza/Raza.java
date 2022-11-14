package edu.fiuba.algo3.modelo.Raza;

import edu.fiuba.algo3.modelo.Reserva.Reserva;

public class Raza { //Esta clase se deberia usar en un caso de uso.
    private Reserva reservaGas;
    private Reserva reservaMineral;

    public Raza() {
        this.reservaGas = new Reserva();
        this.reservaMineral = new Reserva();
    }
}
