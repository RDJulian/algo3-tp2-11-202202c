package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.vista.contenedores.ContenedorPropiedadesJugadores;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class ConfirmarColorEventHandler implements EventHandler<ActionEvent> {

    Label etiqueta;
    String nombreColor;
    String rgb;
    ContenedorPropiedadesJugadores contenedor;

    public ConfirmarColorEventHandler (Label etiqueta, String nombreColor, String rgb, ContenedorPropiedadesJugadores contenedor){

        this.etiqueta = etiqueta;
        this.nombreColor = nombreColor;
        this.rgb = rgb;
        this.contenedor = contenedor;
    }

    @Override
    public void handle (ActionEvent actionEvent){

        this.etiqueta.setText("Su color es: " + nombreColor);
        this.contenedor.setearColor(this.rgb);
    }

}
