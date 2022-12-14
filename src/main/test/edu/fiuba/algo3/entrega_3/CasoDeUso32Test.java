package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Area.Coordenada;
import edu.fiuba.algo3.modelo.Area.EstadoOcupacion.Desocupada;
import edu.fiuba.algo3.modelo.Area.EstadoPiso.TieneEnergiaPilon;
import edu.fiuba.algo3.modelo.Area.Recurso.RecursoNull;
import edu.fiuba.algo3.modelo.Area.TipoArea.AreaTierra;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero.Criadero;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Pilon;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Mutalisco;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Scout;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Protoss;
import edu.fiuba.algo3.modelo.Raza.Zerg;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso32Test {
    @Test
    public void test01UnJuegoContinuaSiLasDosRazasTienenConstruccionesEnSuAsentamiento() {
        Zerg zerg = new Zerg();
        Protoss protoss = new Protoss();

        Juego juego = new Juego();

        juego.registrarJugadores("Julian", "rojo", zerg, "Franco", "azul", protoss);

        zerg.registrarEntidad(new Criadero(new Area(0, 0)));
        zerg.registrarEntidad(new Mutalisco(new Area(0, 0)));

        protoss.registrarEntidad(new Pilon(new Area(0, 0)));
        protoss.registrarEntidad(new Scout(new Area(0, 0)));

        assertFalse(juego::terminarJuego);
    }

    @Test
    public void test02UnJuegoTerminaSiUnaDeLasDosRazasNoTieneConstruccionesEnSuAsentamiento() {
        Zerg zerg = new Zerg();
        Protoss protoss = new Protoss();

        Juego juego = new Juego();

        juego.registrarJugadores("Julian", "rojo", zerg, "Franco", "azul", protoss);

        zerg.registrarEntidad(new Criadero(new Area(0, 0)));
        zerg.registrarEntidad(new Mutalisco(new Area(0, 0)));

        juego.pasarTurno();

        protoss.recolectarMineral(100);
        Pilon pilon = new Pilon(areaProtoss(), protoss);

        protoss.registrarEntidad(new Scout(new Area(0, 0)));

        assertFalse(juego::terminarJuego);

        pilon.destruir();

        assertTrue(juego::terminarJuego);
    }

    @Test
    public void test03UnJuegoEmpiezaLeTocaAlPrimerJugadorLuegoPasaElTurnoYNoEsElEquipoQueJuega() {
        Zerg zerg = new Zerg();
        Protoss protoss = new Protoss();

        Juego juego = new Juego();

        juego.registrarJugadores("Julian", "rojo", zerg, "Franco", "azul", protoss);

        assertEquals(zerg, juego.razaAJugar());

        juego.pasarTurno();

        assertNotEquals(zerg, juego.razaAJugar());
    }

    public Area areaProtoss() {
        return new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneEnergiaPilon(), new RecursoNull());
    }
}
