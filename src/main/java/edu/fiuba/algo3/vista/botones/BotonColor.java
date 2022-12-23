package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.controladores.ConfirmarColorEventHandler;
import edu.fiuba.algo3.vista.Etiquetas.EtiquetaSecundaria;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import edu.fiuba.algo3.vista.contenedores.ContenedorPropiedadesJugadores;

public class BotonColor extends Button {

    public BotonColor (String color, String rgb, EtiquetaSecundaria etiqueta, ContenedorPropiedadesJugadores contenedor){

        //Configuración del Boton.
        this.setText(color);
        this.setFont(Font.font("arial", 15));
        this.setPadding(new Insets(10));
        this.setTextFill(Color.BLACK);
        this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(25), new BorderWidths(1.5D))));
        Background unFondo = new Background(new BackgroundFill(Color.web(rgb, 0.4F), new CornerRadii(25), new Insets(0)));
        super.setBackground(unFondo);

        //Eventos.
        this.setOnAction(new ConfirmarColorEventHandler(etiqueta, color, rgb, contenedor));
    }

}
