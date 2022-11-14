package edu.fiuba.algo3.modelo.Estructura;

import edu.fiuba.algo3.modelo.Construible.*;
import edu.fiuba.algo3.modelo.EstadoEstructura.Activo;
import edu.fiuba.algo3.modelo.EstadoEstructura.EnConstruccion;
import edu.fiuba.algo3.modelo.EstadoEstructura.SinEnergia;
import edu.fiuba.algo3.modelo.Piso.Nada;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Vida.Escudo;
import edu.fiuba.algo3.modelo.Vida.Normal;

public class Acceso extends Estructura {

    public Acceso() {
        this.estadoOperativo = new EnConstruccion(8);
        this.estadoEnergetico = new SinEnergia();
        this.construible = new Construible(new NoSobreRecurso(), new RangoPilon(), new Costo(150, 0), new NoRequiereOtra());
        this.vida = new Normal(500);
        this.defensa = new Escudo(500);
    }

    @Override
    public Piso construiblePiso(Piso piso) {
        this.construible.construible(piso, this.posicion);
        this.estadoEnergetico = new Activo();
        return new Nada();
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
        requiereOtraEstructura.construibleConAcceso();
    }
}