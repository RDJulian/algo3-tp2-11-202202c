package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Entidad.EjecutarAlPasarTurno.Nada;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.UnidadTierra;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EnConstruccion;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.RolEnSuministro.Consumidor;
import edu.fiuba.algo3.modelo.Vida.Escudo;
import edu.fiuba.algo3.modelo.Vida.Normal;

import java.util.Vector;

public class Zealot extends Unidad {

    protected int contadorDeBajas;

    public Zealot(Posicion posicion) {
        this.posicion = posicion;
        this.estadoEntidad = new EnConstruccion(4);
        this.accionAlPasarTurno = new Nada();
        this.rolEnSuministro = new Consumidor(2);
        this.vida = new Normal(100);
        this.defensa = new Escudo(60);

        this.tipoUnidad = new UnidadTierra();
        this.danioTierra = 8;
        this.danioAire = 0;
        this.rangoAtaque = 1;
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
