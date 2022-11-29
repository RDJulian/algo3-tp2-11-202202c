package edu.fiuba.algo3.modelo.Entidad.EjecutarAlPasarTurno;

import edu.fiuba.algo3.modelo.Entidad.Estructura.GeneraLarva;

public class GenerarLarva implements Ejecutar {
    private GeneraLarva entidad;

    public GenerarLarva(GeneraLarva entidad) {
        this.entidad = entidad;
    }

    @Override
    public void ejecutar() {
        entidad.generarLarva();
    }
}
