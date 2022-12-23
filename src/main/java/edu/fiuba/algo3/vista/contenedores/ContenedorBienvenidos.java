package edu.fiuba.algo3.vista.contenedores;

import edu.fiuba.algo3.vista.Etiquetas.EtiquetaPrincipal;
import edu.fiuba.algo3.vista.botones.BotonComenzarJuego;
import edu.fiuba.algo3.vista.botones.BotonDeSalir;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.text.Font;

public class ContenedorBienvenidos extends VBox {

    private Stage stage;

    public ContenedorBienvenidos (Stage stage, Scene escenaJugadores, String versionDeJava, String versionDeFX){

        super();

        //Configuraciones del Contenedor.
        this.stage = stage;
        this.setAlignment (Pos.CENTER);
        this.setSpacing (20);
        this.setPadding(new Insets(25));
        Image imagen = new Image("file:src/main/java/edu/fiuba/algo3/vista/Assets/FondoBienvenidos.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        //Controladores
        EtiquetaPrincipal etiquetaPrincipal = new EtiquetaPrincipal("Bienvenidos a AlgoCraft");

        BotonComenzarJuego botonComenzarJuego = new BotonComenzarJuego(stage, escenaJugadores);

        BotonDeSalir botonDeSalir = new BotonDeSalir();

        Image imagenPrincial = new Image("file:src/main/java/edu/fiuba/algo3/vista/Assets/imagenEscenaBienvenidos.png");
        ImageView marco = new ImageView(imagenPrincial);

        Label etiquetaDeEspecificaciones = new Label("JavaFX " + versionDeFX + ", running on Java " + versionDeJava + ".");
        etiquetaDeEspecificaciones.setFont(Font.font("arial", 10));

        //Contenedores
        VBox contenedorPieDePagina = new VBox();
        contenedorPieDePagina.getChildren().add(etiquetaDeEspecificaciones);
        contenedorPieDePagina.setAlignment(Pos.BOTTOM_RIGHT);

        this.getChildren().addAll(etiquetaPrincipal, marco, botonComenzarJuego, botonDeSalir,contenedorPieDePagina);
    }

}
