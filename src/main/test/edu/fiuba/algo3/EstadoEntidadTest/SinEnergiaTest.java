package edu.fiuba.algo3.EstadoEntidadTest;

import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Area.Coordenada;
import edu.fiuba.algo3.modelo.Area.EstadoOcupacion.Desocupada;
import edu.fiuba.algo3.modelo.Area.EstadoPiso.TieneEnergiaPilon;
import edu.fiuba.algo3.modelo.Area.EstadoPiso.TieneMoho;
import edu.fiuba.algo3.modelo.Area.Recurso.RecursoNull;
import edu.fiuba.algo3.modelo.Area.TipoArea.AreaTierra;
import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.EstadoEntidad.EstadoOperativo.SinEnergia;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero.Criadero;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Pilon;
import edu.fiuba.algo3.modelo.Entidad.Estructura.PuertoEstelar;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Devorador;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Guardian;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Excepciones.EntidadDestruidaException;
import edu.fiuba.algo3.modelo.Excepciones.EntidadNoOperativaException;
import edu.fiuba.algo3.modelo.Raza.Protoss;
import edu.fiuba.algo3.modelo.Raza.Zerg;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SinEnergiaTest {
    @Test
    public void test01UnPilonSinEnergiaNoAportaSuministro() {
        Pilon pilon = new Pilon();
        pasarKTurnos(pilon, 5);

        Protoss protoss = new Protoss();

        protoss.registrarEntidad(pilon);

        assertEquals(5, protoss.suministroRestante());

        pilon.desenergizar();
        assertEquals(0, protoss.suministroRestante());
    }

    @Test
    public void test02UnPuertoEstelarSinEnergiaEsAtacable() {
        PuertoEstelar puertoEstelar = new PuertoEstelar(new Area(0, 0));
        puertoEstelar.actualizarEstado();

        Guardian guardian = new Guardian(new Area(1, 1));
        pasarKTurnos(guardian, 4);
        assertDoesNotThrow(() -> guardian.atacar(puertoEstelar));
    }

    @Test
    public void test03UnPuertoEstelarSinEnergiaNoEsOperable() {
        PuertoEstelar puertoEstelar = new PuertoEstelar(new Area(0, 0));
        pasarKTurnos(puertoEstelar, 10);
        puertoEstelar.actualizarEstado();

        assertThrows(EntidadNoOperativaException.class, puertoEstelar::operable);
    }

    @Test
    public void test04UnPuertoEstelarSinEnergiaNoRegeneraSuEscudoAlPasarTurnos() {
        PuertoEstelar puertoEstelar = new PuertoEstelar(new Area(0, 0));
        puertoEstelar.actualizarEstado();

        puertoEstelar.daniar(1199);
        puertoEstelar.pasarTurno();

        //Deberia tener 20E/1V
        puertoEstelar.pasarTurno();

        puertoEstelar.daniar(1);

        assertThrows(EntidadDestruidaException.class, puertoEstelar::operable);
    }

    @Test
    public void test05UnPuertoEstelarSinEnergiaNoPuedePermitirCorrelatividad() {
        PuertoEstelar puertoEstelar = new PuertoEstelar(new Area(0, 0));
        pasarKTurnos(puertoEstelar, 10);
        puertoEstelar.actualizarEstado();

        Protoss protoss = new Protoss(300, 150);
        protoss.registrarEntidad(puertoEstelar);

        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.afectarSuministro(any(int.class))).thenReturn(200);
        protoss.registrarEntidad(estructuraMock);

        Area area = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneEnergiaPilon(), new RecursoNull());

        assertThrows(ConstruccionNoValidaException.class, () -> protoss.construirScout(area));
    }

    public void pasarKTurnos(Entidad entidad, int k) {
        for (int i = 0; i < k; i++) {
            entidad.pasarTurno();
        }
    }
}