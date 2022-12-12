package edu.fiuba.algo3.modelo.Entidad.Comando;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero.Larvas;

public class UsarLarva implements Comando {
    private Larvas larvas;

    public UsarLarva(Larvas larvas) {
        this.larvas = larvas;
    }

    @Override
    public void ejecutar() {
        larvas.usarLarva();
    }
}
