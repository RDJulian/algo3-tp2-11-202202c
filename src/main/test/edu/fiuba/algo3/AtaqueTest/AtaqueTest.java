package edu.fiuba.algo3.AtaqueTest;

import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Area.Coordenada;
import edu.fiuba.algo3.modelo.Area.EstadoOcupacion.Desocupada;
import edu.fiuba.algo3.modelo.Area.EstadoPiso.TieneEnergiaPilon;
import edu.fiuba.algo3.modelo.Area.EstadoPiso.TieneMoho;
import edu.fiuba.algo3.modelo.Area.Recurso.RecursoNull;
import edu.fiuba.algo3.modelo.Area.TipoArea.AreaTierra;
import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero.Criadero;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Pilon;
import edu.fiuba.algo3.modelo.Entidad.Estructura.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Dragon;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Guardian;
import edu.fiuba.algo3.modelo.Excepciones.AtaqueNoValidoException;
import edu.fiuba.algo3.modelo.Excepciones.UnidadYaAtacoException;
import edu.fiuba.algo3.modelo.Raza.Protoss;
import edu.fiuba.algo3.modelo.Raza.Zerg;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class AtaqueTest {
    @Test
    public void test01UnaUnidadZergNoPuedeAtacarAUnaEntidadDelMismoEquipo() {
        Zerg zerg = new Zerg(1000, 1000);
        zerg.registrarEntidad(estructuraMockeadaParaTestear());

        Guardian guardian = new Guardian(areaZerg(), zerg);
        pasarKTurnos(guardian, 4);
        ReservaDeReproduccion criadero = new ReservaDeReproduccion(areaZerg(), zerg);

        assertThrows(AtaqueNoValidoException.class, () -> guardian.atacar(criadero));
    }

    @Test
    public void test02UnaUnidadProtossNoPuedeAtacarAUnaEntidadDelMismoEquipo() {
        Protoss protoss = new Protoss(1000, 1000);
        protoss.registrarEntidad(estructuraMockeadaParaTestear());

        Dragon dragon = new Dragon(areaProtoss(), protoss.getEstructuras(), protoss);
        pasarKTurnos(dragon, 6);
        Pilon pilon = new Pilon(areaProtoss(), protoss);

        assertThrows(AtaqueNoValidoException.class, () -> dragon.atacar(pilon));
    }

    @Test
    public void test03UnaUnidadNoPuedeAtacarMasDeUnaVezPorTurno() {
        Dragon dragon = new Dragon(new Area(0, 0));
        pasarKTurnos(dragon, 6);
        ReservaDeReproduccion reservaDeReproduccion = new ReservaDeReproduccion(new Area(1, 1));

        assertDoesNotThrow(() -> dragon.atacar(reservaDeReproduccion));
        assertThrows(UnidadYaAtacoException.class, () -> dragon.atacar(reservaDeReproduccion));

        dragon.pasarTurno();
        assertDoesNotThrow(() -> dragon.atacar(reservaDeReproduccion));
    }

    public void pasarKTurnos(Entidad entidad, int k) {
        for (int i = 0; i < k; i++) {
            entidad.pasarTurno();
        }
    }

    public Area areaProtoss() {
        return new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneEnergiaPilon(), new RecursoNull());
    }

    public Area areaZerg() {
        return new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneMoho(), new RecursoNull());
    }

    public Criadero estructuraMockeadaParaTestear() {
        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Criadero estructuraMock = mock(Criadero.class);
        when(estructuraMock.construible(any())).thenReturn(true);
        when(estructuraMock.afectarSuministro(any(int.class))).thenReturn(200);
        doNothing().when(estructuraMock).usarLarva();

        return estructuraMock;
    }
}