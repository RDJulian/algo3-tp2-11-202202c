package edu.fiuba.algo3.modelo.Entidad.Estructura;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo.EnConstruccion;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.Visible;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Entidad.Suministro.NoAfecta;
import edu.fiuba.algo3.modelo.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Vida.SinEscudo;

public class ReservaDeReproduccion extends Estructura {

    public ReservaDeReproduccion(Posicion posicion, Raza raza) {
        this.posicion = posicion;
        posicion.ocupar();

        this.estadoOperativo = new EnConstruccion(12);
        this.estadoInvisibilidad = new Visible();
        this.afectaSuministro = new NoAfecta();
        this.vida = new Regenerativa(1000);
        this.defensa = new SinEscudo();
        this.raza = raza;
    }
}
