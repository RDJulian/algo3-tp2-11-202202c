package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.EstadoEntidad.EnConstruccion;
import edu.fiuba.algo3.modelo.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Vida.SinEscudo;

public class Mutalisco extends Unidad {
    public Mutalisco() {
        this.danioAire = 9;
        this.danioTierra = 9;
        this.tipoUnidad = new UnidadAire();
        this.vida = new Regenerativa(120);
        this.defensa = new SinEscudo();
        this.estadoEstructura = new EnConstruccion(7);
    }
}