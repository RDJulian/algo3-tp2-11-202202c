package edu.fiuba.algo3.vista.layouts;

import edu.fiuba.algo3.controladores.Desplazamiento.CambiarVelocidadDeDesplazamiento;
import edu.fiuba.algo3.vista.botones.BotonDesplazarDerecha;
import edu.fiuba.algo3.vista.botones.BotonDesplazarIzquierda;
import edu.fiuba.algo3.vista.botones.BotonDesplazarArriba;
import edu.fiuba.algo3.vista.botones.BotonDesplazarAbajo;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class BotoneraDeDesplazamiento extends VBox {

    public BotoneraDeDesplazamiento(CamaraJugador camaraActual){
        BotonDesplazarIzquierda botonIzquierda = new BotonDesplazarIzquierda(camaraActual);
        BotonDesplazarArriba botonArriba = new BotonDesplazarArriba(camaraActual);
        Button botonCambiarVelocidad = new Button();
        BotonDesplazarAbajo botonAbajo = new BotonDesplazarAbajo(camaraActual);
        BotonDesplazarDerecha botonDerecha = new BotonDesplazarDerecha(camaraActual);

        botonCambiarVelocidad.setPrefSize(42,42);
        Image imagen = new Image("file:src/main/resources/desplazamiento/x1.png");
        BackgroundImage imagenVelocidad = new BackgroundImage(imagen,null,null,null,null);
        botonCambiarVelocidad.setBackground(new Background(imagenVelocidad));
        botonCambiarVelocidad.setOnAction(new CambiarVelocidadDeDesplazamiento(botonCambiarVelocidad,botonIzquierda,botonArriba,botonAbajo,botonDerecha));

        HBox botonDeArriba = new HBox();
        botonDeArriba.getChildren().add(botonArriba);
        botonDeArriba.setAlignment(Pos.CENTER);
        HBox botonDeAbajo = new HBox();
        botonDeAbajo.getChildren().add(botonAbajo);
        botonDeAbajo.setAlignment(Pos.CENTER);
        HBox botonesDeEnMedio = new HBox();
        botonesDeEnMedio.setSpacing(3);
        botonesDeEnMedio.setAlignment(Pos.CENTER);
        botonesDeEnMedio.getChildren().addAll(botonIzquierda,botonCambiarVelocidad,botonDerecha);

        VBox botonera = new VBox();
        botonera.setSpacing(2);
        botonera.setAlignment(Pos.CENTER);
        botonera.getChildren().addAll(botonDeArriba,botonesDeEnMedio,botonDeAbajo);

        this.setMinSize(192,128);
        this.getChildren().add(botonera);
    }
}
