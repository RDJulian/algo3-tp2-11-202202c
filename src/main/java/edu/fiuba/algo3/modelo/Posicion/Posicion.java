package edu.fiuba.algo3.modelo.Posicion;

import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.ConstruiblePiso;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Pilon;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.TipoUnidad;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Posicion.Area.Area;
import edu.fiuba.algo3.modelo.Posicion.Area.AreaTierra;
import edu.fiuba.algo3.modelo.Posicion.EstadoOcupado.Desocupada;
import edu.fiuba.algo3.modelo.Posicion.EstadoOcupado.EstadoPosicion;
import edu.fiuba.algo3.modelo.Posicion.EstadoPiso.EstadoPiso;
import edu.fiuba.algo3.modelo.Posicion.EstadoPiso.Nada;
import edu.fiuba.algo3.modelo.Posicion.EstadoPiso.TieneEnergiaPilon;
import edu.fiuba.algo3.modelo.Posicion.EstadoPiso.TieneMoho;

public class Posicion {
    private int posicionX;
    private int posicionY;
    private Area area;
    private EstadoPosicion estadoPosicion;

    private EstadoPiso estadoPiso;

    public Posicion(int posicionX, int posicionY, Area area) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.area = area;
        this.estadoPosicion = new Desocupada();
        this.estadoPiso = new Nada();
    }

    public Posicion(int posicionX, int posicionY) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.area = new AreaTierra();
        this.estadoPosicion = new Desocupada();
        this.estadoPiso = new Nada();
    }

    public Posicion movible(TipoUnidad tipoUnidad) {
        return area.movible(tipoUnidad, this);
    }

    public Posicion ocupar() {
        this.estadoPosicion = estadoPosicion.ocupar();
        return this;
    }

    public boolean construible(ConstruiblePiso construiblePiso) {
        return estadoPiso.construible(construiblePiso);
    }

    public void desocupar() {
        this.estadoPosicion = new Desocupada();
    }

    public void energizar() {
        this.estadoPiso = new TieneEnergiaPilon();
    }

    public void cubrirConMoho() {
        this.estadoPiso = new TieneMoho();
    }

    private boolean enRango(int posicionX, int posicionY, int radio) {
        return (this.posicionX - radio <= posicionX &&
                this.posicionX + radio >= posicionX &&
                this.posicionY - radio <= posicionY &&
                this.posicionY + radio >= posicionY);
    }

    public boolean enRango(Posicion posicion, int radio) {
        return (posicion.enRango(this.posicionX, this.posicionY, radio));
    }

    private boolean esOpuesta(int posicionX, int posicionY) {
        return (this.posicionX == -posicionX && this.posicionY == -posicionY);
    }

    public boolean esOpuesta(Posicion posicion) {
        return posicion.esOpuesta(this.posicionX, this.posicionY);
    }

    private boolean es(int posicionX, int posicionY) {
        return (posicionX == this.posicionX && posicionY == this.posicionY);
    }

    public boolean es(Posicion posicion) {
        return posicion.es(this.posicionX, this.posicionY);
    }

    public void actualizarEstado(Piso piso) {
        piso.actualizarPosicionEnRango(this);
    }
}
