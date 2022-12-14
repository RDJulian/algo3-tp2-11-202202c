package edu.fiuba.algo3.ConstruibleTest;

import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Area.Coordenada;
import edu.fiuba.algo3.modelo.Area.EstadoOcupacion.Desocupada;
import edu.fiuba.algo3.modelo.Area.EstadoPiso.TieneEnergiaPilon;
import edu.fiuba.algo3.modelo.Area.EstadoPiso.TieneMoho;
import edu.fiuba.algo3.modelo.Area.Recurso.RecursoNull;
import edu.fiuba.algo3.modelo.Area.TipoArea.AreaTierra;
import edu.fiuba.algo3.modelo.Entidad.Estructura.*;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero.Criadero;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Extractor.Extractor;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Raza.Protoss;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Raza.Zerg;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ConstruibleTest {
    //Se agregan estructuras que no corresponden a la Raza con el proposito de cubrir todos los casos posibles.
    @Test
    public void test01UnaUnidadQueRequiereUnCriaderoNoSePuedeConstruirConNingunaOtraEstructura() {
        Zerg zerg = new Zerg(1000, 1000);

        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(new Acceso());
        estructuras.add(new Espiral());
        estructuras.add(new Guarida());
        estructuras.add(new PuertoEstelar());
        estructuras.add(new ReservaDeReproduccion());
        estructuras.add(new Extractor());
        estructuras.add(estructuraMockeadaParaSuministro());

        for (Estructura estructura : estructuras) {
            zerg.registrarEntidad(estructura);
        }

        pasarKTurnos(zerg, 12);
        for (int i = 0; i < 6; i++) {
            assertThrows(ConstruccionNoValidaException.class, () -> zerg.construirZangano(areaZerg()));
            estructuras.remove(0);
        }
    }

    @Test
    public void test02UnaUnidadQueRequiereUnAccesoNoSePuedeConstruirConNingunaOtraEstructura() {
        Protoss protoss = new Protoss(1000, 1000);

        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(new Criadero());
        estructuras.add(new Espiral());
        estructuras.add(new Guarida());
        estructuras.add(new PuertoEstelar());
        estructuras.add(new ReservaDeReproduccion());
        estructuras.add(new Extractor());
        estructuras.add(estructuraMockeadaParaSuministro());

        for (Estructura estructura : estructuras) {
            protoss.registrarEntidad(estructura);
        }

        pasarKTurnos(protoss, 12);
        for (int i = 0; i < 6; i++) {
            assertThrows(ConstruccionNoValidaException.class, () -> protoss.construirZealot(areaProtoss()));
            estructuras.remove(0);
        }
    }

    @Test
    public void test03UnaUnidadQueRequiereUnEspiralNoSePuedeConstruirConNingunaOtraEstructura() {
        Zerg zerg = new Zerg(1000, 1000);

        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(new Criadero());
        estructuras.add(new Acceso());
        estructuras.add(new Guarida());
        estructuras.add(new PuertoEstelar());
        estructuras.add(new ReservaDeReproduccion());
        estructuras.add(new Extractor());
        estructuras.add(estructuraMockeadaParaSuministro());

        for (Estructura estructura : estructuras) {
            zerg.registrarEntidad(estructura);
        }

        pasarKTurnos(zerg, 12);
        for (int i = 0; i < 6; i++) {
            assertThrows(ConstruccionNoValidaException.class, () -> zerg.construirMutalisco(areaZerg()));
            estructuras.remove(0);
        }
    }

    @Test
    public void test04UnaUnidadQueRequiereUnaGuaridaNoSePuedeConstruirConNingunaOtraEstructura() {
        Zerg zerg = new Zerg(1000, 1000);

        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(new Criadero());
        estructuras.add(new Espiral());
        estructuras.add(new Acceso());
        estructuras.add(new PuertoEstelar());
        estructuras.add(new ReservaDeReproduccion());
        estructuras.add(new Extractor());
        estructuras.add(estructuraMockeadaParaSuministro());

        for (Estructura estructura : estructuras) {
            zerg.registrarEntidad(estructura);
        }

        pasarKTurnos(zerg, 12);
        for (int i = 0; i < 6; i++) {
            assertThrows(ConstruccionNoValidaException.class, () -> zerg.construirHidralisco(areaZerg()));
            estructuras.remove(0);
        }
    }

    @Test
    public void test05UnaUnidadQueRequiereUnPuertoEstelarNoSePuedeConstruirConNingunaOtraEstructura() {
        Protoss protoss = new Protoss(1000, 1000);

        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(new Criadero());
        estructuras.add(new Espiral());
        estructuras.add(new Guarida());
        estructuras.add(new Acceso());
        estructuras.add(new ReservaDeReproduccion());
        estructuras.add(new Extractor());
        estructuras.add(estructuraMockeadaParaSuministro());

        for (Estructura estructura : estructuras) {
            protoss.registrarEntidad(estructura);
        }

        pasarKTurnos(protoss, 12);
        for (int i = 0; i < 6; i++) {
            assertThrows(ConstruccionNoValidaException.class, () -> protoss.construirScout(areaProtoss()));
            estructuras.remove(0);
        }
    }

    @Test
    public void test06UnaUnidadQueRequiereUnaReservaDeReproduccionNoSePuedeConstruirConNingunaOtraEstructura() {
        Zerg zerg = new Zerg(1000, 1000);

        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(new Criadero());
        estructuras.add(new Espiral());
        estructuras.add(new Guarida());
        estructuras.add(new PuertoEstelar());
        estructuras.add(new Acceso());
        estructuras.add(new Extractor());
        estructuras.add(estructuraMockeadaParaSuministro());

        for (Estructura estructura : estructuras) {
            zerg.registrarEntidad(estructura);
        }

        pasarKTurnos(zerg, 12);
        for (int i = 0; i < 6; i++) {
            assertThrows(ConstruccionNoValidaException.class, () -> zerg.construirZerling(areaZerg()));
            estructuras.remove(0);
        }
    }

    public void pasarKTurnos(Raza raza, int k) {
        for (int i = 0; i < k; i++) {
            raza.pasarTurno();
        }
    }

    public Area areaProtoss() {
        return new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneEnergiaPilon(), new RecursoNull());
    }

    public Area areaZerg() {
        return new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneMoho(), new RecursoNull());
    }

    public Estructura estructuraMockeadaParaSuministro() {
        Estructura estructura = mock(Estructura.class);
        when(estructura.afectarSuministro(any(int.class))).thenReturn(200);
        return estructura;
    }
}