package edu.fiuba.algo3.modelo.Piso;

import edu.fiuba.algo3.modelo.Area.Area;

public class Moho implements Piso {
    private int turnos;
    private int rango;
    private Area area;

    public Moho(Area area) {
        this.rango = 5;
        this.turnos = 0;
        this.area = area;

        area.cubrirConMoho();
    }

    //Llamar este metodo luego de pasar turno para todas las posiciones. La idea es que se actualicen todas.
    @Override
    public void actualizarArea(Area area) {
        if (area.enRango(this.area, rango)) {
            area.cubrirConMoho();
        }
    }

    public void pasarTurno() {
        turnos += 1;
        if (turnos % 2 == 0) {
            this.rango += 1;
        }
    }
}
