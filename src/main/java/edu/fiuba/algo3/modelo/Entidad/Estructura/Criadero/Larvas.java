package edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero;

import edu.fiuba.algo3.modelo.Excepciones.CriaderoSinLarvasException;

public class Larvas {
    private int larvas;

    public Larvas() {
        this.larvas = 3;
    }

    public void usarLarva() {
        if (larvas == 0) {
            throw new CriaderoSinLarvasException();
        }
        larvas -= 1;
    }

    public void generarLarva() {
        if (larvas < 3) {
            larvas += 1;
        }
    }
}
