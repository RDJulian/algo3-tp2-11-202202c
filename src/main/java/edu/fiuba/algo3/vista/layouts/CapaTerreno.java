package edu.fiuba.algo3.vista.layouts;

import edu.fiuba.algo3.modelo.Piso.Moho;
import edu.fiuba.algo3.modelo.Piso.Piso;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class CapaTerreno extends GridPane {

    private ArrayList<Moho> pisosConMoho;
    public CapaTerreno(){
        this.pisosConMoho = new ArrayList();
    }


    public void agregarCanvas(VistaTerreno dibujoTerreno, int col, int fil){
        this.add(dibujoTerreno,col,fil);
    }

    public void agregarMoho(Moho piso) {
        pisosConMoho.add(piso);
    }
}
