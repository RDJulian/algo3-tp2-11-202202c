package edu.fiuba.algo3.modelo.Entidad.Comando;

import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Ataque.Ataque;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.TipoUnidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;

public class RecibirAtaqueUnidad implements Comando {
    private Entidad entidad;
    private Ataque ataque;
    private TipoUnidad tipoUnidad;
    private Unidad atacante;

    public RecibirAtaqueUnidad(Entidad entidad, Ataque ataque, TipoUnidad tipoUnidad, Unidad atacante) {
        this.entidad = entidad;
        this.ataque = ataque;
        this.tipoUnidad = tipoUnidad;
        this.atacante = atacante;
    }

    @Override
    public void ejecutar() {
        int danioARecibir = ataque.calcularDanio(tipoUnidad);
        entidad.daniar(danioARecibir, atacante);
    }
}
