package edu.fiuba.algo3.modelo.Estructura;

import edu.fiuba.algo3.modelo.Construible.Construible;
import edu.fiuba.algo3.modelo.EstadoEntidad.EstadoEntidad;
import edu.fiuba.algo3.modelo.Posicion.Ocupada;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Unidad.Daniable;
import edu.fiuba.algo3.modelo.Vida.Defensa;
import edu.fiuba.algo3.modelo.Vida.Vida;

public abstract class Estructura implements Daniable {
    protected Posicion posicion;
    protected EstadoEntidad estadoEstructura;
    protected Vida vida;
    protected Defensa defensa;

    public Estructura(Posicion posicion) {
        this.posicion = posicion;
        posicion.setEstadoPosicion(new Ocupada());
    }

    public void operable() {
        this.estadoEstructura.operable();
    }

    //Este setter es indispensable por patron State.
    public void setEstado(EstadoEntidad estadoEstructura) {
        this.estadoEstructura = estadoEstructura;
    }

    //No todas las estructuras hacen algo al pasar el turno, pero todas se regeneran, por lo que todas deberian definir este metodo
    public void pasarTurno() {
        this.estadoEstructura.pasarTurno(this, this.vida, this.defensa);
    }

    //Segregar este metodo a una interfaz/Strategy, no todas hacen realmente algo al pasar turno.
    public abstract void pasarTurnoOperativo();

    @Override
    public void daniar(int danioTierra, int danioAire) {
        this.defensa.proteger(this, this.vida, danioTierra);
    }

    public abstract void construible(Construible requiereOtraEstructura);

    //Getters
    public int getVida() {
        return this.vida.getVida();
    }

    public int getDefensa() {
        return this.defensa.getDefensa();
    }
}