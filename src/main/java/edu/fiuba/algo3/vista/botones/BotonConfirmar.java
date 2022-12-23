package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.controladores.ConfirmarNombreEventHandler;
import edu.fiuba.algo3.vista.contenedores.ContenedorPropiedadesJugadores;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class BotonConfirmar extends Button {

    public BotonConfirmar (Label label, TextField textField, ContenedorPropiedadesJugadores contenedor){

        //Propiedades del Boton
        this.setText("Confirmar");
        this.setFont(Font.font("arial", 15));

        //Eventos.
        this.setOnAction(new ConfirmarNombreEventHandler(textField, label, contenedor));
    }

}
