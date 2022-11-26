package edu.fiuba.algo3.modelo.Entidad.Estructura;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Entidad.EjecutarAlPasarTurno.Nada;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.SinEnergia;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EnConstruccion;
import edu.fiuba.algo3.modelo.Entidad.Estructura.MementoEstructura.Memento;
import edu.fiuba.algo3.modelo.Entidad.Estructura.MementoEstructura.UsaMemento;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.RolEnSuministro.Neutral;
import edu.fiuba.algo3.modelo.Vida.Escudo;
import edu.fiuba.algo3.modelo.Vida.Normal;

import java.util.Vector;

public class Acceso extends Estructura implements UsaMemento {
    private Memento memento;
    private boolean energizado;

    public Acceso(Posicion posicion) {
        this.posicion = posicion;
        posicion.ocupar();

        this.estadoEntidad = new EnConstruccion(8);
        this.accionAlPasarTurno = new Nada();
        this.vida = new Normal(500);
        this.defensa = new Escudo(500);

        this.energizado = true;
        this.rolEnSuministro = new Neutral();
    }

    private boolean energizado(Vector<Pilon> pilones) {
        for (Pilon pilon : pilones) {
            if (!pilon.fueraDeRango(posicion)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void guardarEstado() {
        this.memento = new Memento(estadoEntidad);
    }

    @Override
    public void restaurarEstado() {
        this.estadoEntidad = memento.restaurar();
    }

    public void actualizarEstado(Vector<Pilon> pilones) {
        if (!energizado(pilones) && energizado) {
            guardarEstado();
            this.energizado = false;
            this.estadoEntidad = new SinEnergia();
        } else if (energizado(pilones) && !energizado) {
            restaurarEstado();
            this.energizado = true;
        }
    }

    @Override
    public void construible(ConstruibleEstructura requiereOtraEstructura) {
        requiereOtraEstructura.visitar(this);
        operable();
    }
}