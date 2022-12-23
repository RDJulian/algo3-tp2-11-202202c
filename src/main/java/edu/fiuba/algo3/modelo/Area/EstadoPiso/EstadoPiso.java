package edu.fiuba.algo3.modelo.Area.EstadoPiso;

import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.ConstruiblePiso;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Energia.EstadoEnergia.EstadoEnergia;

public interface EstadoPiso {
    boolean construible(ConstruiblePiso construiblePiso);

    EstadoEnergia energizar(EstadoEnergia estadoEnergia);

    EstadoPiso energizar();

    EstadoPiso cubrirConMoho();

    EstadoPiso limpiar();

    String getNombre();
}
