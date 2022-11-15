package edu.fiuba.algo3.modelo.Unidad;

import edu.fiuba.algo3.modelo.EstadoEstructura.EnConstruccion;
import edu.fiuba.algo3.modelo.Vida.Escudo;
import edu.fiuba.algo3.modelo.Vida.Normal;

public class Zealot extends Unidad {
    public Zealot() {
        this.danioAire = 0;
        this.danioTierra = 8;
        this.tipoUnidad = new UnidadTierra();
        this.vida = new Normal(100);
        this.defensa = new Escudo(60);
        this.estadoOperativo = new EnConstruccion(4);
    }
}
