package edu.fiuba.algo3.modelo.Estructura;

import edu.fiuba.algo3.modelo.Construible.Construible;
import edu.fiuba.algo3.modelo.Construible.NoSobreRecurso;
import edu.fiuba.algo3.modelo.EstadoEstructura.EnConstruccion;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

public class ReservaDeReproduccion extends Estructura {

    public ReservaDeReproduccion(Posicion posicion) {
        super(posicion);
        this.estado = new EnConstruccion(12);
        this.construible = new Construible(new NoSobreRecurso());
    }

    @Override
    public void efectuarOperacion() {

    }

    @Override
    public void pasarTurnoOperativo() {

    }
}
