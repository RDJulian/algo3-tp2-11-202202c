package edu.fiuba.algo3.modelo.Entidad.Comando;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero.GeneraLarva;

public class GenerarLarva implements Comando {
    private GeneraLarva entidad;

    public GenerarLarva(GeneraLarva entidad) {
        this.entidad = entidad;
    }

    public void ejecutar() {
        this.entidad.generarLarva();
    }
}
