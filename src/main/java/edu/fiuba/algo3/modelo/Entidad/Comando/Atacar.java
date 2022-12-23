package edu.fiuba.algo3.modelo.Entidad.Comando;

import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Ataque.Ataque;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Raza;

public class Atacar implements Comando {
    private Ataque ataque;
    private Entidad objetivo;
    private Area areaAtacante;

    private Raza razaAtacante;

    public Atacar(Ataque ataque, Entidad objetivo, Area areaAtacante, Raza razaAtacante) {
        this.ataque = ataque;
        this.objetivo = objetivo;
        this.areaAtacante = areaAtacante;
        this.razaAtacante = razaAtacante;
    }

    @Override
    public void ejecutar() {
        ataque.atacar(objetivo, areaAtacante, razaAtacante);
    }
}
