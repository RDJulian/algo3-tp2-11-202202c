package edu.fiuba.algo3.modelo.Area.EstadoPiso;

import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.ConstruiblePiso;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Energia.EstadoEnergia.EstadoEnergia;

public class TieneMoho implements EstadoPiso {
    @Override
    public boolean construible(ConstruiblePiso construiblePiso) {
        return construiblePiso.visitar(this);
    }

    @Override
    public EstadoEnergia energizar(EstadoEnergia estadoEnergia) {
        return estadoEnergia.desenergizar();
    }

    @Override
    public EstadoPiso energizar() {
        return this;
    }

    @Override
    public EstadoPiso cubrirConMoho() {
        return this;
    }

    @Override
    public EstadoPiso limpiar() {
        return this;
    }
}
