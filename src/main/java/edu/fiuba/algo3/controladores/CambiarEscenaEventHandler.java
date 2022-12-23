package edu.fiuba.algo3.controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class CambiarEscenaEventHandler implements EventHandler<ActionEvent> {

    Stage stage;
    Scene proximaEscena;
    public CambiarEscenaEventHandler(Stage stage, Scene proximaEscena) {
        this.stage = stage;
        this.proximaEscena = proximaEscena;
    }

    @Override
    public void handle (ActionEvent actionEvent){
        stage.setScene(proximaEscena);
    }

}
