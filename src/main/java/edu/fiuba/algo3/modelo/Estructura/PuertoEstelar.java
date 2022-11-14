package edu.fiuba.algo3.modelo.Estructura;

import edu.fiuba.algo3.modelo.Construible.Construible;
import edu.fiuba.algo3.modelo.Construible.Costo;
import edu.fiuba.algo3.modelo.Construible.NoSobreRecurso;
import edu.fiuba.algo3.modelo.Construible.RangoPilon;
import edu.fiuba.algo3.modelo.EstadoEstructura.Activo;
import edu.fiuba.algo3.modelo.EstadoEstructura.EnConstruccion;
import edu.fiuba.algo3.modelo.EstadoEstructura.EstadoEnergetico;
import edu.fiuba.algo3.modelo.EstadoEstructura.SinEnergia;
import edu.fiuba.algo3.modelo.Piso.Nada;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Vida.Escudo;
import edu.fiuba.algo3.modelo.Vida.Normal;

import java.util.Vector;

public class PuertoEstelar extends Estructura {

    public PuertoEstelar() {
        this.estadoOperativo = new EnConstruccion(10);
        this.estadoEnergetico = new SinEnergia();
        this.construible = new Construible(new NoSobreRecurso(), new RangoPilon(), new Costo(150, 150));
        this.vida = new Normal(600);
        this.defensa = new Escudo(600);
    }

    @Override
    public Piso construible(Piso piso) {
        this.construible.construible(piso, this.posicion);
        this.estadoEnergetico = new Activo();
        return new Nada();
    }

    public void setEstadoEnergetico(Vector<Pilon> pilones) {
        EstadoEnergetico estadoACambiar = new SinEnergia();
        for (Pilon pilon : pilones) {
            if (!pilon.fueraDeRango(this.posicion)) {
                estadoACambiar = new Activo();
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
