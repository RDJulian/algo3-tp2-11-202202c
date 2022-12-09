package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.*;
import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.ConstruiblePiso;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.RangoPilon;
import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.ConstruibleRecurso;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Pilon;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Piso.Moho;
import edu.fiuba.algo3.modelo.Posicion.Area.AreaTierra;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.Nada;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CasoDeUso5Test {

    @Test
    public void test01NoSePuedeConstruirUnaEstructuraProtossFueraDelRangoDeUnPilon() {
        //Se crea una posicion y se energiza manualmente.
        Posicion posicionEnergizada = new Posicion(0, 0);
        posicionEnergizada.energizar();
        
        Raza raza = new Raza();
        raza.recolectarMineral(10000);
        raza.recolectarGas(10000);

        //Se podria pasar por el constructor aca.
        Pilon pilon = new Pilon(posicionEnergizada, raza, new Nada());
        pasarKTurnos(pilon, 5);

        Posicion posicion = new Posicion(4, 4);
        posicion.actualizarEstado(pilon);

        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);

        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(estructuraMock);

        ArrayList<ConstructorEstructuras> constructores = new ArrayList<>();
        constructores.add(new ConstructorNexoMineral(estructuras, raza));
        constructores.add(new ConstructorPilon(estructuras, raza));
        constructores.add(new ConstructorAsimilador(estructuras, raza));
        constructores.add(new ConstructorAcceso(estructuras, raza));
        constructores.add(new ConstructorPuertoEstelar(estructuras, raza));

        //Mockeo un recurso para no depender de esa condicion.
        Recurso recursoMock = mock(Recurso.class);
        when(recursoMock.construible(any(ConstruibleRecurso.class), posicion)).thenReturn(true);

        for (ConstructorEstructuras constructor : constructores) {
            assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(posicion, recursoMock));
        }
    }

    @Test
    public void test02NoSePuedeConstruirUnaEstructuraZergFueraDelRangoDelMoho() {
        //Se crea moho.
        Moho moho = new Moho(new Posicion(0, 0));
        Posicion posicion = new Posicion(6, 6);
        posicion.actualizarEstado(moho);

        Raza raza = new Raza();
        raza.recolectarMineral(10000);
        raza.recolectarGas(10000);

        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);

        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(estructuraMock);

        ArrayList<ConstructorEstructuras> constructores = new ArrayList<>();
        constructores.add(new ConstructorCriadero(estructuras, raza));
        constructores.add(new ConstructorReservaDeReproduccion(estructuras, raza));
        constructores.add(new ConstructorExtractor(estructuras, raza));
        constructores.add(new ConstructorGuarida(estructuras, raza));
        constructores.add(new ConstructorEspiral(estructuras, raza));

        //Mockeo un recurso para no depender de esa condicion.
        Recurso recursoMock = mock(Recurso.class);
        when(recursoMock.construible(any(ConstruibleRecurso.class), posicion)).thenReturn(true);

        for (ConstructorEstructuras constructor : constructores) {
            assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(posicion, recursoMock));
        }
    }

    @Test
    public void test03SePuedeConstruirUnaEstructuraProtossEnElRangoDeUnPilon() {
        //Se crea una posicion y se energiza manualmente.
        Posicion posicionEnergizada = new Posicion(0, 0);
        posicionEnergizada.energizar();

        Raza raza = new Raza();
        raza.recolectarMineral(10000);
        raza.recolectarGas(10000);

        //Se podria pasar por el constructor aca.
        Pilon pilon = new Pilon(posicionEnergizada, raza, new Nada());
        pasarKTurnos(pilon, 5);

        Posicion posicion = new Posicion(3, 3);
        posicion.actualizarEstado(pilon);

        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);

        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(estructuraMock);

        ArrayList<ConstructorEstructuras> constructores = new ArrayList<>();
        constructores.add(new ConstructorNexoMineral(estructuras, raza));
        constructores.add(new ConstructorPilon(estructuras, raza));
        constructores.add(new ConstructorAsimilador(estructuras, raza));
        constructores.add(new ConstructorAcceso(estructuras, raza));
        constructores.add(new ConstructorPuertoEstelar(estructuras, raza));

        //Mockeo un recurso para no depender de esa condicion.
        Recurso recursoMock = mock(Recurso.class);
        when(recursoMock.construible(any(ConstruibleRecurso.class), posicion)).thenReturn(true);

        for (ConstructorEstructuras constructor : constructores) {
            assertDoesNotThrow(() -> constructor.construir(posicion, recursoMock));
        }
    }

    @Test
    public void test04SePuedeConstruirUnaEstructuraZergEnElRangoDelMoho() {
        //Se crea moho.
        Moho moho = new Moho(new Posicion(0, 0));
        Posicion posicion = new Posicion(5, 5);
        posicion.actualizarEstado(moho);

        Raza raza = new Raza();
        raza.recolectarMineral(10000);
        raza.recolectarGas(10000);

        //Se mockea una estructura para no depender de la condicion de estructuras correlativas.
        Estructura estructuraMock = mock(Estructura.class);
        when(estructuraMock.construible(any(ConstruibleEstructura.class))).thenReturn(true);

        ArrayList<Estructura> estructuras = new ArrayList<>();
        estructuras.add(estructuraMock);

        ArrayList<ConstructorEstructuras> constructores = new ArrayList<>();
        constructores.add(new ConstructorCriadero(estructuras, raza));
        constructores.add(new ConstructorReservaDeReproduccion(estructuras, raza));
        constructores.add(new ConstructorExtractor(estructuras, raza));
        constructores.add(new ConstructorGuarida(estructuras, raza));
        constructores.add(new ConstructorEspiral(estructuras, raza));

        //Mockeo un recurso para no depender de esa condicion.
        Recurso recursoMock = mock(Recurso.class);
        when(recursoMock.construible(any(ConstruibleRecurso.class), posicion)).thenReturn(true);

        for (ConstructorEstructuras constructor : constructores) {
            assertDoesNotThrow(() -> constructor.construir(posicion, recursoMock));
        }
    }

    public void pasarKTurnos(Estructura estructura, int k) {
        for (int i = 0; i < k; i++) {
            estructura.pasarTurno();
        }
    }
}
