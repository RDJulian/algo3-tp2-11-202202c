package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.UnidadTierra;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EnConstruccion;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.RolEnSuministro.Consumidor;
import edu.fiuba.algo3.modelo.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Vida.SinEscudo;

public class Zerling extends Unidad {
    public Zerling(Posicion posicion, Raza raza) {
        this.posicion = posicion;
        this.estadoEntidad = new EnConstruccion(2);
        this.rolEnSuministro = new Consumidor(1);
        this.vida = new Regenerativa(35);
        this.defensa = new SinEscudo();
        this.raza = raza;

        this.tipoUnidad = new UnidadTierra();
        this.danioTierra = 4;
        this.danioAire = 0;
        this.rangoAtaque = 1;
        this.invisible = false;
        this.contadorDeBajas = 0;
    }
}
