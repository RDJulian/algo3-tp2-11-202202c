package edu.fiuba.algo3.modelo.EjecutarAlPasarTurno;

import edu.fiuba.algo3.modelo.Entidad.GeneraLarva;

public class GenerarLarva implements Ejecutar {
    private GeneraLarva entidad;

    public GenerarLarva(GeneraLarva entidad) {
        this.entidad = entidad;
    }

    public void ejecutar() {
        this.entidad.generarLarva();
    }
}
