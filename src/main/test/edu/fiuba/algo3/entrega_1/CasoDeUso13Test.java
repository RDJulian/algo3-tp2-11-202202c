package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.ConstructorCriadero;
import edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras.ConstructorEstructuras;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.ConstruiblePiso;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero.Criadero;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Unidad.Guardian;
import edu.fiuba.algo3.modelo.Excepciones.EntidadDestruidaException;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.Nada;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso13Test {
    @Test
    public void test01UnCriaderoSeConstruyeCreaMohoLuegoEsDestruidaPeroElMohoSigueEstando() {
        Posicion posicion = new Posicion(0, 0);
        posicion.cubrirConMoho();
        Raza raza = new Raza();

        raza.recolectarMineral(1000);
        raza.recolectarGas(1000);

        ConstructorEstructuras constructor = new ConstructorCriadero(new ArrayList<>(), raza);

        Criadero criadero = new Criadero(posicion, raza, new Nada());

        //Idealmente se ejecuta junto a la construccion.
        Piso nuevoMoho = criadero.generarMoho();
        Posicion posicionConstruccion = new Posicion(-5, -5);
        posicionConstruccion.actualizarEstado(nuevoMoho);

        criadero.daniar(600);

        assertThrows(EntidadDestruidaException.class, criadero::operable);

        assertDoesNotThrow(() -> constructor.construir(posicionConstruccion, new Nada()));

    }
}
