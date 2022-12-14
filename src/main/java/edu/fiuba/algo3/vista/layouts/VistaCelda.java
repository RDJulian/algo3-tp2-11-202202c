package edu.fiuba.algo3.vista.layouts;

import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Area.Coordenada;
import edu.fiuba.algo3.modelo.Area.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.UnidadNull;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class VistaCelda extends Canvas {

    private Coordenada coordenada;
    private Area areaTierra;
    private Area areaEspacial;
    private Recurso recurso;
    private Estructura estructura;
    private Unidad unidadTerrestre;
    private Unidad unidadEspacial;
    private CamaraJugador camaraJugador;

    public VistaCelda(Coordenada coordenada, Area areaTierra, Area areaEspacial, Recurso recurso, CamaraJugador camaraJugador) {
        super(64,64);
        this.coordenada = coordenada;
        this.areaTierra = areaTierra;
        this.areaEspacial = areaEspacial;
        this.recurso = recurso;
        this.estructura = null;
        this.unidadTerrestre = new UnidadNull();
        this.unidadEspacial = new UnidadNull();
        this.camaraJugador = camaraJugador;
    }

    public void update(){
        actualizarPiso();
        dibujarTerreno();
        dibujarPiso();
        dibujarEstructura();
        dibujarUnidad(unidadTerrestre);
        dibujarUnidad(unidadEspacial);
    }

    private void actualizarPiso() {
        camaraJugador.enRangoMoho(areaTierra);
    }

    private void dibujarImagen(String ruta) {
        Image imagen = new Image(ruta);
        GraphicsContext dibujador = this.getGraphicsContext2D();
        dibujador.drawImage(imagen,0,0);
    }

    private void dibujarTerreno() {
        String recurso = this.recurso.getNombre();
        String ruta = "file:src/main/resources/recurso/".concat(recurso).concat(".png");
        dibujarImagen(ruta);
    }

    private void dibujarPiso(){
        String piso = this.areaTierra.getNombre();
        if(piso=="nada"){return;}
        String ruta = "file:src/main/resources/recurso/".concat(piso).concat(".png");
        dibujarImagen(ruta);
    }

    private void dibujarEstructura() {
        if (estructura == null){return;}
        String estructura = this.estructura.getNombre();
        String ruta = "file:src/main/resources/estructuras/".concat(estructura).concat(".png");
        this.dibujarImagen(ruta);
    }

    private void dibujarUnidad(Unidad unidadADibujar) {
        String unidad = unidadADibujar.getNombre();
        if(unidad=="nada"){return;}
        String ruta = "file:src/main/resources/unidades/".concat(unidad).concat(".png");
        this.dibujarImagen(ruta);
    }

    public void setEstructura(Estructura estructura) {
        this.estructura = estructura;
    }
}
