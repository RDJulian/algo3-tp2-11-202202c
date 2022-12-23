package edu.fiuba.algo3.modelo.Area.EstadoPiso;

import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.ConstruiblePiso;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Energia.EstadoEnergia.EstadoEnergia;

public class TieneEnergiaPilon implements EstadoPiso {
    @Override
    public boolean construible(ConstruiblePiso construiblePiso) {
        return construiblePiso.visitar(this);
    }

    @Override
    public EstadoEnergia energizar(EstadoEnergia estadoEnergia) {
        return estadoEnergia.energizar();
    }

    @Override
    public EstadoPiso energizar() {
        return this;
    }

    @Override
    public EstadoPiso cubrirConMoho() {
        return new TieneMoho();
    }

    @Override
    public EstadoPiso limpiar() {
        return new EstadoPisoNull();
    }

    @Override
    public String getNombre() {
        return "pilon";
    }
}
