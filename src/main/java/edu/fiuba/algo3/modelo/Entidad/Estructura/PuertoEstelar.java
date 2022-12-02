package edu.fiuba.algo3.modelo.Entidad.Estructura;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EnConstruccion;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.SinEnergia;
import edu.fiuba.algo3.modelo.Entidad.Estructura.MementoEstructura.Memento;
import edu.fiuba.algo3.modelo.Entidad.Estructura.MementoEstructura.UsaMemento;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.RolEnSuministro.Neutral;
import edu.fiuba.algo3.modelo.Vida.Escudo;
import edu.fiuba.algo3.modelo.Vida.Normal;

import java.util.ArrayList;

public class PuertoEstelar extends EstructuraEnergizada {
    public PuertoEstelar(Posicion posicion, Raza raza) {
        this.posicion = posicion;
        posicion.ocupar();

        this.estadoEntidad = new EnConstruccion(10);
        this.rolEnSuministro = new Neutral();
        this.vida = new Normal(600);
        this.defensa = new Escudo(600);
        this.raza = raza;

        this.energia = new Energia();
    }

    @Override
    public void construible(ConstruibleEstructura requiereOtraEstructura) {
        requiereOtraEstructura.visitar(this);
        estadoEntidad.operable();
    }
}
