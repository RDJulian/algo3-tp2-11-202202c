package edu.fiuba.algo3.modelo.Estructura;

import edu.fiuba.algo3.modelo.Construible.*;
import edu.fiuba.algo3.modelo.EstadoEstructura.EnConstruccion;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Recurso.ExtraeRecurso;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Reserva.Reserva;
import edu.fiuba.algo3.modelo.Vida.Escudo;
import edu.fiuba.algo3.modelo.Vida.Normal;

public class Asimilador extends Estructura implements ExtraeRecurso {
    private Recurso gasVespeno;
    private Reserva reservaGas;

    public Asimilador(Posicion posicion, Recurso gasVespeno, Reserva reservaGas) {
        super(posicion);
        this.gasVespeno = gasVespeno;
        gasVespeno.ocupar(this);
        this.reservaGas = reservaGas;
        this.estadoEstructura = new EnConstruccion(6);
        this.vida = new Normal(450);
        this.defensa = new Escudo(450);
    }

    @Override
    public void pasarTurnoOperativo() {
        gasVespeno.extraerRecurso(20, this.reservaGas, this);
    }


    //Creo este metodo para setear la reserva por ahora
    public void setReserva(Reserva reserva) {
        this.reservaGas = reserva;
    }

    @Override
    public void construible(RequiereOtraEstructura requiereOtraEstructura) {
        requiereOtraEstructura.manejar(Asimilador.class);
    }
}