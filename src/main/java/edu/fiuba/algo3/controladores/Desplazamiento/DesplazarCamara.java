package edu.fiuba.algo3.controladores.Desplazamiento;

import edu.fiuba.algo3.vista.botones.BotonDeDesplazamiento;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class DesplazarCamara implements EventHandler<ActionEvent> {

    BotonDeDesplazamiento botonDeDesplazamiento;
    public DesplazarCamara(BotonDeDesplazamiento boton) {
        this.botonDeDesplazamiento = boton;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        botonDeDesplazamiento.desplazarCamara();
    }
}
