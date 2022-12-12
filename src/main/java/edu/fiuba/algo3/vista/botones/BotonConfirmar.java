package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.controladores.ConfirmarNombreEventHandler;
import edu.fiuba.algo3.controladores.SalirEventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class BotonConfirmar extends Button {

    TextField textField;
    Label label;

    public BotonConfirmar (Label label, TextField textField, String nombreJugador){

        this.label = label;
        this.textField = textField;

        this.setText("Confirmar");
        this.setFont(Font.font("arial", 15));
        //this.setPadding(new Insets(10));
        //this.setTextFill(Color.BLACK);
        //this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(25), new BorderWidths(1.5D))));
        //Background unFondo = new Background(new BackgroundFill(Color.web("2A2DF4", 0.4F), new CornerRadii(25), new Insets(0)));
        //super.setBackground(unFondo);

        this.setOnAction(new ConfirmarNombreEventHandler(this.textField, this.label, nombreJugador));
    }

}
