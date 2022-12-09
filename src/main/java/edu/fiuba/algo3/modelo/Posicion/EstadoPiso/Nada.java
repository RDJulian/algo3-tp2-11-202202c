package edu.fiuba.algo3.modelo.Posicion.EstadoPiso;

import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.ConstruiblePiso;

public class Nada implements EstadoPiso {
    @Override
    public boolean construible(ConstruiblePiso construiblePiso) {
        return construiblePiso.visitar(this);
    }
}
