package edu.fiuba.algo3.modelo.Estructura;

import edu.fiuba.algo3.modelo.Construible.Construible;
import edu.fiuba.algo3.modelo.Construible.NoSobreRecurso;
import edu.fiuba.algo3.modelo.Construible.RangoPilon;
import edu.fiuba.algo3.modelo.EstadoEstructura.EnConstruccion;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Posicion.Rango;
import edu.fiuba.algo3.modelo.Recurso.Recurso;

public class Pilon extends Estructura {
    private Rango rango;

    public Pilon(Posicion posicion) {
        super(posicion);
        this.estado = new EnConstruccion(5);
        this.construible = new Construible(new NoSobreRecurso(), new RangoPilon());
        this.rango = new Rango(posicion, 3);
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

    public void enRango(Posicion posicion) {
        this.rango.incluye(posicion);
    }
}
