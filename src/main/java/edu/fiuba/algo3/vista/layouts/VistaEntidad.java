package edu.fiuba.algo3.vista.layouts;

import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class VistaEntidad extends Canvas {

    private Area area;
    private Estructura estructura;
    private Unidad unidad;

    public VistaEntidad(Area area, Estructura estructura, Unidad unidad) {
        super(64, 64);
        this.area = area;
        this.estructura = estructura;
        this.unidad = unidad;
        this.update();
    }

    public void update() {
        if (this.unidad == null) {
            dibujarEstructura();
            return;
        }
        dibujarUnidad();
    }

    private void dibujarUnidad() {
        String unidad = this.unidad.getNombre();
        String ruta = "file:src/main/resources/unidades/".concat(unidad).concat(".png");
        this.dibujarImagen(ruta);
    }

    private void dibujarImagen(String ruta) {
        Image imagen = new Image(ruta);
        GraphicsContext dibujador = this.getGraphicsContext2D();
        dibujador.drawImage(imagen, 0, 0);
    }

    private void dibujarEstructura() {
        String estructura = this.estructura.getNombre();
        String ruta = "file:src/main/resources/estructuras/".concat(estructura).concat(".png");
        this.dibujarImagen(ruta);
    }
}
