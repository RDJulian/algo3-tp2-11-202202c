package edu.fiuba.algo3.modelo.Estructura;

import edu.fiuba.algo3.modelo.Construible.*;
import edu.fiuba.algo3.modelo.Energizado.ConEnergia;
import edu.fiuba.algo3.modelo.Energizado.Energizado;
import edu.fiuba.algo3.modelo.EstadoEntidad.EnConstruccion;
import edu.fiuba.algo3.modelo.MementoEstructura.Memento;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Vida.Escudo;
import edu.fiuba.algo3.modelo.Vida.Normal;

import java.util.Vector;

public class Acceso extends Estructura implements UsaMemento {
    private Memento memento;
    private Energizado energizado;

    public Acceso(Posicion posicion) {
        super(posicion);
        this.estadoEstructura = new EnConstruccion(8);
        this.vida = new Normal(500);
        this.defensa = new Escudo(500);
        this.energizado = new ConEnergia();
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
        this.memento = new Memento(this.estadoEstructura);
    }

    @Override
    public void restaurarEstado() {
        this.memento.restaurar(this);
    }

    //Puede cambiar el parametro.
    @Override
    public void setEstado(Energizado energizado) {
        this.energizado = energizado;
    }

    public void setEstado(Vector<Pilon> pilones) {
        this.energizado.cambiarEnergia(this, energizado(pilones));
    }

    @Override
    public void pasarTurnoOperativo() {
    }

    @Override
    public void construible(Construible requiereOtraEstructura) {
        requiereOtraEstructura.manejar(Acceso.class);
    }
}