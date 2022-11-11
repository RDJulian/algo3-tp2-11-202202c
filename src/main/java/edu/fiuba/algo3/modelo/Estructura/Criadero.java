package edu.fiuba.algo3.modelo.Estructura;

import edu.fiuba.algo3.modelo.Construible.*;
import edu.fiuba.algo3.modelo.EstadoEstructura.EnConstruccion;
import edu.fiuba.algo3.modelo.Excepciones.CriaderoSinLarvas;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Recurso.Recurso;

public class Criadero extends Estructura {
    private int larvas;

    public Criadero(Posicion posicion) {
        super(posicion);
        this.estado = new EnConstruccion(4);
        this.construible = new Construible(new NoSobreRecurso(), new NoNecesitaRango(), new Costo(50, 0));
        this.larvas = 3;
    }

    @Override
    public void efectuarOperacion() {
        if (this.larvas == 0) {
            throw new CriaderoSinLarvas();
        }
        this.larvas -= 1;
    }

    @Override
    public void pasarTurnoOperativo() {
        if (this.larvas < 3) {
            this.larvas += 1;
        }
    }

    @Override
    public void construir(Recurso recurso) {

    }
}