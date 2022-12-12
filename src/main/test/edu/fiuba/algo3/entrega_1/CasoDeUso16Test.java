package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Area.Coordenada;
import edu.fiuba.algo3.modelo.Area.EstadoOcupacion.Desocupada;
import edu.fiuba.algo3.modelo.Area.EstadoPiso.TieneEnergiaPilon;
import edu.fiuba.algo3.modelo.Area.TipoArea.AreaTierra;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.ConstructorAsimilador;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.ConstructorEstructuras;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.ConstructorNexoMineral;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.ConstructorPilon;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Excepciones.PosicionOcupadaException;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Area.Recurso.GasVespeno;
import edu.fiuba.algo3.modelo.Area.Recurso.Mineral;
import edu.fiuba.algo3.modelo.Area.Recurso.RecursoNull;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Zangano;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

public class CasoDeUso16Test {
    //Supuesto, engloba al caso de uso.
    @Test
    public void test01UnaEstructuraNoSePuedeConstruirSobreOtra() {
        Raza raza = mock(Raza.class);
        ConstructorEstructuras constructor = new ConstructorPilon(new ArrayList<>(), raza);

        Area area = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneEnergiaPilon(), new RecursoNull());

        constructor.construir(area);
        assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(area));
    }

    @Test
    public void test02UnaEstructuraNoSePuedeConstruirSobreUnVolcanConUnaEstructura() {
        Raza raza = mock(Raza.class);
        ConstructorEstructuras constructor = new ConstructorAsimilador(new ArrayList<>(), raza);

        Area area = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneEnergiaPilon(), new GasVespeno());

        constructor.construir(area);
        assertThrows(PosicionOcupadaException.class, () -> constructor.construir(area));
    }

    @Test
    public void test03UnNexoMineralNoSePuedeConstruirSiUnZanganoEstaExtrayendo() {
        Raza raza = mock(Raza.class);
        ConstructorEstructuras constructor = new ConstructorNexoMineral(new ArrayList<>(), raza);

        Area area = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneEnergiaPilon(), new Mineral());

        Zangano zangano = new Zangano();
        zangano.pasarTurno();

        zangano.moverse(area);

        assertThrows(PosicionOcupadaException.class, () -> constructor.construir(area));
    }

    //Suponemos que no puede ni siquiera ir a esa posicion/ocupar ese mineral porque esta el Nexo.
    @Test
    public void test04UnZanganoNoPuedeExtraerMineralSiUnNexoMineralEstaConstruido() {
        Raza raza = mock(Raza.class);
        ConstructorEstructuras constructor = new ConstructorNexoMineral(new ArrayList<>(), raza);

        Area area = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneEnergiaPilon(), new Mineral());

        Zangano zangano = new Zangano();
        zangano.pasarTurno();

        constructor.construir(area);

        assertThrows(PosicionOcupadaException.class, () -> zangano.moverse(area));
    }
}
