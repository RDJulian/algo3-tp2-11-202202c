package edu.fiuba.algo3.modelo.Estructura;

import edu.fiuba.algo3.modelo.Construible.Construible;
import edu.fiuba.algo3.modelo.EstadoEstructura.EstadoOperativo;
import edu.fiuba.algo3.modelo.Piso.Nada;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Reserva.Reserva;
import edu.fiuba.algo3.modelo.Vida.Defensa;
import edu.fiuba.algo3.modelo.Vida.Vida;

public abstract class Estructura {
    protected Posicion posicion;
    protected EstadoOperativo estado;
    protected Construible construible;
    protected Vida vida;
    protected Defensa defensa;

    public Estructura(Posicion posicion) {
        this.posicion = posicion;
    }

    public void setEstado(EstadoOperativo estado) {
        this.estado = estado;
    }

    public void pasarTurno() {
        this.estado.pasarTurno(this, this.vida, this.defensa);
    }

    public void operar() {
        this.estado.operar(this);
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
}