package edu.fiuba.algo3.modelo.Area;

import edu.fiuba.algo3.modelo.Area.EstadoPiso.EstadoPisoNull;
import edu.fiuba.algo3.modelo.Area.TipoArea.AreaTierra;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.ConstruiblePiso;
import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.ConstruibleRecurso;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Energia.EstadoEnergia;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.TipoUnidad;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Area.TipoArea.TipoArea;
import edu.fiuba.algo3.modelo.Area.EstadoOcupacion.Desocupada;
import edu.fiuba.algo3.modelo.Area.EstadoOcupacion.EstadoOcupacion;
import edu.fiuba.algo3.modelo.Area.EstadoPiso.EstadoPiso;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Area.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Area.Recurso.RecursoNull;

import java.util.ArrayList;

public class Area {
    private Coordenada coordenada;
    private TipoArea tipoArea;
    private EstadoOcupacion estadoOcupacion;
    private EstadoPiso estadoPiso;
    private Recurso recurso;

    public Area(Coordenada coordenada, TipoArea tipoArea, EstadoOcupacion estadoOcupacion, EstadoPiso estadoPiso, Recurso recurso) {
        this.coordenada = coordenada;
        this.tipoArea = tipoArea;
        this.estadoOcupacion = estadoOcupacion;
        this.estadoPiso = estadoPiso;
        this.recurso = recurso;
    }

    public Area(int posicionX, int posicionY) {
        this.coordenada = new Coordenada(posicionX, posicionY);
        this.tipoArea = new AreaTierra();
        this.estadoOcupacion = new Desocupada();
        this.estadoPiso = new EstadoPisoNull();
        this.recurso = new RecursoNull();
    }

    public Area movible(TipoUnidad tipoUnidad) {
        return tipoArea.movible(tipoUnidad, this);
    }

    public Area ocupar() {
        this.estadoOcupacion = estadoOcupacion.ocupar();
        return this;
    }

    public boolean construible(ConstruiblePiso construiblePiso) {
        return estadoPiso.construible(construiblePiso);
    }

    public boolean construible(ConstruibleRecurso construibleRecurso) {
        return recurso.construible(construibleRecurso);
    }

    public void extraerRecurso(int unidades, Raza raza) {
        recurso.extraerRecurso(unidades, raza);
    }

    public void desocupar() {
        this.estadoOcupacion = new Desocupada();
    }

    public void energizar() {
        this.estadoPiso = estadoPiso.energizar();
    }

    public void cubrirConMoho() {
        this.estadoPiso = estadoOcupacion.ejecutar(estadoPiso);
    }

    public EstadoEnergia energizar(EstadoEnergia estadoEnergia) {
        return estadoPiso.energizar(estadoEnergia);
    }

    public void actualizarEstado(Piso piso) {
        piso.actualizarPosicionEnRango(this);
    }

    public void actualizarEstado(ArrayList<Piso> pisos) {
        this.estadoPiso = estadoPiso.limpiar();
        for (Piso piso : pisos) {
            piso.actualizarPosicionEnRango(this);
        }
    }

    //Se delega a la coordenada este comportamiento. Se necesitan dos metodos para evitar romper Tell, don't ask.
    //Plantear un getter para simplificar. Se estaria llamando solamente desde aca.
    public boolean es(Area area) {
        return area.es(this.coordenada);
    }

    public boolean es(Coordenada coordenada) {
        return coordenada.es(this.coordenada);
    }

    public boolean esOpuesta(Area area) {
        return area.esOpuesta(this.coordenada);
    }

    public boolean esOpuesta(Coordenada coordenada) {
        return coordenada.esOpuesta(this.coordenada);
    }

    public boolean enRango(Area area, int radio) {
        return area.enRango(this.coordenada, radio);
    }

    public boolean enRango(Coordenada coordenada, int radio) {
        return coordenada.enRango(this.coordenada, radio);
    }
}
