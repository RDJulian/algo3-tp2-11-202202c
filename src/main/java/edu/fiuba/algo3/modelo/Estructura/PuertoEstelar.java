package edu.fiuba.algo3.modelo.Estructura;

import edu.fiuba.algo3.modelo.Construible.Construible;
import edu.fiuba.algo3.modelo.Construible.Costo;
import edu.fiuba.algo3.modelo.Construible.NoSobreRecurso;
import edu.fiuba.algo3.modelo.Construible.RangoPilon;
import edu.fiuba.algo3.modelo.EstadoEstructura.ConEnergia;
import edu.fiuba.algo3.modelo.EstadoEstructura.EnConstruccion;
import edu.fiuba.algo3.modelo.EstadoEstructura.EstadoEnergetico;
import edu.fiuba.algo3.modelo.EstadoEstructura.SinEnergia;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Recurso.Recurso;

import java.util.Vector;

public class PuertoEstelar extends Estructura {
    private EstadoEnergetico estadoEnergetico;

    public PuertoEstelar(Posicion posicion) {
        super(posicion);
        this.estado = new EnConstruccion(10);
        this.estadoEnergetico = new SinEnergia();
        this.construible = new Construible(new NoSobreRecurso(), new RangoPilon(), new Costo(150, 150));
    }

    @Override
    public void operar() {
        this.estadoEnergetico.operar(this, this.estado);
    }

    @Override
    public void pasarTurno() {
        this.estadoEnergetico.pasarTurno(this, this.estado);
    }

    @Override
    public void construible(Pilon pilon) {
        this.construible.construible(pilon, this.posicion);
        this.estadoEnergetico = new ConEnergia();
    }

    public void setEstadoEnergetico(Vector<Pilon> pilones) {
        EstadoEnergetico estadoACambiar = new SinEnergia();
        for (Pilon pilon : pilones) {
            if (pilon.enRango(this.posicion)) {
                estadoACambiar = new ConEnergia();
            }
        }
        this.estadoEnergetico = estadoACambiar;
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
