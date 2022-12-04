package edu.fiuba.algo3.modelo.Entidad.Unidad;

import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.Invisible;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.Visible;
import edu.fiuba.algo3.modelo.Entidad.Estructura.MementoEstructura.MementoInvisibilidad;
import edu.fiuba.algo3.modelo.Entidad.Estructura.MementoEstructura.UsaMementoInvisibilidad;
import edu.fiuba.algo3.modelo.Entidad.Estructura.MementoEstructura.UsaMementoOperativo;
import edu.fiuba.algo3.modelo.Entidad.Invisibilidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.UnidadTierra;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EnConstruccion;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.RolEnSuministro.Consumidor;
import edu.fiuba.algo3.modelo.Vida.Escudo;
import edu.fiuba.algo3.modelo.Vida.Normal;

import java.util.ArrayList;

public class Zealot extends UnidadAtacante implements UsaMementoInvisibilidad {
    private Invisibilidad invisibilidad;

    public Zealot(Posicion posicion, Raza raza) {
        this.posicion = posicion;
        this.estadoOperativo = new EnConstruccion(4);
        this.estadoInvisibilidad = new Visible();
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

        this.invisibilidad = new Invisibilidad(this);
    }

    @Override
    public void sumarBaja() {
        contadorDeBajas = contadorDeBajas + 1;
        if (contadorDeBajas == 3) {
            estadoInvisibilidad = new Invisible();
            invisibilidad.sincronizarEstado();
        }
    }

    @Override
    public MementoInvisibilidad guardarEstado() {
        MementoInvisibilidad snapshot = new MementoInvisibilidad(estadoInvisibilidad);
        this.estadoInvisibilidad = new Visible();
        return snapshot;
    }

    @Override
    public void restaurarEstado(MementoInvisibilidad snapshot) {
        this.estadoInvisibilidad = snapshot.restaurar();
    }

    public void actualizarEstado(ArrayList<AmoSupremo> amosSupremos) {
        invisibilidad.actualizarEstado(amosSupremos, posicion);
    }
}