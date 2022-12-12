package edu.fiuba.algo3.modelo.Area;

import edu.fiuba.algo3.modelo.Area.EstadoPiso.EstadoPisoNull;
import edu.fiuba.algo3.modelo.Area.TipoArea.AreaTierra;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.ConstruiblePiso;
import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.ConstruibleRecurso;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Energia.EstadoEnergia.EstadoEnergia;
import edu.fiuba.algo3.modelo.Entidad.Unidad.TipoUnidad.TipoUnidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Zangano;
import edu.fiuba.algo3.modelo.Excepciones.MovimientoNoValidoException;
import edu.fiuba.algo3.modelo.Excepciones.MovimientoSobreRecursoException;
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

    //Constructor para usar en el modelo
    public Area(Coordenada coordenada, TipoArea tipoArea, Recurso recurso) {
        this.coordenada = coordenada;
        this.tipoArea = tipoArea;
        this.estadoOcupacion = new Desocupada();
        this.estadoPiso = new EstadoPisoNull();
        this.recurso = recurso;
    }

    //Constructor para inyectar dependencia y mockear
    public Area(Coordenada coordenada, TipoArea tipoArea, EstadoOcupacion estadoOcupacion, EstadoPiso estadoPiso, Recurso recurso) {
        this.coordenada = coordenada;
        this.tipoArea = tipoArea;
        this.estadoOcupacion = estadoOcupacion;
        this.estadoPiso = estadoPiso;
        this.recurso = recurso;
    }

    //Constructor para simplificar casos de uso donde solamente se usan las coordenadas
    public Area(int posicionX, int posicionY) {
        this.coordenada = new Coordenada(posicionX, posicionY);
        this.tipoArea = new AreaTierra();
        this.estadoOcupacion = new Desocupada();
        this.estadoPiso = new EstadoPisoNull();
        this.recurso = new RecursoNull();
    }

    //Mover y ocupar van de la mano: si una Unidad se puede mover, ya ocupa el Area.
    //Recurso implementa movible, que es una solucion facil pero no tan buena.
    public Area moverse(Zangano unidad, TipoUnidad tipoUnidad) {
        if (recurso.movible(unidad)) {
            return tipoArea.moverse(tipoUnidad, this);
        } else {
            throw new MovimientoSobreRecursoException();
        }
    }

    public Area moverse(TipoUnidad tipoUnidad) {
        if (recurso.movible()) {
            return tipoArea.moverse(tipoUnidad, this);
        } else {
            throw new MovimientoSobreRecursoException();
        }
    }

    public Area ocupar() {
        this.estadoOcupacion = estadoOcupacion.ocupar();
        return this;
    }

    public void desocupar() {
        this.estadoOcupacion = new Desocupada();
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

    public void cubrirConMoho() {
        this.estadoPiso = estadoOcupacion.cubrirConMoho(estadoPiso);
    }

    public void energizar() {
        this.estadoPiso = estadoPiso.energizar();
    }

    public EstadoEnergia energizar(EstadoEnergia estadoEnergia) {
        return estadoPiso.energizar(estadoEnergia);
    }

    public void actualizarEstado(Piso piso) {
        piso.actualizarArea(this);
    }

    public void actualizarEstado(ArrayList<Piso> pisos) {
        this.estadoPiso = estadoPiso.limpiar();
        for (Piso piso : pisos) {
            piso.actualizarArea(this);
        }
    }

    //Se delega a la coordenada este comportamiento. Se usa un getter para simplificar.
    public boolean es(Area area) {
        return coordenada.es(area.getCoordenada());
    }

    public boolean esOpuesta(Area area) {
        return coordenada.esOpuesta(area.getCoordenada());
    }

    public boolean enRango(Area area, int radio) {
        return coordenada.enRango(area.getCoordenada(), radio);
    }

    private Coordenada getCoordenada() {
        return coordenada;
    }
}
