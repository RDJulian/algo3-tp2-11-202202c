package edu.fiuba.algo3.modelo.Estructura;

import edu.fiuba.algo3.modelo.Construible.*;
import edu.fiuba.algo3.modelo.EstadoEstructura.Activo;
import edu.fiuba.algo3.modelo.EstadoEstructura.EnConstruccion;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Reserva.Reserva;
import edu.fiuba.algo3.modelo.Vida.Escudo;
import edu.fiuba.algo3.modelo.Vida.Normal;

public class Asimilador extends Estructura implements ExtraeRecurso {
    private Recurso gasVespeno;
    private Reserva reserva;

    public Asimilador() {
        this.estadoOperativo = new EnConstruccion(6);
        this.estadoEnergetico = new Activo();
        this.construible = new Construible(new SobreGasVespeno(), new NoSobreMoho(), new Costo(100, 0));
        this.vida = new Normal(450);
        this.defensa = new Escudo(450);
    }

    @Override
    public void efectuarOperacion() {

    }

    @Override
    public void pasarTurnoOperativo() {
        gasVespeno.extraerRecurso(20, this.reserva, this);
    }

    @Override
    public void construir(Recurso recurso) {
        recurso.ocupable(this);
        this.gasVespeno = recurso;
    }

    //Creo este metodo para setear la reserva por ahora
    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}
