package edu.fiuba.algo3.vista.layouts;

import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class VistaCelda extends Canvas {

    private Area area;
    private CamaraJugador camaraJugador;
    private Entidad entidad;

    public VistaCelda(Area area, CamaraJugador camaraJugador) {
        super(64,64);
        this.area = area;
        this.camaraJugador = camaraJugador;
        this.entidad = null;
    }

    public void update(){
        actualizarPiso();
        dibujarTerreno();
        dibujarPiso();
        dibujarEntidad();
    }

    private void actualizarPiso() {
        camaraJugador.enRangoMoho(area);
    }

    private void dibujarImagen(String ruta) {
        Image imagen = new Image(ruta);
        GraphicsContext dibujador = this.getGraphicsContext2D();
        dibujador.drawImage(imagen,0,0);
    }

    private void dibujarTerreno() {
        String recurso = this.area.getNombreRecurso();
        String ruta = "file:src/main/resources/recurso/".concat(recurso).concat(".png");
        dibujarImagen(ruta);
    }

    private void dibujarPiso(){
        String piso = this.area.getNombre();
        if(piso=="nada"){return;}
        String ruta = "file:src/main/resources/recurso/".concat(piso).concat(".png");
        dibujarImagen(ruta);
    }

    private void dibujarEntidad() {
        if (entidad == null){return;}
        String estructura = this.entidad.getNombre();
        String ruta = "file:src/main/resources/estructuras/".concat(estructura).concat(".png");
        this.dibujarImagen(ruta);
    }

    private void dibujarUnidad(Unidad unidadADibujar) {
        String unidad = unidadADibujar.getNombre();
        if(unidad=="nada"){return;}
        String ruta = "file:src/main/resources/unidades/".concat(unidad).concat(".png");
        this.dibujarImagen(ruta);
    }

    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
    }
}
