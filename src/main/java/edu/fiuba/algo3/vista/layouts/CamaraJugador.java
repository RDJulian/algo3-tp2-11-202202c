package edu.fiuba.algo3.vista.layouts;

import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Piso.Moho;
import edu.fiuba.algo3.vista.contenedores.ContenedorPrincipal;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class CamaraJugador extends GridPane {

    private int alto;
    private int ancho;
    private int centroX;
    private int centroY;
    private ArrayList<VistaCelda> celdas;
    private ArrayList<Moho> pisosConMoho;
    public CamaraJugador(ContenedorPrincipal contenedorPrincipal, int ancho, int alto, int centroX, int centroY){
        this.alto = alto;
        this.ancho = ancho;
        this.centroX = centroX;
        this.centroY = centroY;
        this.celdas = new ArrayList();
        this.pisosConMoho = new ArrayList();
    }


    public void agregarCanvas(VistaCelda dibujoCelda, int col, int fil){
        celdas.add(dibujoCelda);
        this.add(dibujoCelda,col,fil);
    }

    public void agregarMoho(Moho piso) {
        pisosConMoho.add(piso);
    }

    public void update(){
        for (VistaCelda celda: celdas) {
            celda.update();
        }
    }

    public void enRangoMoho(Area areaTierra) {
        for (Moho moho:pisosConMoho) {
            moho.actualizarArea(areaTierra);
        }
    }
}
