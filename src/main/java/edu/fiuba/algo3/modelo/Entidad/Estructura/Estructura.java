package edu.fiuba.algo3.modelo.Entidad.Estructura;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Entidad.Entidad;
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

public abstract class Estructura extends Entidad {
    @Override
    public void daniar(int danioTierra, int danioAire, Posicion posicionAtacante, int rangoAtaque) {
        estadoEntidad.atacable();
        if (danioTierra == 0 || !posicion.enRango(posicionAtacante, rangoAtaque)) {
            throw new AtaqueNoValidoException();
        }
        defensa.proteger(this, vida, danioTierra);
    }

    @Override
    public void daniar(int danioTierra, int danioAire, Rango rangoAtaque, Zealot unidadAtacante) {
        this.estadoEstructura.atacable();
        if (danioTierra == 0) {
            throw new AtaqueNoValidoException();
        }
        if (rangoAtaque.noIncluye(this.posicion)) {
            throw new AtaqueNoValidoException();
        }
        this.defensa.proteger(this, this.vida, danioTierra, unidadAtacante);
    }

    public abstract void construible(Construible requiereOtraEstructura);
}