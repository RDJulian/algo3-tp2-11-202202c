package edu.fiuba.algo3.modelo.Raza;

import edu.fiuba.algo3.modelo.Reserva.Reserva;

public class Raza {
    //Esta clase deberia tener mas responsabilidad. Deberia ser como clase manejadora de
    //lo que corresponda a una Raza (estructuras, unidades, etc.)
    //La desventaja de tener una clase como esta es que se termina haciendo pasamano con las reservas.
    private Reserva reservaMineral;
    private Reserva reservaGas;

    public Raza() {
        this.reservaMineral = new Reserva();
        this.reservaGas = new Reserva();
    }

    //Estos metodos delegan a las Reservas correspondientes.
    //Sirven tanto para unidades como para estructuras.
    //Como las reservas son de la misma clase, se necesita dos metodos separados para cada una.
    public void recolectarGas(int unidades) {
        reservaGas.agregarRecurso(unidades);
    }

    public void recolectarMineral(int unidades) {
        reservaMineral.agregarRecurso(unidades);
    }

    public void construible(int costoMineral, int costoGas) {
        reservaMineral.construible(costoMineral);
        reservaGas.construible(costoGas);
    }

    public void gastarRecursos(int mineral, int gas) {
        reservaGas.gastarRecurso(gas);
        reservaMineral.gastarRecurso(mineral);
    }
}
