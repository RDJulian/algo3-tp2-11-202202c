package edu.fiuba.algo3.modelo.Estructura;

import edu.fiuba.algo3.modelo.Construible.*;
import edu.fiuba.algo3.modelo.EstadoEstructura.EnConstruccion;
import edu.fiuba.algo3.modelo.EstadoEstructura.EstadoEstructura;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Vida.Escudo;
import edu.fiuba.algo3.modelo.Vida.Normal;

import java.util.Vector;

public class PuertoEstelar extends Estructura implements Memento {
    private EstadoEstructura memento;

    public PuertoEstelar(Posicion posicion) {
        super(posicion);
        this.estadoEstructura = new EnConstruccion(10);
        this.vida = new Normal(600);
        this.defensa = new Escudo(600);
    }

    public boolean energizado(Vector<Pilon> pilones) {
        for (Pilon pilon : pilones) {
            if (!pilon.fueraDeRango(this.posicion)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void guardarEstado() {
        this.memento = this.estadoEstructura;
    }

    @Override
    public void restaurarEstado() {
        this.estadoEstructura = this.memento;
    }

    public void setEstado(Vector<Pilon> pilones) {
        this.estadoEstructura.cambiarEnergia(this, energizado(pilones));
    }

    @Override
    public void pasarTurnoOperativo() {
    }

    @Override
    public void construible(RequiereOtraEstructura requiereOtraEstructura) {
        requiereOtraEstructura.manejar(PuertoEstelar.class);
    }
}
