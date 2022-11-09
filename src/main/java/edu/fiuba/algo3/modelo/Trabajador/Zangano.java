package edu.fiuba.algo3.modelo.Trabajador;

import edu.fiuba.algo3.modelo.CeldaDeTerreno.Volcan;
import edu.fiuba.algo3.modelo.Reserva.ReservaGas;

public class Zangano {

    public void extraerGas(Volcan volcan, ReservaGas reservaGas) {
        volcan.extraerGas(10, reservaGas);
    }

}
