package edu.fiuba.algo3.modelo.Area.EstadoPiso;

import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.ConstruiblePiso;

public class TieneEnergiaPilon implements EstadoPiso {
    @Override
    public boolean construible(ConstruiblePiso construiblePiso) {
        return construiblePiso.visitar(this);
    }
}
