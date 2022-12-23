package edu.fiuba.algo3.controladores.Desplazamiento;

import edu.fiuba.algo3.vista.botones.BotonDeDesplazamiento;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.util.ArrayList;

public class CambiarVelocidadDeDesplazamiento implements EventHandler<ActionEvent> {

    private Button boton;
    ArrayList<BotonDeDesplazamiento> botonesDeDesplazamiento;

    public CambiarVelocidadDeDesplazamiento(Button boton,BotonDeDesplazamiento boton1, BotonDeDesplazamiento boton2, BotonDeDesplazamiento boton3,BotonDeDesplazamiento boton4) {
        super();
        this.boton = boton;
        this.botonesDeDesplazamiento = new ArrayList();
        botonesDeDesplazamiento.add(boton1);
        botonesDeDesplazamiento.add(boton2);
        botonesDeDesplazamiento.add(boton3);
        botonesDeDesplazamiento.add(boton4);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        for (BotonDeDesplazamiento boton: botonesDeDesplazamiento) {
            boton.cambiarVelocidad();
        }
        String ruta = "file:src/main/resources/desplazamiento/x".concat(botonesDeDesplazamiento.get(0).getVelocidad()).concat(".png");
        Image imagen = new Image(ruta);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, null,null,null,null);
        boton.setBackground(new Background(imagenDeFondo));
    }
}
