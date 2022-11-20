package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.EstadoEntidad.EnConstruccion;
import edu.fiuba.algo3.modelo.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Vida.SinEscudo;

public class Zerling extends Unidad {
    public Zerling() {
        this.danioAire = 0;
        this.danioTierra = 4;
        this.tipoUnidad = new UnidadTierra();
        this.vida = new Regenerativa(35);
        this.defensa = new SinEscudo();
        this.estadoEstructura = new EnConstruccion(2);
    }
}
