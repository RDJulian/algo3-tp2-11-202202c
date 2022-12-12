package edu.fiuba.algo3.modelo.Entidad.Comando;

import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Ataque.Ataque;
import edu.fiuba.algo3.modelo.Area.Area;

public class Atacar implements Comando {
    private Ataque ataque;
    private Entidad objetivo;
    private Area areaAtacante;

    public Atacar(Ataque ataque, Entidad objetivo, Area areaAtacante) {
        this.ataque = ataque;
        this.objetivo = objetivo;
        this.areaAtacante = areaAtacante;
    }

    @Override
    public void ejecutar() {
        ataque.atacar(objetivo, areaAtacante);
    }
}
