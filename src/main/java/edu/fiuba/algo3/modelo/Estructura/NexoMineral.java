package edu.fiuba.algo3.modelo.Estructura;

import edu.fiuba.algo3.modelo.Construible.*;
import edu.fiuba.algo3.modelo.EstadoEstructura.EnConstruccion;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Reserva.Reserva;
import edu.fiuba.algo3.modelo.Vida.Escudo;
import edu.fiuba.algo3.modelo.Vida.Normal;

public class NexoMineral extends Estructura {
    private Recurso mineral;
    private Reserva reserva;

    public NexoMineral(Posicion posicion) {
        super(posicion);
        this.estado = new EnConstruccion(4);
        this.construible = new Construible(new SobreMineral(), new NoNecesitaRango(), new Costo(50, 0));
        this.vida = new Normal(250);
        this.defensa = new Escudo(250);
    }

    public NexoMineral(Posicion posicion, Reserva reserva) {
        super(posicion);
        this.estado = new EnConstruccion(4);
        this.construible = new Construible(new SobreMineral(), new NoNecesitaRango(), new Costo(50, 0));
        this.reserva = reserva;
        this.vida = new Normal(250);
        this.defensa = new Escudo(250);
    }

    @Override
    public void efectuarOperacion() {

    }

    @Override
    public void pasarTurnoOperativo() {
        mineral.extraerRecurso(20, this.reserva); //Asumimos 20.
    }

    @Override
    public void construir(Recurso recurso) {
        this.mineral = recurso;
    }
}
