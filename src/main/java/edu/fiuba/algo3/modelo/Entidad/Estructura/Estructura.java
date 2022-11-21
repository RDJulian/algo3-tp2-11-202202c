package edu.fiuba.algo3.modelo.Entidad.Estructura;

import edu.fiuba.algo3.modelo.Construible.Construible;
import edu.fiuba.algo3.modelo.EjecutarAlPasarTurno.Ejecutar;
import edu.fiuba.algo3.modelo.Entidad.Daniable;
import edu.fiuba.algo3.modelo.EstadoEntidad.EstadoEntidad;
import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoValidoException;
import edu.fiuba.algo3.modelo.Posicion.Ocupada;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Posicion.Rango;
import edu.fiuba.algo3.modelo.Vida.Defensa;
import edu.fiuba.algo3.modelo.Vida.Vida;

public abstract class Estructura implements Daniable {
    //Tanto las estructuras como las Unidades tienen comportamientos muy similares y atributos compartidos.
    //Quiza se puede fusionar en una clase Entidad.
    protected Posicion posicion;
    protected EstadoEntidad estadoEstructura;
    protected Ejecutar accionAlPasarTurno;
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

    //No todas las estructuras hacen algo al pasar el turno, pero todas varian su vida/escudo, por lo que todas usan este metodo.
    public void pasarTurno() {
        this.estadoEstructura.pasarTurno(this, this.accionAlPasarTurno, this.vida, this.defensa);
    }

    @Override
    public void daniar(int danioTierra, int danioAire, Rango rangoAtaque) {
        this.estadoEstructura.atacable();
        if (danioTierra == 0) {
            throw new AtaqueNoValidoException();
        }
        if (rangoAtaque.noIncluye(this.posicion)) {
            throw new AtaqueNoValidoException();
        }
        this.defensa.proteger(this, this.vida, danioTierra);
    }

    //Construible deberia llamar a operable(), sino no tiene sentido que habilite!
    public abstract void construible(Construible requiereOtraEstructura);
}