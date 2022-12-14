package edu.fiuba.algo3.vista.layouts;

import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
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
        this.celdas = new ArrayList<>();
        this.pisosConMoho = new ArrayList<>();

        int minY = centroY-(alto/2);
        int maxY = centroY+(alto/2);
        int minX = centroX-(ancho/2);
        int maxX = centroX+(ancho/2);
        int indiceColumna = 0;
        int indiceFila = 0;

        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                Area area = Mapa.obtenerInstancia().getArea(x,y);
                VistaCelda vistaCelda = new VistaCelda(area, this);
                agregarCanvas(vistaCelda, indiceColumna, indiceFila);
                indiceFila++;
            }
            indiceFila = 0;
            indiceColumna++;
        }
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

    public void enRangoMoho(Area area) {
        for (Moho moho:pisosConMoho) {
            moho.actualizarArea(area);
        }
    }
}
