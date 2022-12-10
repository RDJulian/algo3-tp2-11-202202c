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
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Area.Recurso.GasVespeno;
import edu.fiuba.algo3.modelo.Area.Recurso.Mineral;
import edu.fiuba.algo3.modelo.Area.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Zangano;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

public class CasoDeUso7Test {

    @Test
    public void test01ZanganoObtieneMineralCorrectamenteParaLosZerg() {
        Raza raza = new Raza();
        Recurso recurso = new Mineral();
        Area area = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneMoho(), recurso);

        Zangano zangano = new Zangano(raza, area);
        zangano.pasarTurno();
        zangano.pasarTurno();

        assertThrows(RecursoInsuficienteException.class, () -> raza.gastarRecursos(11, 0));
        assertDoesNotThrow(() -> raza.gastarRecursos(10, 0));
    }

    @Test
    public void test02ExtractorObtieneGasCorrectamenteParaLosZerg() {
        Raza raza = new Raza();
        raza.recolectarMineral(100);
        Recurso recurso = new GasVespeno();
        Area area = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneMoho(), recurso);

        Extractor extractor = new Extractor(area, raza);

        pasarKTurnos(extractor, 6);

        Zangano zangano = new Zangano(raza);
        zangano.pasarTurno();

        extractor.agregarZangano(zangano);
        extractor.pasarTurno();

        assertThrows(RecursoInsuficienteException.class, () -> raza.gastarRecursos(0, 11));
        assertDoesNotThrow(() -> raza.gastarRecursos(0, 10));
    }

    @Test
    public void test03NexoMineralObtieneMineralCorrectamenteParaLosProtoss() {
        Raza raza = new Raza();
        raza.recolectarMineral(50);
        Recurso recurso = new Mineral();
        Area area = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneEnergiaPilon(), recurso);

        NexoMineral nexoMineral = new NexoMineral(area, raza);

        pasarKTurnos(nexoMineral, 4);

        nexoMineral.pasarTurno();

        assertThrows(RecursoInsuficienteException.class, () -> raza.gastarRecursos(21, 0));
        assertDoesNotThrow(() -> raza.gastarRecursos(20, 0));
    }

    @Test
    public void test04AsimiladorObtieneGasCorrectamenteParaLosProtoss() {
        Raza raza = new Raza();
        raza.recolectarMineral(100);
        Recurso recurso = new GasVespeno();
        Area area = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneEnergiaPilon(), recurso);

        Asimilador asimilador = new Asimilador(area, raza);

        pasarKTurnos(asimilador, 6);

        asimilador.pasarTurno();

        assertThrows(RecursoInsuficienteException.class, () -> raza.gastarRecursos(0, 21));
        assertDoesNotThrow(() -> raza.gastarRecursos(0, 20));
    }

    public void pasarKTurnos(Estructura estructura, Integer k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }
}
