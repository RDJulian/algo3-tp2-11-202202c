package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.controladores.LimpiarTextoEventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.scene.text.Font;

public class BotonLimpiarTexto extends Button {

    public BotonLimpiarTexto (TextField textField){

        //Propiedades del Boton.
        this.setText("Limpiar Texto");
        this.setFont(Font.font("arial", 15));

        //Eventos.
        this.setOnAction(new LimpiarTextoEventHandler(textField));

    }

}
