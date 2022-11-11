package edu.fiuba.algo3.modelo.Estructura;

import edu.fiuba.algo3.modelo.Construible.*;
import edu.fiuba.algo3.modelo.EstadoEstructura.EnConstruccion;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Recurso.Recurso;

public class NexoMineral extends Estructura {

    public NexoMineral(Posicion posicion) {
        super(posicion);
        this.estado = new EnConstruccion(4);
        this.construible = new Construible(new NoSobreRecurso(), new NoNecesitaRango());
    }

    @Override
    public void efectuarOperacion() {

    }

    @Override
    public void pasarTurnoOperativo() {

    }

    @Override
    public void construir(Recurso recurso) {

    }
}
