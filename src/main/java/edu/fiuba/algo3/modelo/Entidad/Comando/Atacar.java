package edu.fiuba.algo3.modelo.Entidad.Comando;

import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Ataque.Ataque;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

public class Atacar implements Comando {
    private Ataque ataque;
    private Entidad objetivo;
    private Posicion posicionAtacante;

    public Atacar(Ataque ataque, Entidad objetivo, Posicion posicionAtacante) {
        this.ataque = ataque;
        this.objetivo = objetivo;
        this.posicionAtacante = posicionAtacante;
    }

    @Override
    public void ejecutar() {
        ataque.atacar(objetivo, posicionAtacante);
    }
}
