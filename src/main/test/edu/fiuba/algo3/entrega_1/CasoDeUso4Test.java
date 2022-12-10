package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Area.Coordenada;
import edu.fiuba.algo3.modelo.Area.EstadoOcupacion.Desocupada;
import edu.fiuba.algo3.modelo.Area.EstadoPiso.TieneMoho;
import edu.fiuba.algo3.modelo.Area.TipoArea.AreaTierra;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.RangoMoho;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Extractor.Extractor;
import edu.fiuba.algo3.modelo.Excepciones.ExtractorLlenoException;
import edu.fiuba.algo3.modelo.Excepciones.RecursoInsuficienteException;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.GasVespeno;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Zangano;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CasoDeUso4Test {
    //Ver como resolver el tema de que una sola entidad puede ocupar un area.
    @Test
    public void test01UnExtractorNoGeneraGasSinZanganos() {
        Raza raza = new Raza();
        raza.recolectarMineral(100);

        Extractor extractor = new Extractor(areaParaProbar(), raza);
        pasarKTurnos(extractor, 6);

        extractor.pasarTurno();

        assertThrows(RecursoInsuficienteException.class, () -> raza.gastarRecursos(0, 1));
    }

    @Test
    public void test02UnExtractorGeneraDiezGasConUnZangano() {
        Raza raza = new Raza();
        raza.recolectarMineral(100);

        Extractor extractor = new Extractor(areaParaProbar(), raza);
        pasarKTurnos(extractor, 6);

        Zangano zangano = new Zangano(raza);
        zangano.pasarTurno();
        extractor.agregarZangano(zangano);
        extractor.pasarTurno();

        assertThrows(RecursoInsuficienteException.class, () -> raza.gastarRecursos(0, 11));
        assertDoesNotThrow(() -> raza.gastarRecursos(0, 10));
    }

    @Test
    public void test03UnExtractorGeneraVeinteGasConDosZanganos() {
        Raza raza = new Raza();
        raza.recolectarMineral(100);

        Extractor extractor = new Extractor(areaParaProbar(), raza);
        pasarKTurnos(extractor, 6);

        Zangano zangano = new Zangano(raza);
        zangano.pasarTurno();
        extractor.agregarZangano(zangano);
        extractor.agregarZangano(zangano);
        extractor.pasarTurno();

        assertThrows(RecursoInsuficienteException.class, () -> raza.gastarRecursos(0, 21));
        assertDoesNotThrow(() -> raza.gastarRecursos(0, 20));
    }

    @Test
    public void test04UnExtractorGeneraTreintaGasConTresZanganos() {
        Raza raza = new Raza();
        raza.recolectarMineral(100);

        Extractor extractor = new Extractor(areaParaProbar(), raza);
        pasarKTurnos(extractor, 6);

        Zangano zangano = new Zangano(raza);
        zangano.pasarTurno();
        extractor.agregarZangano(zangano);
        extractor.agregarZangano(zangano);
        extractor.agregarZangano(zangano);
        extractor.pasarTurno();

        assertThrows(RecursoInsuficienteException.class, () -> raza.gastarRecursos(0, 31));
        assertDoesNotThrow(() -> raza.gastarRecursos(0, 30));
    }

    @Test
    public void test05UnExtractorNoAdmiteMasDeTresZanganos() {
        Raza raza = new Raza();
        raza.recolectarMineral(100);

        Extractor extractor = new Extractor(areaParaProbar(), raza);
        pasarKTurnos(extractor, 6);

        Zangano zangano = new Zangano(raza);
        zangano.pasarTurno();
        extractor.agregarZangano(zangano);
        extractor.agregarZangano(zangano);
        extractor.agregarZangano(zangano);

        assertThrows(ExtractorLlenoException.class, () -> extractor.agregarZangano(zangano));
    }

    public void pasarKTurnos(Estructura estructura, Integer k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }

    public Area areaParaProbar() {
        return new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneMoho(), new GasVespeno());
    }
}