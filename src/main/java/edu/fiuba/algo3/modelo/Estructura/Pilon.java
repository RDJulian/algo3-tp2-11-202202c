package edu.fiuba.algo3.modelo.Estructura;

import edu.fiuba.algo3.modelo.Construible.Construible;
import edu.fiuba.algo3.modelo.Construible.Costo;
import edu.fiuba.algo3.modelo.Construible.NoSobreRecurso;
import edu.fiuba.algo3.modelo.Construible.RangoPilon;
import edu.fiuba.algo3.modelo.EstadoEstructura.EnConstruccion;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Posicion.Rango;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Vida.Escudo;
import edu.fiuba.algo3.modelo.Vida.Normal;

public class Pilon extends Estructura {
    private Rango rango;

    public Pilon(Posicion posicion) {
        super(posicion);
        this.estado = new EnConstruccion(5);
        this.construible = new Construible(new NoSobreRecurso(), new RangoPilon(), new Costo(100, 0));
        this.rango = new Rango(posicion, 3);
        this.vida = new Normal(300);
        this.defensa = new Escudo(300);
    }

    @Override
    public Piso construible(Piso moho) {
        this.construible.construible(moho, this.posicion);
        return null;
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

    public boolean enRango(Posicion posicion) {
        this.estado.operar(this);
        return this.rango.incluye(posicion);
    }
}
