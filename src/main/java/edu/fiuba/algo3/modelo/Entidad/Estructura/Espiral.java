package edu.fiuba.algo3.modelo.Entidad.Estructura;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EnConstruccion;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.Visible;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.RolEnSuministro.Neutral;
import edu.fiuba.algo3.modelo.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Vida.SinEscudo;

public class Espiral extends Estructura {
    public Espiral(Posicion posicion, Raza raza) {
        this.posicion = posicion;
        posicion.ocupar();

        this.estadoOperativo = new EnConstruccion(10);
        this.estadoInvisibilidad = new Visible();
        this.rolEnSuministro = new Neutral();
        this.vida = new Regenerativa(1300);
        this.defensa = new SinEscudo();
        this.raza = raza;
    }

    @Override
    public void construible(ConstruibleEstructura requiereOtraEstructura) {
        requiereOtraEstructura.visitar(this);
        estadoOperativo.operable();
    }
}