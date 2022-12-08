package edu.fiuba.algo3.modelo.Entidad.Comando;

import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Ataque.Ataque;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.TipoUnidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

public class RecibirAtaqueEstructura implements Comando {
    private Entidad entidad;
    private Ataque ataque;
    private Posicion posicion;
    private Unidad atacante;

    public RecibirAtaqueEstructura(Entidad entidad, Ataque ataque, Posicion posicionObjetivo, Unidad atacante) {
        this.entidad = entidad;
        this.ataque = ataque;
        this.posicion = posicionObjetivo;
        this.atacante = atacante;
    }

    @Override
    public void ejecutar() {
        int danioARecibir = ataque.calcularDanio(posicion);
        entidad.daniar(danioARecibir, atacante);
    }
}

