package edu.fiuba.algo3.modelo.Entidad.Comando;

import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Ataque.Ataque;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;

public class RecibirAtaqueEstructura implements Comando {
    private Entidad entidad;
    private Ataque ataque;
    private Unidad atacante;

    public RecibirAtaqueEstructura(Entidad entidad, Ataque ataque, Unidad atacante) {
        this.entidad = entidad;
        this.ataque = ataque;
        this.atacante = atacante;
    }

    @Override
    public void ejecutar() {
        int danioRecibido = ataque.calcularDanio();
        entidad.daniar(danioRecibido, atacante);
    }
}

