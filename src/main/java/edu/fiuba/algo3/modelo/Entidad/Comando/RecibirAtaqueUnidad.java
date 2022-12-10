package edu.fiuba.algo3.modelo.Entidad.Comando;

import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Ataque.Ataque;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.TipoUnidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Area.Area;

public class RecibirAtaqueUnidad implements Comando {
    private Entidad entidad;
    private Ataque ataque;
    private TipoUnidad tipoUnidad;
    private Area area;

    private Unidad atacante;

    public RecibirAtaqueUnidad(Entidad entidad, Ataque ataque, TipoUnidad tipoUnidad, Area areaObjetivo, Unidad atacante) {
        this.entidad = entidad;
        this.ataque = ataque;
        this.tipoUnidad = tipoUnidad;
        this.area = areaObjetivo;
        this.atacante = atacante;
    }

    @Override
    public void ejecutar() {
        int danioARecibir = ataque.calcularDanio(tipoUnidad, area);
        entidad.daniar(danioARecibir, atacante);
    }
}
