package edu.fiuba.algo3.modelo.Estructura;

import edu.fiuba.algo3.modelo.Construible.*;
import edu.fiuba.algo3.modelo.EstadoEstructura.EnConstruccion;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Vida.Regenerativa;
import edu.fiuba.algo3.modelo.Vida.SinEscudo;

public class Espiral extends Estructura {
    public Espiral(Posicion posicion) {
        super(posicion);
        this.estadoEstructura = new EnConstruccion(10);
        this.vida = new Regenerativa(1300);
        this.defensa = new SinEscudo();
    }

    @Override
    public void pasarTurnoOperativo() {
    }


    @Override
    public void construible(RequiereOtraEstructura requiereOtraEstructura) {
        requiereOtraEstructura.manejar(Espiral.class);
    }
}