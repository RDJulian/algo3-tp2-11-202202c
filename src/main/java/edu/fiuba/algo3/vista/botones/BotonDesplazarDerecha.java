package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.vista.layouts.CamaraJugador;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class BotonDesplazarDerecha extends BotonDeDesplazamiento{
    public BotonDesplazarDerecha(CamaraJugador camaraActual) {
        super(camaraActual);
        Image imagen = new Image("file:src/main/resources/desplazamiento/Flecha_Derecha.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
    }

    @Override
    public void desplazarCamara() {
        this.camaraActual.desplazarALaDerecha(this.velocidad);
    }

}
