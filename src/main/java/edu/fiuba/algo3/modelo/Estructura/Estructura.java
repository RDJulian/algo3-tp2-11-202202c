package edu.fiuba.algo3.modelo.Estructura;

import edu.fiuba.algo3.modelo.Construible.Construible;
import edu.fiuba.algo3.modelo.Construible.RequiereOtraEstructura;
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

    public int getVida() {
        return this.vida.getVida();
    }

    public int getDefensa() {
        return this.defensa.getDefensa();
    }

    public void pasarTurno() {
        this.estadoEnergetico.pasarTurno(this, this.estadoOperativo, this.vida, this.defensa);
    }

    //Capaz operar deberia ser operable, que sea una consulta mas que otra cosa.
    //Hay estructuras que en realidad no operan. Capaz este metodo, si la estructura esta operativa,
    //Puede mandar un mensaje a algun tipo de objeto que maneje los comportamientos particulares.
    //Eso tambien puede traer sus problemas porque hay estructuras que devuelven Moho, Unidades, etc.
    public void operar() {
        this.estadoEnergetico.operar(this, this.estadoOperativo);
    }


    //Todos los metodos del tipo construible no deberian ser polimorficos por naturaleza
    //Se les esta pasando a cada uno un parametro distinto, deberian tener nombres distintos para no
    //Entrar en problemas.
    public void construible(Recurso recurso) {
        this.construible.construible(recurso);
        this.construir(recurso);
    }

    public Piso construiblePiso(Piso piso) {
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

    public void construible(Estructura estructura) {
        this.construible.construible(estructura);
    }

    public abstract void efectuarOperacion();

    public abstract void pasarTurnoOperativo();

    public abstract void construir(Recurso recurso);

    public void daniar(int danio) {
        this.defensa.proteger(this, this.vida, danio);
    }

    public void expandible(Moho moho) {
        moho.expandibleSobre(this.posicion);
    }

    public abstract void construirConOtraEstructura(RequiereOtraEstructura requiereOtraEstructura);
}