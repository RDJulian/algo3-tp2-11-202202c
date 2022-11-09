package edu.fiuba.algo3.modelo.CeldaDeTerreno;

import edu.fiuba.algo3.modelo.CompatibilidadDeTerreno.CompatibilidadDeTerreno;
import edu.fiuba.algo3.modelo.Reserva.ReservaGas;

public class Volcan extends CeldaDeTerreno{

    private int unidadesDeGas;
    public CeldaDeTerreno verificarCompatibilidad(CompatibilidadDeTerreno compatibilidad) {
        return compatibilidad.obtenerVolcan(this);
    }

    public void extraerGas(int unidadesAExtraer, ReservaGas reservaGas) {
        this.unidadesDeGas -= unidadesAExtraer;
        reservaGas.agregarRecurso(unidadesAExtraer);
    }
}
