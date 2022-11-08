package edu.fiuba.algo3.modelo.Raza;

import edu.fiuba.algo3.modelo.Reserva.ReservaGas;
import edu.fiuba.algo3.modelo.Reserva.ReservaMineral;

public class Zerg {
    private ReservaGas reservaGas;
    private ReservaMineral reservaMineral;

    public Zerg(){
        this.reservaGas = new ReservaGas();
        this.reservaMineral = new ReservaMineral();
    }
}
