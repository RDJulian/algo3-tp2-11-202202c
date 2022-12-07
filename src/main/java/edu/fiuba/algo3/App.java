package edu.fiuba.algo3;

import edu.fiuba.algo3.vista.ContenedorBienvenidos;
import edu.fiuba.algo3.vista.ContenedorGanador;
import edu.fiuba.algo3.vista.ContenedorJugadores;
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

        ContenedorGanador contenedorGanador = new ContenedorGanador(stage);
        Scene ecsenaGanador = new Scene (contenedorGanador, 1700, 900);

        ContenedorJugadores contenedorJugadores =  new ContenedorJugadores(stage, ecsenaGanador);
        Scene escenaJugadores = new Scene (contenedorJugadores, 1700, 900);

        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos (stage, escenaJugadores, javaVersion, javafxVersion);
        Scene escenaBienvenidos = new Scene(contenedorBienvenidos, 1700, 900);

        stage.setScene(escenaBienvenidos);

        //stage.setFullScreen(true);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }


    /*
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        var scene = new Scene(new StackPane(label), 640, 480);
        stage.setScene(scene);
        stage.show();
     */

}