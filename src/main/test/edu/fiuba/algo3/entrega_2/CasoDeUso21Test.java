package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Area.Coordenada;
import edu.fiuba.algo3.modelo.Area.EstadoOcupacion.Desocupada;
import edu.fiuba.algo3.modelo.Area.EstadoPiso.TieneMoho;
import edu.fiuba.algo3.modelo.Area.Recurso.RecursoNull;
import edu.fiuba.algo3.modelo.Area.TipoArea.AreaTierra;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorUnidades.ConstructorMutalisco;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorUnidades.ConstructorUnidades;
import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Entidad.Entidad;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero.Criadero;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Mutalisco;
import edu.fiuba.algo3.modelo.Excepciones.EntidadNoOperativaException;
import edu.fiuba.algo3.modelo.Excepciones.EvolucionNoValidaException;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Zerg;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class CasoDeUso21Test {
    @Test
    public void test01UnGuardianNoPuedeEvolucionarSiNoSeCuentanConLosRecursosYSiEstaConstruido() {
        Zerg zerg = new Zerg(0, 0);
        zerg.registrarEntidad(estructuraMockeadaParaTestear());
        zerg.recolectarMineral(100);
        zerg.recolectarGas(100);

        ConstructorUnidades constructor = new ConstructorMutalisco(zerg.getEstructuras(), zerg);
        Area area = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneMoho(), new RecursoNull());
        Mutalisco mutalisco = (Mutalisco) constructor.construir(area);

        assertThrows(EntidadNoOperativaException.class, mutalisco::evolucionarAGuardian);

        pasarKTurnos(mutalisco, 12);

        assertThrows(EvolucionNoValidaException.class, mutalisco::evolucionarAGuardian);

        zerg.recolectarMineral(50);
        zerg.recolectarGas(100);

        assertDoesNotThrow(mutalisco::evolucionarAGuardian);
    }

    @Test
    public void test02UnDevoradorNoPuedeEvolucionarSiNoSeCuentanConLosRecursosYSiEstaConstruido() {
        Zerg zerg = new Zerg(0, 0);
        zerg.registrarEntidad(estructuraMockeadaParaTestear());
        zerg.recolectarMineral(100);
        zerg.recolectarGas(100);

        ConstructorUnidades constructor = new ConstructorMutalisco(zerg.getEstructuras(), zerg);
        Area area = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneMoho(), new RecursoNull());
        Mutalisco mutalisco = (Mutalisco) constructor.construir(area);

        assertThrows(EntidadNoOperativaException.class, mutalisco::evolucionarADevorador);

        pasarKTurnos(mutalisco, 12);

        assertThrows(EvolucionNoValidaException.class, mutalisco::evolucionarADevorador);

        zerg.recolectarMineral(150);
        zerg.recolectarGas(50);

        assertDoesNotThrow(mutalisco::evolucionarADevorador);
    }

    public Criadero estructuraMockeadaParaTestear() {
        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        //Ni del suministro
        Criadero estructuraMock = mock(Criadero.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);
        when(estructuraMock.afectarSuministro(any(int.class))).thenReturn(200);
        doNothing().when(estructuraMock).usarLarva();

        return estructuraMock;
    }

    public void pasarKTurnos(Entidad entidad, int k) {
        for (int i = 0; i < k; i++) {
            entidad.pasarTurno();
        }
    }
}
