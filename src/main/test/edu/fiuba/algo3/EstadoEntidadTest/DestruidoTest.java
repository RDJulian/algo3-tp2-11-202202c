package edu.fiuba.algo3.EstadoEntidadTest;

import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Area.Coordenada;
import edu.fiuba.algo3.modelo.Area.EstadoOcupacion.Desocupada;
import edu.fiuba.algo3.modelo.Area.EstadoPiso.TieneEnergiaPilon;
import edu.fiuba.algo3.modelo.Area.Recurso.RecursoNull;
import edu.fiuba.algo3.modelo.Area.TipoArea.AreaTierra;
import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Pilon;
import edu.fiuba.algo3.modelo.Entidad.Estructura.PuertoEstelar;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Guardian;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Excepciones.EntidadDestruidaException;
import edu.fiuba.algo3.modelo.Excepciones.EntidadNoOperativaException;
import edu.fiuba.algo3.modelo.Raza.Protoss;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DestruidoTest {
    @Test
    public void test01UnPilonDestruidoNoAportaSuministro() {
        Pilon pilon = new Pilon();
        pasarKTurnos(pilon, 5);

        Protoss protoss = new Protoss();

        protoss.registrarEntidad(pilon);

        assertEquals(5, protoss.suministroRestante());

        pilon.destruir();
        protoss.registrarEntidad(pilon);
        assertEquals(0, protoss.suministroRestante());
    }

    @Test
    public void test02UnPuertoEstelarDestruidoNoPuedePermitirCorrelatividad() {
        PuertoEstelar puertoEstelar = new PuertoEstelar(new Area(0, 0));
        pasarKTurnos(puertoEstelar, 10);
        puertoEstelar.destruir();

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