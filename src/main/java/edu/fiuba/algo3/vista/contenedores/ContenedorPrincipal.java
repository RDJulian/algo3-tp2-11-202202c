package edu.fiuba.algo3.vista.contenedores;

import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Unidad;

import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Mapa.Base;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.vista.layouts.BotoneraDeDesplazamiento;
import edu.fiuba.algo3.vista.layouts.CamaraJugador;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ContenedorPrincipal extends HBox{


    private final ArrayList<ArrayList<Estructura>> estructuras;
    private final ArrayList<ArrayList<Unidad>> unidades;
    private CamaraJugador camaraJugadorUno;
    private CamaraJugador camaraJugadorDos;

    public ContenedorPrincipal(Stage stage, Scene proximaEscena, Juego juego){
        this.estructuras = new ArrayList<>();
        this.unidades = new ArrayList<>();
        this.setStyle("-fx-background-color: #2E2C39;");
        this.setPrefSize(1920,1080);

        this.cargarMapa(juego);
        this.cargarBotoneraDeDesplazamiento();
        //this.cargarCajaDeComandos(stage);
        //this.cargarBotonProximoTurno(stage, proximaEscena);
    }

    private void cargarMapa(Juego juego){
        for (int y = 0; y < 51; y++) {
            ArrayList<Estructura> filaEstucturas = new ArrayList<>();
            ArrayList<Unidad> filaUnidades = new ArrayList<>();
            for (int x = 0; x < 51; x++) {
                filaEstucturas.add(null);
                filaUnidades.add(null);
            }
            estructuras.add(filaEstucturas);
            unidades.add(filaUnidades);
        }
        Mapa.obtenerInstancia().generarBases(new Base(10, 10), new Base(-10, -10));
        this.camaraJugadorUno = new CamaraJugador(this,25,14,10,10);
        this.camaraJugadorDos = new CamaraJugador(this,25,14,-10,-10);
        this.getChildren().add(camaraJugadorUno);
        Mapa.obtenerInstancia().agregar(camaraJugadorUno);
        Mapa.obtenerInstancia().agregar(camaraJugadorDos);
        Mapa.obtenerInstancia().notificar();
    }

    private void cargarBotoneraDeDesplazamiento() {
        BotoneraDeDesplazamiento botonera = new BotoneraDeDesplazamiento(camaraJugadorUno);
        this.getChildren().add(botonera);
    }


    public Unidad getUnidad(int x, int y) {
        return unidades.get(50-(y + 25)).get(x + 25);
    }

    public Estructura getEstructura(int x, int y) {
        return estructuras.get(50-(y + 25)).get(x + 25);
    }
}
