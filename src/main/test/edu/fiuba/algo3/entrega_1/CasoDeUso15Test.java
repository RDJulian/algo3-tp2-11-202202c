package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Area.Coordenada;
import edu.fiuba.algo3.modelo.Area.EstadoOcupacion.Desocupada;
import edu.fiuba.algo3.modelo.Area.EstadoPiso.TieneEnergiaPilon;
import edu.fiuba.algo3.modelo.Area.EstadoPiso.TieneMoho;
import edu.fiuba.algo3.modelo.Area.TipoArea.AreaTierra;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Extractor.Extractor;
import edu.fiuba.algo3.modelo.Entidad.Estructura.NexoMineral;
import edu.fiuba.algo3.modelo.Excepciones.RecursoVacioException;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Protoss;
import edu.fiuba.algo3.modelo.Area.Recurso.GasVespeno;
import edu.fiuba.algo3.modelo.Area.Recurso.Mineral;
import edu.fiuba.algo3.modelo.Area.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Zangano;
import edu.fiuba.algo3.modelo.Raza.Zerg;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

public class CasoDeUso15Test {
    @Test
    public void test01ElMineralSePuedeExtraerHastaQueSeQuedeVacioYLuegoNoSePuedeSeguirExtrayendo() {
        Protoss raza = mock(Protoss.class);
        Recurso mineral = new Mineral();

        Area area = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneEnergiaPilon(), mineral);

        NexoMineral nexoMineral = new NexoMineral(area, raza);
        pasarKTurnos(nexoMineral, 4);

        pasarKTurnos(nexoMineral, 99);

        assertDoesNotThrow(nexoMineral::pasarTurno);
        assertThrows(RecursoVacioException.class, nexoMineral::pasarTurno);
    }

    @Test
    public void test02ElGasVespenoSePuedeExtraerHastaQueSeQuedeVacioYLuegoNoSePuedeSeguirExtrayendo() {
        Zerg raza = mock(Zerg.class);
        Recurso mineral = new GasVespeno();

        Area area = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneMoho(), mineral);

        Extractor extractor = new Extractor(area, raza);
        pasarKTurnos(extractor, 6);

        Zangano zangano = new Zangano(area, raza);
        zangano.pasarTurno();
        extractor.agregarZangano(zangano);
        extractor.agregarZangano(zangano);

        pasarKTurnos(extractor, 249);

        assertDoesNotThrow(extractor::pasarTurno);
        assertThrows(RecursoVacioException.class, extractor::pasarTurno);
    }

    public void pasarKTurnos(Estructura estructura, int k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }
}
