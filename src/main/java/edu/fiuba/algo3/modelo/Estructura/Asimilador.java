package edu.fiuba.algo3.modelo.Estructura;

import edu.fiuba.algo3.modelo.Construible.*;
import edu.fiuba.algo3.modelo.EstadoEstructura.EnConstruccion;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Reserva.Reserva;
import edu.fiuba.algo3.modelo.Vida.Escudo;
import edu.fiuba.algo3.modelo.Vida.Normal;

public class Asimilador extends Estructura {
    private Recurso gasVespeno;
    private Reserva reserva;

    public Asimilador(Posicion posicion) {
        super(posicion);
        this.estado = new EnConstruccion(6);
        this.construible = new Construible(new SobreGasVespeno(), new NoSobreMoho(), new Costo(100, 0));
        this.vida = new Normal(450);
        this.defensa = new Escudo(450);
    }

    public Asimilador(Posicion posicion, Reserva reserva) {
        super(posicion);
        this.estado = new EnConstruccion(6);
        this.construible = new Construible(new SobreGasVespeno(), new NoSobreMoho(), new Costo(100, 0));
        this.reserva = reserva;
        this.vida = new Normal(450);
        this.defensa = new Escudo(450);
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
