package edu.fiuba.algo3.modelo.Entidad.Comando;

import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoInvisibilidad.EstadoInvisibilidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Ataque.Ataque;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.TipoUnidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

public class RecibirAtaqueUnidad implements Comando {
    private Entidad entidad;
    private Ataque ataque;
    private TipoUnidad tipoUnidad;
    private Posicion posicion;

    private Unidad atacante;

    public RecibirAtaqueUnidad(Entidad entidad, Ataque ataque, TipoUnidad tipoUnidad, Posicion posicionObjetivo, Unidad atacante) {
        this.entidad = entidad;
        this.ataque = ataque;
        this.tipoUnidad = tipoUnidad;
        this.posicion = posicionObjetivo;
        this.atacante = atacante;
    }

    @Override
    public void ejecutar() {
        int danioARecibir = ataque.calcularDanio(tipoUnidad, posicion);
        entidad.daniar(danioARecibir, atacante);
    }
}
