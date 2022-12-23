package edu.fiuba.algo3.vista.layouts;

import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Area.Coordenada;
import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.mvc.Observador;
import edu.fiuba.algo3.vista.contenedores.ContenedorPrincipal;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.lang.reflect.MalformedParameterizedTypeException;

public class VistaCelda extends Canvas implements Observador {

    private Coordenada coordenada;
    private Area area;
    private CamaraJugador camaraJugador;
    private Unidad unidad;
    private Estructura estructura;

    public VistaCelda(Area area, CamaraJugador camaraJugador) {
        super(64,64);
        this.area = area;
        this.coordenada = area.getCoordenada();
        this.camaraJugador = camaraJugador;
        this.unidad = null;
        this.estructura = null;
        area.agregar(this);
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
        if (unidad == null){return;}
        String estructura = this.unidad.getNombre();
        String ruta = "file:src/main/resources/estructuras/".concat(estructura).concat(".png");
        this.dibujarImagen(ruta);
    }

    private void dibujarUnidad(Unidad unidadADibujar) {
        String unidad = unidadADibujar.getNombre();
        if(unidad=="nada"){return;}
        String ruta = "file:src/main/resources/unidades/".concat(unidad).concat(".png");
        this.dibujarImagen(ruta);
    }

    public void observarA(ContenedorPrincipal contenedorPrincipal,int x, int y){
        this.area = Mapa.obtenerInstancia().getArea(x,y);
        this.coordenada = area.getCoordenada();
        this.unidad = contenedorPrincipal.getUnidad(x,y);
        this.estructura = contenedorPrincipal.getEstructura(x,y);
    }

    public void observarAIzquierda(ContenedorPrincipal contenedorPrincipal) {
        int x = coordenada.x()-1;
        int y = coordenada.y();
        observarA(contenedorPrincipal,x,y);
    }

    public void observarADerecha(ContenedorPrincipal contenedorPrincipal) {
        int x = coordenada.x()+1;
        int y = coordenada.y();
        observarA(contenedorPrincipal,x,y);
    }

    public void observarAArriba(ContenedorPrincipal contenedorPrincipal) {
        int x = coordenada.x();
        int y = coordenada.y()+1;
        observarA(contenedorPrincipal,x,y);
    }

    public void observarAAbajo(ContenedorPrincipal contenedorPrincipal) {
        int x = coordenada.x();
        int y = coordenada.y()-1;
        observarA(contenedorPrincipal,x,y);
    }
}
