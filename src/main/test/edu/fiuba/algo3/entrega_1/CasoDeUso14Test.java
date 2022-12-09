package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.*;
import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.ConstruiblePiso;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.RangoPilon;
import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.ConstruibleRecurso;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero.Criadero;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Pilon;
import edu.fiuba.algo3.modelo.Entidad.Estructura.PuertoEstelar;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionNoValidaException;
import edu.fiuba.algo3.modelo.Excepciones.PosicionOcupadaException;
import edu.fiuba.algo3.modelo.Piso.Moho;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.Nada;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
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
        Raza raza = new Raza();
        raza.recolectarMineral(10000);
        raza.recolectarGas(10000);

        Posicion posicion = new Posicion(0, 0);
        new Moho(posicion);

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
    public void test02ElMohoNoPuedeExpandirseSobreUnaPosicionConEdificacion() {
        Posicion posicion = new Posicion(6, 6);
        Moho moho = new Moho(new Posicion(0, 0));

        posicion.energizar();
        Pilon pilon = new Pilon(posicion, new Raza(), new Nada());

        //La posicion sigue "energizada"
        moho.pasarTurno();
        moho.pasarTurno();
        posicion.actualizarEstado(moho);

        //La posicion deberia seguir energizada
        pilon.destruir();

        assertDoesNotThrow(() -> new Pilon(posicion, new Raza(), new Nada()));
    }

    @Test
    public void test03ElMohoSePuedeExpandirseSobreUnaPosicionNoOcupada() {
        Posicion posicion = new Posicion(6, 6);
        Moho moho = new Moho(new Posicion(0, 0));

        posicion.energizar();
        Pilon pilon = new Pilon(posicion, new Raza(), new Nada());

        //La posicion sigue "energizada"
        moho.pasarTurno();
        moho.pasarTurno();
        posicion.actualizarEstado(moho);

        //La posicion deberia seguir energizada
        pilon.destruir();

        assertThrows(ConstruccionNoValidaException.class, () -> new Criadero(posicion, new Raza(), new Nada()));

        //La posicion ahora tiene moho
        moho.pasarTurno();
        moho.pasarTurno();
        posicion.actualizarEstado(moho);

        assertDoesNotThrow(() -> new Criadero(posicion, new Raza(), new Nada()));
    }
}
