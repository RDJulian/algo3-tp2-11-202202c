package edu.fiuba.algo3.vista.layouts;

import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Piso.Moho;
import edu.fiuba.algo3.mvc.Observador;
import edu.fiuba.algo3.vista.contenedores.ContenedorPrincipal;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;

public class CamaraJugador extends VBox implements Observador {

    private GridPane camara;
    private int alto;
    private int ancho;
    private int centroX;
    private int centroY;
    private Label labelMinY;
    private Label labelMaxY;
    private Label labelMinX;
    private Label labelMaxX;
    private ArrayList<VistaCelda> celdas;
    private ArrayList<Moho> pisosConMoho;
    private ContenedorPrincipal contenedorPrincipal;

    public CamaraJugador(ContenedorPrincipal contenedorPrincipal, int ancho, int alto, int centroX, int centroY){
        this.alto = alto;
        this.ancho = ancho;
        this.centroX = centroX;
        this.centroY = centroY;
        this.celdas = new ArrayList<>();
        this.pisosConMoho = new ArrayList<>();
        this.contenedorPrincipal = contenedorPrincipal;
        this.camara = new GridPane();

        this.setStyle("-fx-padding: 44px");
        this.setAlignment(Pos.CENTER);

        int minY = centroY-(alto/2);
        int maxY = minY+alto-1;
        int minX = centroX-(ancho/2);
        int maxX = minX+ancho-1;
        int indiceColumna = 0;
        int indiceFila = 0;

        for (int x = minX; x <= maxX; x++) {
            for (int y = maxY; y >= minY; y--) {
                Area area = Mapa.obtenerInstancia().getArea(x,y);
                VistaCelda vistaCelda = new VistaCelda(area, this);
                agregarCanvas(vistaCelda, indiceColumna, indiceFila);
                indiceFila++;
            }
            indiceFila = 0;
            indiceColumna++;
        }

        this.labelMinY = new Label(String.valueOf(minY));
        labelMinY.setFont(Font.font("arial", 15));
        labelMinY.setTextFill(Color.web("#bbbbbb"));
        this.labelMaxY = new Label(String.valueOf(maxY));
        labelMaxY.setFont(Font.font("arial", 15));
        labelMaxY.setTextFill(Color.web("#bbbbbb"));
        this.labelMinX = new Label(String.valueOf(minX));
        labelMinX.setFont(Font.font("arial", 15));
        labelMinX.setTextFill(Color.web("#bbbbbb"));
        this.labelMaxX = new Label(String.valueOf(maxX));
        labelMaxX.setFont(Font.font("arial", 15));
        labelMaxX.setTextFill(Color.web("#bbbbbb"));

        VBox labelIzquierdo = new VBox();
        labelIzquierdo.setSpacing(64*alto-36);
        labelIzquierdo.getChildren().addAll(labelMaxY,labelMinY);

        HBox caja1 = new HBox();
        caja1.setSpacing(2);
        caja1.getChildren().addAll(labelIzquierdo,camara);

        HBox caja2 = new HBox();
        caja2.setSpacing(64*ancho-36);
        caja2.setAlignment(Pos.CENTER_RIGHT);
        caja2.getChildren().addAll(labelMinX,labelMaxX);

        this.getChildren().addAll(caja1,caja2);
    }


    public void agregarCanvas(VistaCelda dibujoCelda, int col, int fil){
        celdas.add(dibujoCelda);
        camara.add(dibujoCelda,col,fil);
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

    private void cambiarRangoY(int minY, int maxY){
        labelMinY.setText(String.valueOf(minY));
        labelMaxY.setText(String.valueOf(maxY));
    }

    private void cambiarRangoX(int minX, int maxX){
        labelMinX.setText(String.valueOf(minX));
        labelMaxX.setText(String.valueOf(maxX));
    }

    public void desplazarALaIzquierda(int cantDesplazamientos){
        int nuevoMinX = 0;
        int nuevoMaxX = 0;
        for (int i = 0; i <cantDesplazamientos ; i++) {
            nuevoMinX = centroX - (ancho / 2) - 1;
            nuevoMaxX = nuevoMinX + ancho - 1;
            if (nuevoMinX < -25) {
                nuevoMinX++;
                nuevoMaxX++;
                break;
            }
            this.centroX = centroX - 1;
            for (VistaCelda celda : celdas) {
                celda.observarAIzquierda(contenedorPrincipal);
            }
        }
        cambiarRangoX(nuevoMinX,nuevoMaxX);
        this.update();
    }

    public void desplazarALaDerecha(int cantDesplazamientos){
        int nuevoMinX = 0;
        int nuevoMaxX = 0;
        for (int i = 0; i < cantDesplazamientos; i++) {
            nuevoMinX = centroX - (ancho / 2) + 1;
            nuevoMaxX = nuevoMinX + ancho - 1;
            if (nuevoMaxX > 25) {
                nuevoMinX--;
                nuevoMaxX--;
                break;
            }
            this.centroX = centroX + 1;
            for (VistaCelda celda : celdas) {
                celda.observarADerecha(contenedorPrincipal);
            }
        }
        cambiarRangoX(nuevoMinX,nuevoMaxX);
        this.update();
    }

    public void desplazarParaArriba(int cantDesplazamientos){
        int nuevoMinY = 0;
        int nuevoMaxY = 0;
        for (int i = 0; i < cantDesplazamientos; i++) {
            nuevoMinY = centroY - (alto / 2) + 1;
            nuevoMaxY = nuevoMinY + alto - 1;
            if (nuevoMaxY > 25) {
                nuevoMinY--;
                nuevoMaxY--;
                break;
            }
            this.centroY = centroY + 1;
            for (VistaCelda celda : celdas) {
                celda.observarAArriba(contenedorPrincipal);
            }
        }
        cambiarRangoY(nuevoMinY,nuevoMaxY);
        this.update();
    }

    public void desplazarParaAbajo(int cantDesplazamientos){
        int nuevoMinY = 0;
        int nuevoMaxY = 0;
        for (int i = 0; i < cantDesplazamientos; i++) {
            nuevoMinY = centroY - (alto / 2) - 1;
            nuevoMaxY = nuevoMinY + alto - 1;
            if (nuevoMinY < -25) {
                nuevoMinY++;
                nuevoMaxY++;
                break;
            }
            this.centroY = centroY - 1;
            for (VistaCelda celda : celdas) {
                celda.observarAAbajo(contenedorPrincipal);
            }
        }
        cambiarRangoY(nuevoMinY,nuevoMaxY);
        this.update();
    }

}
