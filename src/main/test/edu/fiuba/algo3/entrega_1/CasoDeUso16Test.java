package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Area.Coordenada;
import edu.fiuba.algo3.modelo.Area.EstadoOcupacion.Desocupada;
import edu.fiuba.algo3.modelo.Area.EstadoPiso.TieneEnergiaPilon;
import edu.fiuba.algo3.modelo.Area.EstadoPiso.TieneMoho;
import edu.fiuba.algo3.modelo.Area.TipoArea.AreaTierra;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.ConstructorAsimilador;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.ConstructorEstructuras;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.ConstructorNexoMineral;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.ConstructorPilon;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Excepciones.PosicionOcupadaException;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Protoss;
import edu.fiuba.algo3.modelo.Area.Recurso.GasVespeno;
import edu.fiuba.algo3.modelo.Area.Recurso.Mineral;
import edu.fiuba.algo3.modelo.Area.Recurso.RecursoNull;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Zangano;
import edu.fiuba.algo3.modelo.Raza.Zerg;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

public class CasoDeUso16Test {
    //Supuesto, engloba al caso de uso.
    @Test
    public void test01UnaEstructuraNoSePuedeConstruirSobreOtra() {
        Protoss raza = mock(Protoss.class);
        ConstructorEstructuras constructor = new ConstructorPilon(new ArrayList<>(), raza);

        Area area = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneEnergiaPilon(), new RecursoNull());

        constructor.construir(area);
        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(area));
    }

    @Test
    public void test02UnaEstructuraNoSePuedeConstruirSobreUnVolcanConUnaEstructura() {
        Protoss raza = mock(Protoss.class);
        ConstructorEstructuras constructor = new ConstructorAsimilador(new ArrayList<>(), raza);

        Area area = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneEnergiaPilon(), new GasVespeno());

        constructor.construir(area);
        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(area));
    }

    @Test
    public void test03UnNexoMineralNoSePuedeConstruirSiUnZanganoEstaExtrayendo() {
        Protoss raza = mock(Protoss.class);
        Zerg zerg = mock(Zerg.class);
        ConstructorEstructuras constructor = new ConstructorNexoMineral(new ArrayList<>(), raza);

        Area area = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneEnergiaPilon(), new Mineral());
        Area otraArea = new Area(new Coordenada(1, 1), new AreaTierra(), new Desocupada(), new TieneMoho(), new RecursoNull());

        Zangano zangano = new Zangano(otraArea, zerg);
        zangano.pasarTurno();

        zangano.moverse(area);

        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(area));
    }

    //Suponemos que no puede ni siquiera ir a esa posicion/ocupar ese mineral porque esta el Nexo.
    @Test
    public void test04UnZanganoNoPuedeExtraerMineralSiUnNexoMineralEstaConstruido() {
        Protoss raza = mock(Protoss.class);
        Zerg zerg = mock(Zerg.class);
        ConstructorEstructuras constructor = new ConstructorNexoMineral(new ArrayList<>(), raza);

        Area area = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneEnergiaPilon(), new Mineral());
        Area otraArea = new Area(new Coordenada(1, 1), new AreaTierra(), new Desocupada(), new TieneMoho(), new RecursoNull());

        Zangano zangano = new Zangano(otraArea, zerg);
        zangano.pasarTurno();

        constructor.construir(area);

        assertThrows(PosicionOcupadaException.class, () -> zangano.moverse(area));
    }
}
