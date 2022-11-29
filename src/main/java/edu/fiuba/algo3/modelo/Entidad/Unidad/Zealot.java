package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Entidad.EjecutarAlPasarTurno.Nada;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.UnidadTierra;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EnConstruccion;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.RolEnSuministro.Consumidor;
import edu.fiuba.algo3.modelo.Vida.Escudo;
import edu.fiuba.algo3.modelo.Vida.Normal;

import java.util.ArrayList;

public class Zealot extends Unidad {
    public Zealot(Posicion posicion, Raza raza) {
        this.posicion = posicion;
        this.estadoEntidad = new EnConstruccion(4);
        this.accionAlPasarTurno = new Nada();
        this.rolEnSuministro = new Consumidor(2);
        this.vida = new Normal(100);
        this.defensa = new Escudo(60);
        this.raza = raza;

        this.tipoUnidad = new UnidadTierra();
        this.danioTierra = 8;
        this.danioAire = 0;
        this.rangoAtaque = 1;
        this.invisible = false;
        this.contadorDeBajas = 0;
    }

    //Revisar esta solucion. No contempla el caso en el que vuelva a la invisibilidad. Pensar supuesto.
    public void revisarInvisibilidad(ArrayList<AmoSupremo> amosSupremos) {
        for (AmoSupremo amoSupremo : amosSupremos) {
            if (!amoSupremo.fueraDeRango(this.posicion)) {
                this.invisible = false;
            }
        }
    }

    @Override
    public void sumarBaja() {
        contadorDeBajas = contadorDeBajas + 1;
        if (contadorDeBajas >= 3) {
            this.invisible = true;
        }
    }
}
