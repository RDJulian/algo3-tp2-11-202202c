package edu.fiuba.algo3.vista.layouts;

import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Area.Recurso.Recurso;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class VistaTerreno extends Canvas {

    private Area area;
    private Recurso recurso;

    public VistaTerreno(Area area, Recurso recurso) {
        super(64, 64);
        this.area = area;
        this.recurso = recurso;
        this.update();
    }

    public void update() {
        String recurso = this.recurso.getNombre();
        if (this.recurso.getRecursoRestante() == 0) {
            recurso = "nada";
        }
        String ruta = "file:src/main/resources/recurso/".concat(recurso).concat(".png");
        Image imagen = new Image(ruta);
        GraphicsContext dibujador = this.getGraphicsContext2D();
        dibujador.drawImage(imagen, 0, 0);
    }

}
