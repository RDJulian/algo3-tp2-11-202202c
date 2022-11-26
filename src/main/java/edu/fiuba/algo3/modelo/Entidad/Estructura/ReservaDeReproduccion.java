package edu.fiuba.algo3.modelo.Entidad.Estructura;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Entidad.EjecutarAlPasarTurno.Nada;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EnConstruccion;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.RolEnSuministro.Neutral;
import edu.fiuba.algo3.modelo.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Vida.SinEscudo;

public class ReservaDeReproduccion extends Estructura {

    public ReservaDeReproduccion(Posicion posicion) {
        this.posicion = posicion;
        posicion.ocupar();

        this.estadoEntidad = new EnConstruccion(12);
        this.accionAlPasarTurno = new Nada();
        this.vida = new Regenerativa(1000);
        this.defensa = new SinEscudo();

        this.rolEnSuministro = new Neutral();
    }

    @Override
    public void construible(ConstruibleEstructura requiereOtraEstructura) {
        requiereOtraEstructura.visitar(this);
        operable();
    }
}
