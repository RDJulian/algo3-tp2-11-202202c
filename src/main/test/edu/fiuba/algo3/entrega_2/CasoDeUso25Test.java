package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Excepciones.JugadoresNoCompatiblesException;
import edu.fiuba.algo3.modelo.Excepciones.NombreNoValidoException;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Raza.Protoss;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Raza.Zerg;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso25Test {
    //Los colores probablemente sean valores RGB.
    //Las Razas se plantearan como singletons. Van a ser facilmente comparables.
    @Test
    public void test01UnJugadorNoPuedeTenerUnNombreConMenosDeSeisCaracteres() {
        Juego juego = new Juego();
        Raza unaRaza = new Zerg();
        Raza otraRaza = new Protoss();
        assertThrows(NombreNoValidoException.class, () -> juego.registrarJugadores("Pepe",
                "amarillo", unaRaza, "Carlos", "verde", otraRaza));
        assertDoesNotThrow(() -> juego.registrarJugadores("Esteban",
                "amarillo", unaRaza, "Carlos", "verde", otraRaza));
    }

    @Test
    public void test02UnJugadorNoPuedeTenerElMismoNombreOElMismoColorOLaMismaRazaQueElOtroJugador() {
        Juego juego = new Juego();
        Raza unaRaza = new Zerg();
        Raza otraRaza = new Protoss();
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
