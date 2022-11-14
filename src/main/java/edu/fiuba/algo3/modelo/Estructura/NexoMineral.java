package edu.fiuba.algo3.modelo.Estructura;

import edu.fiuba.algo3.modelo.Construible.*;
import edu.fiuba.algo3.modelo.EstadoEstructura.Activo;
import edu.fiuba.algo3.modelo.EstadoEstructura.EnConstruccion;
import edu.fiuba.algo3.modelo.Recurso.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Reserva.Reserva;
import edu.fiuba.algo3.modelo.Vida.Escudo;
import edu.fiuba.algo3.modelo.Vida.Normal;

public class NexoMineral extends Estructura implements ExtraeRecurso {
    private Recurso mineral;
    private Reserva reserva;

    public NexoMineral() {
        this.estadoOperativo = new EnConstruccion(4);
        this.estadoEnergetico = new Activo();
        this.construible = new Construible(new SobreMineral(), new NoSobreMoho(), new Costo(50, 0), new NoRequiereOtra());
        this.vida = new Normal(250);
        this.defensa = new Escudo(250);
    }

    @Override
    public void efectuarOperacion() {

    }

    @Override
    public void pasarTurnoOperativo() {
        mineral.extraerRecurso(20, this.reserva, this); //Asumimos 20.
    }

    @Override
    public void construir(Recurso recurso) {
        recurso.ocupable(this);
        this.mineral = recurso;
    }

    //Creo este metodo para setear la reserva por ahora
    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    @Override
    public void construirConOtraEstructura(RequiereOtraEstructura requiereOtraEstructura) {
        requiereOtraEstructura.construibleConNexoMineral();
    }
}
