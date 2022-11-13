package edu.fiuba.algo3.modelo.Estructura;

import edu.fiuba.algo3.modelo.Construible.Construible;
import edu.fiuba.algo3.modelo.EstadoEstructura.EstadoEnergetico;
import edu.fiuba.algo3.modelo.EstadoEstructura.EstadoOperativo;
import edu.fiuba.algo3.modelo.Piso.Moho;
import edu.fiuba.algo3.modelo.Piso.Nada;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Posicion.Ocupada;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Reserva.Reserva;
import edu.fiuba.algo3.modelo.Vida.Defensa;
import edu.fiuba.algo3.modelo.Vida.Vida;

public abstract class Estructura {
    protected Posicion posicion;
    protected EstadoOperativo estadoOperativo;
    protected EstadoEnergetico estadoEnergetico;
    protected Construible construible;
    protected Vida vida;
    protected Defensa defensa;

    public void setEstadoOperativo(EstadoOperativo estadoOperativo) {
        this.estadoOperativo = estadoOperativo;
    }

    public void setEstadoEnergetico(EstadoEnergetico estadoEnergetico) {
        this.estadoEnergetico = estadoEnergetico;
    }

    public void pasarTurno() {
        this.estadoEnergetico.pasarTurno(this, this.estadoOperativo, this.vida, this.defensa);
    }

    public void operar() {
        this.estadoEnergetico.operar(this, this.estadoOperativo);
    }

    public void construible(Recurso recurso) {
        this.construible.construible(recurso);
        this.construir(recurso);
    }

    public Piso construible(Piso piso) {
        this.construible.construible(piso, this.posicion);
        return new Nada();
    }

    public void construible(Reserva reservaMineral, Reserva reservaGas) {
        this.construible.construible(reservaMineral, reservaGas);
    }

    public void construible(Posicion posicion) {
        posicion.ocupable();
        posicion.setEstadoPosicion(new Ocupada());
        this.posicion = posicion;
    }

    public abstract void efectuarOperacion();

    public abstract void pasarTurnoOperativo();

    public abstract void construir(Recurso recurso);

    public void daniar(int danio) {
        this.defensa.proteger(this, this.vida, danio);
    }

    public int getVida() {
        return this.vida.getVida();
    }

    public int getDefensa() {
        return this.defensa.getDefensa();
    }

    public Posicion getPosicion() {
        return this.posicion;
    }

    public void expandible(Moho moho) {
        moho.expandibleSobre(this.posicion);
    }
}