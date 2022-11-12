package edu.fiuba.algo3.modelo.Estructura;

import edu.fiuba.algo3.modelo.Construible.Construible;
import edu.fiuba.algo3.modelo.Construible.Costo;
import edu.fiuba.algo3.modelo.Construible.NoSobreRecurso;
import edu.fiuba.algo3.modelo.Construible.RangoPilon;
import edu.fiuba.algo3.modelo.EstadoEstructura.ConEnergia;
import edu.fiuba.algo3.modelo.EstadoEstructura.EnConstruccion;
import edu.fiuba.algo3.modelo.EstadoEstructura.EstadoEnergetico;
import edu.fiuba.algo3.modelo.EstadoEstructura.SinEnergia;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Vida.Escudo;
import edu.fiuba.algo3.modelo.Vida.Normal;

public class Acceso extends Estructura {
    private EstadoEnergetico estadoEnergetico;

    public Acceso(Posicion posicion) {
        super(posicion);
        this.estado = new EnConstruccion(8);
        this.estadoEnergetico = new SinEnergia();
        this.construible = new Construible(new NoSobreRecurso(), new RangoPilon(), new Costo(150, 0));
        this.vida = new Normal(500);
        this.defensa = new Escudo(500);
    }

    @Override
    public void operar() {
        this.estadoEnergetico.operar(this, this.estado);
    }

    @Override
    public void pasarTurno() {
        this.estadoEnergetico.pasarTurno(this, this.estado, this.vida, this.defensa);
    }

    @Override
    public void construible(Pilon pilon) {
        this.construible.construible(pilon, this.posicion);
        this.estadoEnergetico = new ConEnergia();
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
}