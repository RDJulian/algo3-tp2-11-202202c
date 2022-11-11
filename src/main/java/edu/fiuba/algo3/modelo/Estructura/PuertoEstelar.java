package edu.fiuba.algo3.modelo.Estructura;

import edu.fiuba.algo3.modelo.Construible.Construible;
import edu.fiuba.algo3.modelo.Construible.NoSobreRecurso;
import edu.fiuba.algo3.modelo.Construible.RangoPilon;
import edu.fiuba.algo3.modelo.EstadoEstructura.EnConstruccion;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Recurso.Recurso;

public class PuertoEstelar extends Estructura {

    public PuertoEstelar(Posicion posicion) {
        super(posicion);
        this.estado = new EnConstruccion(10);
        this.construible = new Construible(new NoSobreRecurso(), new RangoPilon());
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
