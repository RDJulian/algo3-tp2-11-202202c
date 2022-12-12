package edu.fiuba.algo3.vista.contenedores;

import edu.fiuba.algo3.vista.Etiquetas.EtiquetaSecundaria;
import edu.fiuba.algo3.vista.botones.BotonColor;
import edu.fiuba.algo3.vista.botones.BotonConfirmar;
import edu.fiuba.algo3.vista.botones.BotonLimpiarTexto;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

public class ContenedorPropiedadesJugadores extends VBox {

    public ContenedorPropiedadesJugadores (String raza, String nombreJugador, String colorJugador){

        //Configuración del Layout
        Image imagen = new Image("file:src/main/java/edu/fiuba/algo3/vista/Assets/fondoPropiedadesJugadores.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
        this.setPadding(new Insets(50));

        //Controladores
        EtiquetaSecundaria razaJugador = new EtiquetaSecundaria(raza);
        razaJugador.setFont(Font.font("arial", 30));

        EtiquetaSecundaria etiquetaSecundariaNombre = new EtiquetaSecundaria ("Por Favor elija su nombre:");

        TextField nombre = new TextField("escriba su nombre");

        EtiquetaSecundaria etiquetaNombre = new EtiquetaSecundaria("Su nombre es:");
        EtiquetaSecundaria etiquetaColor = new EtiquetaSecundaria("Su color es:");

        BotonConfirmar botonConfirmar = new BotonConfirmar(etiquetaNombre, nombre, nombreJugador);

        BotonLimpiarTexto botonLimpiarTexto = new BotonLimpiarTexto(nombre);

        EtiquetaSecundaria etiquetaSecundariaColor = new EtiquetaSecundaria ("Por favor elija su color:");

        BotonColor botonAmarillo = new BotonColor("Amarillo", "ECF143", etiquetaColor, colorJugador);
        BotonColor botonRojo = new BotonColor("Rojo", "F53C3C", etiquetaColor, colorJugador);
        BotonColor botonVerde = new BotonColor("Verde", "68D03E", etiquetaColor, colorJugador);
        BotonColor botonAzul = new BotonColor("Azul", "4075D8", etiquetaColor, colorJugador);

        //Contenedores
        HBox nombreRaza = new HBox();
        nombreRaza.getChildren().addAll(razaJugador);
        nombreRaza.setAlignment(Pos.CENTER);

        HBox opcionesDeNombre = new HBox();
        opcionesDeNombre.getChildren().addAll(botonConfirmar, botonLimpiarTexto);
        opcionesDeNombre.setPadding(new Insets(10));

        HBox contenedorColores = new HBox();
        contenedorColores.getChildren().addAll(botonAmarillo, botonRojo, botonVerde, botonAzul);

        VBox contenedorNombre = new VBox();
        contenedorNombre.getChildren().addAll(etiquetaSecundariaNombre, nombre, opcionesDeNombre);
        contenedorNombre.setAlignment(Pos.CENTER);
        contenedorNombre.setPadding(new Insets(70));

        VBox contenedorColor = new VBox();
        contenedorColor.getChildren().addAll(etiquetaSecundariaColor, contenedorColores);
        contenedorColor.setAlignment(Pos.CENTER);
        contenedorColor.setPadding(new Insets(70));

        this.getChildren().addAll(nombreRaza, contenedorNombre, contenedorColor, etiquetaNombre, etiquetaColor);
    }
}
