package edu.fiuba.algo3.modelo.Estructura;

import edu.fiuba.algo3.modelo.CeldaDeTerreno.CeldaDeTerreno;
import edu.fiuba.algo3.modelo.CeldaDeTerreno.Volcan;
import edu.fiuba.algo3.modelo.CompatibilidadDeTerreno.CompatibilidadDeTerreno;
import edu.fiuba.algo3.modelo.CompatibilidadDeTerreno.ConstruibleEnVolcan;
import edu.fiuba.algo3.modelo.Reserva.ReservaGas;

public class Asimilador extends Estructura{

    private final Volcan volcan;
    private ReservaGas reservaGas;

    public Asimilador(CeldaDeTerreno celdaDeTerreno, ReservaGas reservaGas){
        CompatibilidadDeTerreno compatibilidad = new ConstruibleEnVolcan();
        this.volcan = (Volcan) celdaDeTerreno.verificarCompatibilidad(compatibilidad);
        this.reservaGas = reservaGas;
        this.tiempoConstruccionRestante = 6;
        
    }
    @Override
    public void pasarTurnoOperativo() {

    }
}
