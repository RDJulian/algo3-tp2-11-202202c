package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.CeldaDeTerreno.Volcan;
import edu.fiuba.algo3.modelo.Estructura.Acceso;
import edu.fiuba.algo3.modelo.Estructura.Asimilador;
import edu.fiuba.algo3.modelo.Estructura.Pilon;
import edu.fiuba.algo3.modelo.Excepciones.FueraDeRangoDelPilon;
import edu.fiuba.algo3.modelo.Excepciones.TerrenoIncompatible;
import edu.fiuba.algo3.modelo.Mundo.CreadorDeMundo;
import edu.fiuba.algo3.modelo.Mundo.Cuadricula;
import edu.fiuba.algo3.modelo.Mundo.Mundo;

import edu.fiuba.algo3.modelo.Reserva.ReservaGas;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso5Test {

    @Test
    public void test01UnEdificioProtossNoSePuedeContruirFueraDelRangoDelPilonLanzaError(){
        CreadorDeMundo creador = new CreadorDeMundo();
        Mundo mundo = creador.crearMundoLlano(10,10);
        Cuadricula rango = mundo.getCuadricula(4,4,3);
        Pilon pilon = new Pilon(rango);

        assertThrows(FueraDeRangoDelPilon.class, () -> {
            new Acceso(mundo.getCelda(4,8));
        });

    }

    @Test
    public void test02UnEdificioProtossSePuedeContruirDentroDelRangoDelPilon(){
        CreadorDeMundo creador = new CreadorDeMundo();
        Mundo mundo = creador.crearMundoLlano(10,10);
        Cuadricula rango = mundo.getCuadricula(4,4,3);
        Pilon pilon = new Pilon(rango);

        assertDoesNotThrow(() -> {
            new Acceso(mundo.getCelda(4,7));
        });

    }
}
