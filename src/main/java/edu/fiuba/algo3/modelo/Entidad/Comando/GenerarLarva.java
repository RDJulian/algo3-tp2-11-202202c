package edu.fiuba.algo3.modelo.Entidad.Comando;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero.GeneraLarva;

public class GenerarLarva implements Comando {
    private GeneraLarva criadero;

    public GenerarLarva(GeneraLarva criadero) {
        this.criadero = criadero;
    }

    public void ejecutar() {
        this.criadero.generarLarva();
    }
}
