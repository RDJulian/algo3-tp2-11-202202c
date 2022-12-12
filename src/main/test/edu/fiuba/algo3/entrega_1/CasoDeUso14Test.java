package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Area.Coordenada;
import edu.fiuba.algo3.modelo.Area.EstadoOcupacion.Desocupada;
import edu.fiuba.algo3.modelo.Area.EstadoPiso.TieneMoho;
import edu.fiuba.algo3.modelo.Area.TipoArea.AreaTierra;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.*;
import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.ConstruibleRecurso;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero.Criadero;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Pilon;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Piso.Moho;
import edu.fiuba.algo3.modelo.Area.Area;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Area.Recurso.Recurso;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CasoDeUso14Test {
    //Ver casos de colision entre pisos.
    @Test
    public void test01UnaEstructuraProtossNoSePuedeConstruirSobreMoho() {
        //Mockeo la raza para no depender de recursos.
        Raza raza = mock(Raza.class);

        //Mockeo un recurso para no depender de esa condicion.
        Recurso recursoMock = mock(Recurso.class);
        when(recursoMock.construible(any(ConstruibleRecurso.class))).thenReturn(true);
        Area area = new Area(new Coordenada(0, 0), new AreaTierra(), new Desocupada(), new TieneMoho(), recursoMock);

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

        for (ConstructorEstructuras constructor : constructores) {
            assertThrows(ConstruccionNoValidaException.class, () -> constructor.construir(area));
        }
    }

    @Test
    public void test02ElMohoNoPuedeExpandirseSobreUnaPosicionConEdificacion() {
        //Mockeo la raza para no depender de recursos.
        Raza raza = mock(Raza.class);

        Area area = new Area(6, 6);
        Moho moho = new Moho(new Area(0, 0));

        area.energizar();
        Pilon pilon = new Pilon(area, raza);

        //La posicion sigue "energizada"
        moho.pasarTurno();
        moho.pasarTurno();
        area.actualizarEstado(moho);

        // La posicion deberia seguir energizada
        pilon.destruir();

        //No se puede construir el criadero porque el moho no se expandio.
        assertThrows(ConstruccionNoValidaException.class, () -> new Criadero(area, raza));
    }

    @Test
    public void test03ElMohoSePuedeExpandirseSobreUnaPosicionNoOcupada() {
        //Mockeo la raza para no depender de recursos.
        Raza raza = mock(Raza.class);

        Area area = new Area(6, 6);
        Moho moho = new Moho(new Area(0, 0));

        area.energizar();
        Pilon pilon = new Pilon(area, raza);

        //La posicion sigue "energizada"
        moho.pasarTurno();
        moho.pasarTurno();
        area.actualizarEstado(moho);

        //La posicion deberia seguir energizada
        pilon.destruir();

        //No se puede construir el criadero porque el moho no se expandio.
        assertThrows(ConstruccionNoValidaException.class, () -> new Criadero(area, raza));

        //La posicion ahora tiene moho
        moho.pasarTurno();
        moho.pasarTurno();
        area.actualizarEstado(moho);

        assertDoesNotThrow(() -> new Criadero(area, raza));
    }
}
