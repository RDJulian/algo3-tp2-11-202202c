package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Area.Coordenada;
import edu.fiuba.algo3.modelo.Area.EstadoOcupacion.Desocupada;
import edu.fiuba.algo3.modelo.Area.EstadoPiso.TieneEnergiaPilon;
import edu.fiuba.algo3.modelo.Area.EstadoPiso.TieneMoho;
import edu.fiuba.algo3.modelo.Area.TipoArea.AreaTierra;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Asimilador;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Extractor.Extractor;
import edu.fiuba.algo3.modelo.Entidad.Estructura.NexoMineral;
import edu.fiuba.algo3.modelo.Excepciones.RecursoInsuficienteException;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Protoss;
import edu.fiuba.algo3.modelo.Area.Recurso.GasVespeno;
import edu.fiuba.algo3.modelo.Area.Recurso.Mineral;
import edu.fiuba.algo3.modelo.Area.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Zangano;
import edu.fiuba.algo3.modelo.Raza.Zerg;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso7Test {

    @Test
    public void test01ZanganoObtieneMineralCorrectamenteParaLosZerg() {
        Zerg zerg = new Zerg(0, 0);

        Recurso recurso = new Mineral();
        Area area = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneMoho(), recurso);

        Zangano zangano = new Zangano(area, zerg);
        zangano.pasarTurno();
        zangano.pasarTurno();

        assertThrows(RecursoInsuficienteException.class, () -> zerg.gastarRecursos(11, 0));
        assertDoesNotThrow(() -> zerg.gastarRecursos(10, 0));
    }

    @Test
    public void test02ExtractorObtieneGasCorrectamenteParaLosZerg() {
        Zerg zerg = new Zerg(0, 0);

        zerg.recolectarMineral(100);
        Recurso recurso = new GasVespeno();
        Area area = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneMoho(), recurso);

        Extractor extractor = new Extractor(area, zerg);

        pasarKTurnos(extractor, 6);

        Zangano zangano = new Zangano(area, zerg);
        zangano.pasarTurno();

        extractor.agregarZangano(zangano);
        extractor.pasarTurno();

        assertThrows(RecursoInsuficienteException.class, () -> zerg.gastarRecursos(0, 11));
        assertDoesNotThrow(() -> zerg.gastarRecursos(0, 10));
    }

    @Test
    public void test03NexoMineralObtieneMineralCorrectamenteParaLosProtoss() {
        Protoss protoss = new Protoss(0, 0);

        protoss.recolectarMineral(50);
        Recurso recurso = new Mineral();
        Area area = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneEnergiaPilon(), recurso);

        NexoMineral nexoMineral = new NexoMineral(area, protoss);

        pasarKTurnos(nexoMineral, 4);

        nexoMineral.pasarTurno();

        assertThrows(RecursoInsuficienteException.class, () -> protoss.gastarRecursos(21, 0));
        assertDoesNotThrow(() -> protoss.gastarRecursos(20, 0));
    }

    @Test
    public void test04AsimiladorObtieneGasCorrectamenteParaLosProtoss() {
        Protoss protoss = new Protoss(0, 0);

        protoss.recolectarMineral(100);
        Recurso recurso = new GasVespeno();
        Area area = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneEnergiaPilon(), recurso);

        Asimilador asimilador = new Asimilador(area, protoss);

        pasarKTurnos(asimilador, 6);

        asimilador.pasarTurno();

        assertThrows(RecursoInsuficienteException.class, () -> protoss.gastarRecursos(0, 21));
        assertDoesNotThrow(() -> protoss.gastarRecursos(0, 20));
    }

    public void pasarKTurnos(Estructura estructura, Integer k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }
}
