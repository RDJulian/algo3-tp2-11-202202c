package edu.fiuba.algo3.modelo.Unidad;

import edu.fiuba.algo3.modelo.EstadoEstructura.EnConstruccion;
import edu.fiuba.algo3.modelo.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Vida.SinEscudo;

public class Guardian extends Unidad {
    public Guardian() {
        this.danioAire = 0;
        this.danioTierra = 25;
        this.tipoUnidad = new UnidadAire();
        this.vida = new Regenerativa(100);
        this.defensa = new SinEscudo();
        this.estadoOperativo = new EnConstruccion(4);
    }
}
