package edu.fiuba.algo3.vista.contenedores;


import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Entidad.Unidad.UnidadNull;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.vista.layouts.CamaraJugador;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ContenedorPrincipal extends StackPane{


    private final ArrayList<ArrayList<Estructura>> estructuras;
    private final ArrayList<ArrayList<Unidad>> unidades;
    private CamaraJugador camaraJugadorUno;
    private CamaraJugador camaraJugadorDos;

    public ContenedorPrincipal(Stage stage, Scene proximaEscena, Juego juego){
        this.estructuras = new ArrayList<>();
        this.unidades = new ArrayList<>();

        this.cargarMapa(juego);
        //this.cargarCajaDeComandos(stage);
        //this.cargarBotonProximoTurno(stage, proximaEscena);
    }

    private void cargarMapa(Juego juego){
        for (int y = -25; y <= 25; y++) {
            ArrayList<Estructura> filaEstucturas = new ArrayList<>();
            ArrayList<Unidad> filaUnidades = new ArrayList<>();
            for (int x = -25; x < 25; x++) {
                filaEstucturas.add(null);
                filaUnidades.add(new UnidadNull());
            }
        }
        this.camaraJugadorUno = new CamaraJugador(this,29,16,10,10);
        this.camaraJugadorDos = new CamaraJugador(this,29,16,-10,-10);
        this.getChildren().addAll(camaraJugadorUno);
        camaraJugadorUno.update();
    }

}
