package edu.fiuba.algo3;

import edu.fiuba.algo3.vista.ContenedorBienvenidos;
import edu.fiuba.algo3.vista.ContenedorGanador;
import edu.fiuba.algo3.vista.ContenedorJugadores;
import edu.fiuba.algo3.vista.ContenedorPrincipal;
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
        Scene escenaGanador = new Scene (contenedorGanador, 1280, 720);

        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage, escenaGanador);
        Scene escenaPrincipal = new Scene (contenedorPrincipal, 1280, 720);

        //ContenedorJugadores contenedorJugadores =  new ContenedorJugadores(stage, escenaGanador);
        //Scene escenaJugadores = new Scene (contenedorJugadores, 1280, 720);

        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos (stage, escenaPrincipal, javaVersion, javafxVersion);
        Scene escenaBienvenidos = new Scene(contenedorBienvenidos, 1280, 720);

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