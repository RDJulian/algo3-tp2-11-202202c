package edu.fiuba.algo3.modelo.Estructura;

import edu.fiuba.algo3.modelo.Construible.*;
import edu.fiuba.algo3.modelo.EstadoEstructura.Activo;
import edu.fiuba.algo3.modelo.EstadoEstructura.EnConstruccion;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Vida.SinEscudo;

public class Espiral extends Estructura {

    public Espiral() {
        this.estadoOperativo = new EnConstruccion(10);
        this.estadoEnergetico = new Activo();
        this.construible = new Construible(new NoSobreRecurso(), new RangoMoho(), new Costo(150, 100), new RequiereGuarida());
        this.vida = new Regenerativa(1300);
        this.defensa = new SinEscudo();
    }

    @Override
    public void efectuarOperacion() {

    }

    @Override
    public void pasarTurnoOperativo() {
    }

    @Override
    public void construir(Recurso recurso) {

    }

    @Override
    public void construirConOtraEstructura(RequiereOtraEstructura requiereOtraEstructura) {
        requiereOtraEstructura.construibleConEspiral();
    }
}