package edu.fiuba.algo3.vista.contenedores;

import edu.fiuba.algo3.vista.Etiquetas.EtiquetaPrincipal;
import edu.fiuba.algo3.vista.botones.BotonDeSalir;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ContenedorGanador extends VBox{

    Stage stage;

    public ContenedorGanador (Stage stage) {
        super();

        //Configuración del Layout
        this.stage = stage;
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        Image imagen = new Image("file:src/main/java/edu/fiuba/algo3/vista/Assets/FondoGanador.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        //Controladores
        EtiquetaPrincipal etiquetaPrincipal = new EtiquetaPrincipal("Felicitaciones al jugor X por haber ganado esta épica batalla!");
        etiquetaPrincipal.setTextFill(Color.GOLDENROD);

        Image imagenMedalla = new Image("file:src/main/java/edu/fiuba/algo3/vista/Assets/medalla.gif");
        ImageView marcoMedalla = new ImageView(imagenMedalla);

        Image imagenConfettiIzquierda = new Image("file:src/main/java/edu/fiuba/algo3/vista/Assets/confetti.gif");
        ImageView marcoConfettiIzquierda = new ImageView(imagenConfettiIzquierda);

        Image imagenConfettiDerecha = new Image("file:src/main/java/edu/fiuba/algo3/vista/Assets/confetti.gif");
        ImageView marcoConfettiDerecha = new ImageView(imagenConfettiDerecha);

        BotonDeSalir botonDeSalir = new BotonDeSalir();

        //Contenedores
        HBox contenedorPincipal = new HBox();
        contenedorPincipal.getChildren().addAll(marcoConfettiIzquierda, marcoMedalla, marcoConfettiDerecha);
        contenedorPincipal.setAlignment(Pos.CENTER);

        this.getChildren().addAll(etiquetaPrincipal, contenedorPincipal, botonDeSalir);
    }
}
