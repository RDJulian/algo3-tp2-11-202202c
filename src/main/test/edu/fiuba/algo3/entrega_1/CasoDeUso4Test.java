package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Area.Coordenada;
import edu.fiuba.algo3.modelo.Area.EstadoOcupacion.Desocupada;
import edu.fiuba.algo3.modelo.Area.EstadoPiso.TieneMoho;
import edu.fiuba.algo3.modelo.Area.TipoArea.AreaTierra;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Extractor.Extractor;
import edu.fiuba.algo3.modelo.Excepciones.ExtractorLlenoException;
import edu.fiuba.algo3.modelo.Excepciones.RecursoInsuficienteException;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Protoss;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Area.Recurso.GasVespeno;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Zangano;
import edu.fiuba.algo3.modelo.Raza.Zerg;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

public class CasoDeUso4Test {
    @Test
    public void test01UnExtractorNoGeneraGasSinZanganos() {
        reiniciarRazas();
        Zerg zerg = Zerg.obtenerInstancia();
        zerg.recolectarMineral(100);

        Extractor extractor = new Extractor(areaParaProbar(), zerg);
        pasarKTurnos(extractor, 6);

        extractor.pasarTurno();

        assertThrows(RecursoInsuficienteException.class, () -> zerg.gastarRecursos(0, 1));
    }

    @Test
    public void test02UnExtractorGeneraDiezGasConUnZangano() {
        reiniciarRazas();
        Zerg zerg = Zerg.obtenerInstancia();
        zerg.recolectarMineral(100);

        Area area = areaParaProbar();

        Extractor extractor = new Extractor(area, zerg);
        pasarKTurnos(extractor, 6);

        Zangano zangano = new Zangano(otraAreaParaProbar(), zerg);
        zangano.pasarTurno();

        zangano.moverse(area);

        extractor.pasarTurno();

        assertThrows(RecursoInsuficienteException.class, () -> zerg.gastarRecursos(0, 11));
        assertDoesNotThrow(() -> zerg.gastarRecursos(0, 10));
    }

    @Test
    public void test03UnExtractorGeneraVeinteGasConDosZanganos() {
        reiniciarRazas();
        Zerg zerg = Zerg.obtenerInstancia();
        zerg.recolectarMineral(100);

        Area area = areaParaProbar();

        Extractor extractor = new Extractor(area, zerg);
        pasarKTurnos(extractor, 6);

        Zangano zangano1 = new Zangano(otraAreaParaProbar(), zerg);
        zangano1.pasarTurno();

        Zangano zangano2 = new Zangano(otraAreaParaProbar(), zerg);
        zangano2.pasarTurno();

        zangano1.moverse(area);
        zangano2.moverse(area);

        extractor.pasarTurno();

        assertThrows(RecursoInsuficienteException.class, () -> zerg.gastarRecursos(0, 21));
        assertDoesNotThrow(() -> zerg.gastarRecursos(0, 20));
    }

    @Test
    public void test04UnExtractorGeneraTreintaGasConTresZanganos() {
        reiniciarRazas();
        Zerg zerg = Zerg.obtenerInstancia();
        zerg.recolectarMineral(100);

        Area area = areaParaProbar();

        Extractor extractor = new Extractor(area, zerg);
        pasarKTurnos(extractor, 6);

        Zangano zangano1 = new Zangano(otraAreaParaProbar(), zerg);
        zangano1.pasarTurno();

        Zangano zangano2 = new Zangano(otraAreaParaProbar(), zerg);
        zangano2.pasarTurno();

        Zangano zangano3 = new Zangano(otraAreaParaProbar(), zerg);
        zangano3.pasarTurno();

        zangano1.moverse(area);
        zangano2.moverse(area);
        zangano3.moverse(area);

        extractor.pasarTurno();

        assertThrows(RecursoInsuficienteException.class, () -> zerg.gastarRecursos(0, 31));
        assertDoesNotThrow(() -> zerg.gastarRecursos(0, 30));
    }

    @Test
    public void test05UnExtractorNoAdmiteMasDeTresZanganos() {
        reiniciarRazas();
        Zerg zerg = Zerg.obtenerInstancia();
        zerg.recolectarMineral(100);

        Area area = areaParaProbar();

        Extractor extractor = new Extractor(area, zerg);
        pasarKTurnos(extractor, 6);

        Zangano zangano1 = new Zangano(otraAreaParaProbar(), zerg);
        zangano1.pasarTurno();

        Zangano zangano2 = new Zangano(otraAreaParaProbar(), zerg);
        zangano2.pasarTurno();

        Zangano zangano3 = new Zangano(otraAreaParaProbar(), zerg);
        zangano3.pasarTurno();

        Zangano zangano4 = new Zangano(otraAreaParaProbar(), zerg);
        zangano4.pasarTurno();

        assertDoesNotThrow(() -> zangano1.moverse(area));
        assertDoesNotThrow(() -> zangano2.moverse(area));
        assertDoesNotThrow(() -> zangano3.moverse(area));
        assertThrows(ExtractorLlenoException.class, () -> zangano4.moverse(area));
    }

    public void pasarKTurnos(Estructura estructura, Integer k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }

    public Area areaParaProbar() {
        return new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneMoho(), new GasVespeno());
    }

    public Area otraAreaParaProbar() {
        return new Area(new Coordenada(1, 0), new AreaTierra(), new Desocupada(), new TieneMoho(), new GasVespeno());
    }

    public void reiniciarRazas() {
        Protoss.obtenerInstancia().reiniciar();
        Zerg.obtenerInstancia().reiniciar();
        Protoss.obtenerInstancia().gastarRecursos(200, 0);
        Zerg.obtenerInstancia().gastarRecursos(200, 0);
    }
}