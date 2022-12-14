package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.vista.contenedores.ContenedorBienvenidos;
import edu.fiuba.algo3.vista.contenedores.ContenedorGanador;
import edu.fiuba.algo3.vista.contenedores.ContenedorJugadores;
import edu.fiuba.algo3.vista.contenedores.ContenedorPrincipal;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        stage.setTitle("AlgoCraft");

        String javaVersion = SystemInfo.javaVersion();
        String javafxVersion = SystemInfo.javafxVersion();

        Juego juego = new Juego();

        ContenedorGanador contenedorGanador = new ContenedorGanador(stage);
        Scene ecsenaGanador = new Scene (contenedorGanador, 1860, 900);

        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage, ecsenaGanador, juego);
        Scene escenaPrincipal = new Scene(contenedorPrincipal,1860,900);

        ContenedorJugadores contenedorJugadores =  new ContenedorJugadores(stage, escenaPrincipal, juego);
        Scene escenaJugadores = new Scene (contenedorJugadores, 1860, 900);

        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos (stage, escenaJugadores, javaVersion, javafxVersion);
        Scene escenaBienvenidos = new Scene(contenedorBienvenidos, 1860, 900);

        stage.setScene(escenaBienvenidos);

        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}