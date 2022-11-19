package edu.fiuba.algo3.modelo.Estructura;

import edu.fiuba.algo3.modelo.Construible.*;
import edu.fiuba.algo3.modelo.EstadoEstructura.EnConstruccion;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Recurso.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Reserva.Reserva;
import edu.fiuba.algo3.modelo.Vida.Escudo;
import edu.fiuba.algo3.modelo.Vida.Normal;

public class NexoMineral extends Estructura implements ExtraeRecurso {
    private Recurso mineral;
    private Reserva reservaMineral;

    public NexoMineral(Posicion posicion, Recurso mineral, Reserva reservaMineral) {
        super(posicion);
        this.mineral = mineral;
        mineral.ocupar(this);
        this.reservaMineral = reservaMineral;
        this.estadoEstructura = new EnConstruccion(4);
        this.vida = new Normal(250);
        this.defensa = new Escudo(250);
    }

    @Override
    public void pasarTurnoOperativo() {
        mineral.extraerRecurso(20, this.reservaMineral, this); //Asumimos 20.
    }


    //Creo este metodo para setear la reserva por ahora
    public void setReserva(Reserva reserva) {
        this.reservaMineral = reserva;
    }

    @Override
    public void construible(RequiereOtraEstructura requiereOtraEstructura) {
        requiereOtraEstructura.manejar(NexoMineral.class);
    }
}
