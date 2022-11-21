package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Excepciones.JugadoresNoCompatiblesException;
import edu.fiuba.algo3.modelo.Excepciones.NombreNoValidoException;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Raza.Raza;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso25Test {
    //Los colores probablemente sean los que provee javafx.
    //Las Razas se plantearan como singletons. Solo habra una instancia de ambas por lo que
    //seran facilmente comparables. Se prueba con simples strings porque el comportamiento no cambiaria.
    @Test
    public void test01UnJugadorNoPuedeTenerUnNombreConMenosDeSeisCaracteres() {
        Juego juego = new Juego();
        Raza unaRaza = new Raza();
        Raza otraRaza = new Raza();
        assertThrows(NombreNoValidoException.class, () -> juego.registrarJugadores("Pepe",
                "amarillo", unaRaza, "Carlos", "verde", otraRaza));
        assertDoesNotThrow(() -> juego.registrarJugadores("Esteban",
                "amarillo", unaRaza, "Carlos", "verde", otraRaza));
    }

    @Test
    public void test02UnJugadorNoPuedeTenerElMismoNombreOElMismoColorOLaMismaRazaQueElOtroJugador() {
        Juego juego = new Juego();
        Raza unaRaza = new Raza();
        Raza otraRaza = new Raza();
        assertThrows(JugadoresNoCompatiblesException.class, () -> juego.registrarJugadores("Carlos",
                "amarillo", unaRaza, "Carlos", "verde", otraRaza));

        assertThrows(JugadoresNoCompatiblesException.class, () -> juego.registrarJugadores("Daniel",
                "amarillo", unaRaza, "Martina", "amarillo", otraRaza));

        assertThrows(JugadoresNoCompatiblesException.class, () -> juego.registrarJugadores("Julian",
                "amarillo", unaRaza, "Carlos", "verde", unaRaza));
        assertDoesNotThrow(() -> juego.registrarJugadores("Esteban",
                "amarillo", unaRaza, "Carlos", "verde", otraRaza));
    }
}
