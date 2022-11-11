package edu.fiuba.algo3.modelo.Estructura;

import edu.fiuba.algo3.modelo.Construible.*;
import edu.fiuba.algo3.modelo.EstadoEstructura.EnConstruccion;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Recurso.Recurso;

public class Asimilador extends Estructura {
    public Asimilador(Posicion posicion) {
        super(posicion);
        this.estado = new EnConstruccion(6);
        this.construible = new Construible(new SobreGasVespeno(), new NoNecesitaRango());
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
}
