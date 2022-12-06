package edu.fiuba.algo3.modelo.Posicion;

import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.TipoUnidad;
import edu.fiuba.algo3.modelo.Posicion.Area.Area;
import edu.fiuba.algo3.modelo.Posicion.Area.AreaTierra;

@SuppressWarnings("BooleanMethodIsAlwaysInverted")
public class Posicion {
    //Plantear relacion con las Areas.
    //Deberia implementar algun metodo que desocupe.
    private int posicionX;
    private int posicionY;

    private Area area;
    private EstadoPosicion estadoPosicion;

    public Posicion(int posicionX, int posicionY, Area area) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.estadoPosicion = new Desocupada();
        this.area = area;
    }

    public Posicion(int posicionX, int posicionY) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.estadoPosicion = new Desocupada();
        this.area = new AreaTierra();
    }

    public void movible(TipoUnidad tipoUnidad) {
        area.movible(tipoUnidad);
    }

    public void ocupable() {
        estadoPosicion.ocupable();
    }

    public void ocupar() {
        this.estadoPosicion = new Ocupada();
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
}
