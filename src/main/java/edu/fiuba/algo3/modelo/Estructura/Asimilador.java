package edu.fiuba.algo3.modelo.Estructura;

import edu.fiuba.algo3.modelo.Construible.*;
import edu.fiuba.algo3.modelo.EstadoEstructura.EnConstruccion;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Reserva.Reserva;

public class Asimilador extends Estructura {
    private Recurso gasVespeno;
    private Reserva reserva;

    public Asimilador(Posicion posicion) {
        super(posicion);
        this.estado = new EnConstruccion(6);
        this.construible = new Construible(new SobreGasVespeno(), new NoNecesitaRango(), new Costo(100, 0));
    }

    public Asimilador(Posicion posicion, Reserva reserva) {
        super(posicion);
        this.estado = new EnConstruccion(6);
        this.construible = new Construible(new SobreGasVespeno(), new NoNecesitaRango(), new Costo(100, 0));
        this.reserva = reserva;
    }

    @Override
    public void efectuarOperacion() {

    }

    @Override
    public void pasarTurnoOperativo() {
        gasVespeno.extraerRecurso(20, this.reserva);
    }

    @Override
    public void construir(Recurso recurso) {
        this.gasVespeno = recurso;
    }
}
