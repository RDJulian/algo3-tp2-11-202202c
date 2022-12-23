package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.controladores.Desplazamiento.DesplazarCamara;
import edu.fiuba.algo3.vista.layouts.CamaraJugador;
import javafx.scene.control.Button;

public abstract class BotonDeDesplazamiento extends Button {

    protected CamaraJugador camaraActual;
    protected int velocidad;

    public BotonDeDesplazamiento(CamaraJugador camaraActual){
        this.setPrefSize(42,42);
        this.velocidad = 1;
        this.camaraActual = camaraActual;
        this.setOnAction(new DesplazarCamara(this));
    }

    public void cambiarVelocidad() {
        int velocidadNueva = this.velocidad + 1;
        if(velocidadNueva == 4){ velocidadNueva = 1;}
        this.velocidad = velocidadNueva;
    }

    public String getVelocidad(){
        return String.valueOf(this.velocidad);
    }

    public abstract void desplazarCamara();

}
