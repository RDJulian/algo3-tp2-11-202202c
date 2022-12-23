package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.vista.layouts.CamaraJugador;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class BotonDesplazarArriba extends BotonDeDesplazamiento{
    public BotonDesplazarArriba(CamaraJugador camaraActual) {
        super(camaraActual);
        Image imagen = new Image("file:src/main/resources/desplazamiento/Flecha_Arriba.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, null,null,null,null);
        this.setBackground(new Background(imagenDeFondo));
    }

    @Override
    public void desplazarCamara() {
        this.camaraActual.desplazarParaArriba(this.velocidad);
    }

}
