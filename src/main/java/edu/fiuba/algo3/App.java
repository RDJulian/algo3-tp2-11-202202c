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

        ContenedorGanador contenedorGanador = new ContenedorGanador();
        Scene ecsenaGanador = new Scene (contenedorGanador, 640, 480);

        ContenedorJugadores contenedorJugadores =  new ContenedorJugadores(stage, ecsenaGanador);
        Scene escenaJugadores = new Scene (contenedorJugadores, 640, 480);

        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos (stage, escenaJugadores);
        Scene escenaBienvenidos = new Scene(contenedorBienvenidos, 640, 480);

        stage.setScene(escenaBienvenidos);


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