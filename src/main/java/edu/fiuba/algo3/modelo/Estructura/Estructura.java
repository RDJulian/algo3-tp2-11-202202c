package edu.fiuba.algo3.modelo.Estructura;

import edu.fiuba.algo3.modelo.Construible.RequiereOtraEstructura;
import edu.fiuba.algo3.modelo.EstadoEstructura.EstadoEstructura;
import edu.fiuba.algo3.modelo.Piso.Moho;
import edu.fiuba.algo3.modelo.Posicion.Ocupada;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Unidad.Daniable;
import edu.fiuba.algo3.modelo.Vida.Defensa;
import edu.fiuba.algo3.modelo.Vida.Vida;

public abstract class Estructura implements Daniable {
    protected Posicion posicion;
    protected EstadoEstructura estadoEstructura;
    protected Vida vida;
    protected Defensa defensa;

    public Estructura(Posicion posicion) {
        this.posicion = posicion;
        posicion.setEstadoPosicion(new Ocupada());
    }

    public void operable() {
        this.estadoEstructura.operable();
    }

    public void setEstado(EstadoEstructura estadoEstructura) {
        this.estadoEstructura = estadoEstructura;
    }

    //No todas las estructuras hacen algo al pasar el turno, pero todas se regeneran, por lo que todas deberian definir este metodo
    public void pasarTurno() {
        this.estadoEstructura.pasarTurno(this, this.vida, this.defensa);
    }

    public abstract void pasarTurnoOperativo();

    public void daniar(int danio) {
        this.defensa.proteger(this, this.vida, danio);
    }

    public void expandible(Moho moho) {
        moho.expandibleSobre(this.posicion);
    }

    public abstract void construible(RequiereOtraEstructura requiereOtraEstructura);

    //Getters
    public int getVida() {
        return this.vida.getVida();
    }

    public int getDefensa() {
        return this.defensa.getDefensa();
    }
}