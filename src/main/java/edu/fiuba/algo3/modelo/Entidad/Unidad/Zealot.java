package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Entidad.Daniable;
import edu.fiuba.algo3.modelo.Entidad.TipoUnidad.UnidadTierra;
import edu.fiuba.algo3.modelo.EstadoEntidad.EnConstruccion;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Posicion.Rango;
import edu.fiuba.algo3.modelo.Vida.Escudo;
import edu.fiuba.algo3.modelo.Vida.Normal;

import java.util.Vector;

public class Zealot extends Unidad {

    protected int contadorDeBajas;
    public Zealot(Posicion posicion) {
        super(posicion);
        this.radioAtaque = 1;
        this.rangoAtaque = new Rango(this.posicion, this.radioAtaque);
        this.danioAire = 0;
        this.danioTierra = 8;
        this.tipoUnidad = new UnidadTierra();
        this.vida = new Normal(100);
        this.defensa = new Escudo(60);
        this.estadoEntidad = new EnConstruccion(4);
        this.invisible = false;
        this.contadorDeBajas = 0;
    }

    @Override
    public void atacar(Daniable daniable) {
        this.estadoEntidad.operable();
        daniable.daniar(this.danioTierra, this.danioAire, this.rangoAtaque, this);
    }

    public void sumarBaja (){
        contadorDeBajas = contadorDeBajas + 1;
        if (contadorDeBajas >= 3){
            this.invisible = true;
        }
    }

    public void revisarInvisibilidad(Vector<AmoSupremo> amosSupremos){
        for (AmoSupremo amoSupremo : amosSupremos){
            if(!amoSupremo.fueraDeRango(this.posicion)){
                this.invisible = false;
            }
        }
    }

}
