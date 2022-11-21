package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Construible.*;
import edu.fiuba.algo3.modelo.Entidad.Estructura.*;
import edu.fiuba.algo3.modelo.Entidad.Unidad.*;
import edu.fiuba.algo3.modelo.EstadoEntidad.Operativa;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Excepciones.EntidadNoOperativaException;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso22Test {
    //Se deberia hacer constructores para cada Unidad, asi se puede chequear tanto costo como correlativas.
    //No dice nada del AmoSupremo, por lo que asumimos que se genera en cualquier momento.
    //Ademas, asumimos que una unidad Zerg REQUIERE un criadero, porque los criaderos generan larvas.
    //Lo obviamos en este test por el momento por simplicidad.
    @Test
    public void test01UnAmoSupremoSoloSeConstruyeConLaEstructuraQueLoHabilitaYLuegoTardaLoEstipuladoEnConstruirse() {
        Unidad unidad = new AmoSupremo(new Posicion(0, 0));

        assertThrows(EntidadNoOperativaException.class, unidad::operable);

        pasarKTurnos(unidad, 5);

        assertDoesNotThrow(unidad::operable);
    }

    @Test
    public void test02UnDevoradorSoloSeConstruyeConLaEstructuraQueLoHabilitaYLuegoTardaLoEstipuladoEnConstruirse() {
        Unidad unidad = new Devorador(new Posicion(0, 0));

        assertThrows(EntidadNoOperativaException.class, unidad::operable);

        pasarKTurnos(unidad, 4);

        assertDoesNotThrow(unidad::operable);
    }

    @Test
    public void test03UnDragonSoloSeConstruyeConLaEstructuraQueLoHabilitaYLuegoTardaLoEstipuladoEnConstruirse() {
        //Simulamos el comportamiento de un futuro constructor, que haria este chequeo.
        Construible construible = new RequiereAcceso();
        Estructura estructura = new Acceso(new Posicion(0, 0));
        estructura.setEstado(new Operativa());
        Estructura otraEstructura = new Pilon(new Posicion(0, 0));
        estructura.setEstado(new Operativa());
        estructura.construible(construible);

        assertThrows(ConstruccionNoValidaException.class, () -> otraEstructura.construible(construible));

        Unidad unidad = new Dragon(new Posicion(0, 0));

        assertThrows(EntidadNoOperativaException.class, unidad::operable);

        pasarKTurnos(unidad, 6);

        assertDoesNotThrow(unidad::operable);
    }

    @Test
    public void test04UnGuardianSoloSeConstruyeConLaEstructuraQueLoHabilitaYLuegoTardaLoEstipuladoEnConstruirse() {
        Unidad unidad = new Guardian(new Posicion(0, 0));

        assertThrows(EntidadNoOperativaException.class, unidad::operable);

        pasarKTurnos(unidad, 4);

        assertDoesNotThrow(unidad::operable);
    }

    @Test
    public void test05UnHidraliscoSoloSeConstruyeConLaEstructuraQueLoHabilitaYLuegoTardaLoEstipuladoEnConstruirse() {
        Construible construible = new RequiereGuarida();
        Estructura estructura = new Guarida(new Posicion(0, 0));
        estructura.setEstado(new Operativa());
        Estructura otraEstructura = new Pilon(new Posicion(0, 0));
        estructura.setEstado(new Operativa());
        estructura.construible(construible);

        assertThrows(ConstruccionNoValidaException.class, () -> otraEstructura.construible(construible));

        Unidad unidad = new Hidralisco(new Posicion(0, 0));

        assertThrows(EntidadNoOperativaException.class, unidad::operable);

        pasarKTurnos(unidad, 4);

        assertDoesNotThrow(unidad::operable);
    }

    @Test
    public void test06UnMutaliscoSoloSeConstruyeConLaEstructuraQueLoHabilitaYLuegoTardaLoEstipuladoEnConstruirse() {
        Construible construible = new RequiereEspiral();
        Estructura estructura = new Espiral(new Posicion(0, 0));
        estructura.setEstado(new Operativa());
        Estructura otraEstructura = new Pilon(new Posicion(0, 0));
        estructura.setEstado(new Operativa());
        estructura.construible(construible);

        assertThrows(ConstruccionNoValidaException.class, () -> otraEstructura.construible(construible));

        Unidad unidad = new Mutalisco(new Posicion(0, 0));

        assertThrows(EntidadNoOperativaException.class, unidad::operable);

        pasarKTurnos(unidad, 7);

        assertDoesNotThrow(unidad::operable);
    }

    @Test
    public void test07UnScoutSoloSeConstruyeConLaEstructuraQueLoHabilitaYLuegoTardaLoEstipuladoEnConstruirse() {
        Construible construible = new RequierePuertoEstelar();
        Estructura estructura = new PuertoEstelar(new Posicion(0, 0));
        estructura.setEstado(new Operativa());
        Estructura otraEstructura = new Pilon(new Posicion(0, 0));
        estructura.setEstado(new Operativa());
        estructura.construible(construible);

        assertThrows(ConstruccionNoValidaException.class, () -> otraEstructura.construible(construible));

        Unidad unidad = new Scout(new Posicion(0, 0));

        assertThrows(EntidadNoOperativaException.class, unidad::operable);

        pasarKTurnos(unidad, 9);

        assertDoesNotThrow(unidad::operable);
    }

    @Test
    public void test08UnZanganoSoloSeConstruyeConLaEstructuraQueLoHabilitaYLuegoTardaLoEstipuladoEnConstruirse() {
        Construible construible = new RequiereCriadero();
        Estructura estructura = new Criadero(new Posicion(0, 0));
        estructura.setEstado(new Operativa());
        Estructura otraEstructura = new Pilon(new Posicion(0, 0));
        estructura.setEstado(new Operativa());
        estructura.construible(construible);

        assertThrows(ConstruccionNoValidaException.class, () -> otraEstructura.construible(construible));

        Unidad unidad = new Zangano(new Posicion(0, 0));

        assertThrows(EntidadNoOperativaException.class, unidad::operable);

        pasarKTurnos(unidad, 1);

        assertDoesNotThrow(unidad::operable);
    }

    @Test
    public void test09UnZealotSoloSeConstruyeConLaEstructuraQueLoHabilitaYLuegoTardaLoEstipuladoEnConstruirse() {
        Construible construible = new RequiereAcceso();
        Estructura estructura = new Acceso(new Posicion(0, 0));
        estructura.setEstado(new Operativa());
        Estructura otraEstructura = new Pilon(new Posicion(0, 0));
        estructura.setEstado(new Operativa());
        estructura.construible(construible);

        assertThrows(ConstruccionNoValidaException.class, () -> otraEstructura.construible(construible));

        Unidad unidad = new Zealot(new Posicion(0, 0));

        assertThrows(EntidadNoOperativaException.class, unidad::operable);

        pasarKTurnos(unidad, 4);

        assertDoesNotThrow(unidad::operable);
    }

    @Test
    public void test10UnZerlingSoloSeConstruyeConLaEstructuraQueLoHabilitaYLuegoTardaLoEstipuladoEnConstruirse() {
        Construible construible = new RequiereReservaDeReproduccion();
        Estructura estructura = new ReservaDeReproduccion(new Posicion(0, 0));
        estructura.setEstado(new Operativa());
        Estructura otraEstructura = new Pilon(new Posicion(0, 0));
        estructura.setEstado(new Operativa());
        estructura.construible(construible);

        assertThrows(ConstruccionNoValidaException.class, () -> otraEstructura.construible(construible));

        Unidad unidad = new Zerling(new Posicion(0, 0));

        assertThrows(EntidadNoOperativaException.class, unidad::operable);

        pasarKTurnos(unidad, 2);

        assertDoesNotThrow(unidad::operable);
    }

    public void pasarKTurnos(Unidad unidad, int k) {
        for (int i = 0; i < k; i++) {
            unidad.pasarTurno();
        }
    }
}
