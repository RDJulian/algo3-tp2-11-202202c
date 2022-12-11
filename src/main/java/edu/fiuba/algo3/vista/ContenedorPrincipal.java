package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero.Criadero;
import edu.fiuba.algo3.modelo.Piso.Moho;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.GasVespeno;
import edu.fiuba.algo3.modelo.Recurso.Mineral;
import edu.fiuba.algo3.modelo.Recurso.Nada;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.vista.layouts.CapaEntidades;
import edu.fiuba.algo3.vista.layouts.CapaTerreno;
import edu.fiuba.algo3.vista.layouts.VistaEntidad;
import edu.fiuba.algo3.vista.layouts.VistaTerreno;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ContenedorPrincipal extends StackPane{

        public ContenedorPrincipal(Stage stage, Scene proximaEscena){
           this.cargarMapa(stage);
           //this.cargarCajaDeComandos(stage);
           //this.cargarBotonProximoTurno(stage, proximaEscena);
        }

        private void cargarMapa(Stage stage){
            CapaTerreno capaTerreno = new CapaTerreno();
            int largo = 20;
            int alto = 11;
            Raza raza = new Raza();
            CapaEntidades capaEntidades = new CapaEntidades();
            for (int i = 0; i < largo; i++) {
                for (int j = 0; j < alto; j++) {
                    Posicion posicion = new Posicion(i,j);
                    Recurso recurso = new Nada();
                    if (i == 15){ recurso = new GasVespeno(posicion);}
                    if (i == 16){ recurso = new Mineral(posicion); }
                    if ((i == 5) && (j == 5)){
                        Moho piso = new Moho(posicion);
                        capaTerreno.agregarMoho(piso);
                    }
                    if (i == 11 && j == 10){
                        VistaEntidad vistaEntidad = new VistaEntidad(posicion,new Criadero(posicion,raza),null);
                        capaEntidades.agregarCanvas(vistaEntidad,19,13);
                    }
                    VistaTerreno vistaTerreno = new VistaTerreno(posicion,recurso);
                    capaTerreno.agregarCanvas(vistaTerreno,i,j);
                }
            }
            this.getChildren().addAll(capaTerreno, capaEntidades);
        }

}
