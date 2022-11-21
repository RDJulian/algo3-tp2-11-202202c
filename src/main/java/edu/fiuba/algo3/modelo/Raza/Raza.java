package edu.fiuba.algo3.modelo.Raza;

import edu.fiuba.algo3.modelo.Reserva.Reserva;

public class Raza {
    //Esta clase deberia tener mas responsabilidad. Deberia ser como clase manejadora de
    //lo que corresponda a una Raza (estructuras, unidades, etc.)
    private Reserva reservaMineral;
    private Reserva reservaGas;

    //Para testear.
    public Raza(Reserva reservaMineral, Reserva reservaGas) {
        this.reservaMineral = reservaMineral;
        this.reservaGas = reservaGas;
    }

    public Raza() {
        this.reservaMineral = new Reserva();
        this.reservaGas = new Reserva();
    }

    public void recolectarGas(int unidades) {
        this.reservaGas.agregarRecurso(unidades);
    }

    public void recolectarMineral(int unidades) {
        this.reservaMineral.agregarRecurso(unidades);
    }

    public void construible(int costoMineral, int costoGas) {
        this.reservaMineral.construible(costoMineral);
        this.reservaGas.construible(costoGas);
    }

    //Sirve tanto para unidades como para estructuras
    public void gastarRecursos(int mineral, int gas) {
        this.reservaGas.gastarRecurso(gas);
        this.reservaMineral.gastarRecurso(mineral);
    }
}
