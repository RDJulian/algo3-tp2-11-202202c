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

public class Acceso extends Estructura {
    private EstadoEnergetico estadoEnergetico;

    public Acceso(Posicion posicion) {
        super(posicion);
        this.estado = new EnConstruccion(8);
        this.estadoEnergetico = new SinEnergia();
        this.construible = new Construible(new NoSobreRecurso(), new RangoPilon(), new Costo(150, 0));
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