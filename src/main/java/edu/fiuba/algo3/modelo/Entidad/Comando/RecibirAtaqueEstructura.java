package edu.fiuba.algo3.modelo.Entidad.Comando;

import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Ataque.Ataque;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Area.Area;

public class RecibirAtaqueEstructura implements Comando {
    private Entidad entidad;
    private Ataque ataque;
    private Area area;
    private Unidad atacante;

    public RecibirAtaqueEstructura(Entidad entidad, Ataque ataque, Area areaObjetivo, Unidad atacante) {
        this.entidad = entidad;
        this.ataque = ataque;
        this.area = areaObjetivo;
        this.atacante = atacante;
    }

    @Override
    public void ejecutar() {
        int danioARecibir = ataque.calcularDanio(area);
        entidad.daniar(danioARecibir, atacante);
    }
}

