package edu.fiuba.algo3.modelo.Estructura;

import edu.fiuba.algo3.modelo.Construible.*;
import edu.fiuba.algo3.modelo.EstadoEstructura.Activo;
import edu.fiuba.algo3.modelo.EstadoEstructura.EnConstruccion;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Vida.SinEscudo;

public class Guarida extends Estructura {
    public Guarida() {
        this.estadoOperativo = new EnConstruccion(12);
        this.estadoEnergetico = new Activo();
        this.construible = new Construible(new NoSobreRecurso(), new RangoMoho(), new Costo(200, 100), new RequiereReservaDeReproduccion());
        this.vida = new Regenerativa(1250);
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
        requiereOtraEstructura.construibleConGuarida();
    }
}
