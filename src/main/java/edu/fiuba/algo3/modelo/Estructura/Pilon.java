package edu.fiuba.algo3.modelo.Estructura;

import edu.fiuba.algo3.modelo.Construible.*;
import edu.fiuba.algo3.modelo.EstadoEstructura.Activo;
import edu.fiuba.algo3.modelo.EstadoEstructura.EnConstruccion;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Posicion.Ocupada;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Posicion.Rango;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Vida.Escudo;
import edu.fiuba.algo3.modelo.Vida.Normal;

public class Pilon extends Estructura implements Piso {
    private Rango rango;

    public Pilon() {
        this.estadoOperativo = new EnConstruccion(5);
        this.estadoEnergetico = new Activo(); //Supuesto
        this.construible = new Construible(new NoSobreRecurso(), new RangoPilon(), new Costo(100, 0), new NoRequiereOtra());
        this.vida = new Normal(300);
        this.defensa = new Escudo(300);
    }

    @Override
    public void construible(Posicion posicion) {
        posicion.ocupable();
        posicion.setEstadoPosicion(new Ocupada());
        this.posicion = posicion;
        this.rango = new Rango(posicion, 3);
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

    public boolean fueraDeRango(Posicion posicion) {
        this.estadoOperativo.operar(this);
        return this.rango.noIncluye(posicion);
    }

    @Override
    public void construible(ConstruibleSobreRango sobreRango) {
        sobreRango.construirEnPilon();
    }

    @Override
    public void construirConOtraEstructura(RequiereOtraEstructura requiereOtraEstructura) {
        requiereOtraEstructura.construibleConPilon();
    }
}
