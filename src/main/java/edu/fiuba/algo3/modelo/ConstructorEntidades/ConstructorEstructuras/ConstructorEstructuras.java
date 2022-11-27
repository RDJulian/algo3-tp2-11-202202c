package edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.ConstruibleEstructura;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.ConstruiblePiso;
import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.ConstruibleRecurso;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.Recurso;

public abstract class ConstructorEstructuras {
    // Patron Factory Method. Cada constructor es distinto porque chequea distintas condiciones
    // Posicion para ver si la posicion esta ocupada. Tambien para ver si estaria dentro de los rangos
    // Recurso para ver si la estructura se puede construir en ese recurso
    // Piso para ver si esta en el rango correcto, y si es el piso del equipo
    // Reservas para ver si tiene los recursos necesarios para pagar la construccion
    // Estructura para ver si cumple la correlatividad
    // Se deberia codear constructores para inyectar dependecia y testear con mocks.
    // Considerar si se deberia mover raza.gastarRecursos().
    protected ConstruibleRecurso construibleRecurso;
    protected ConstruiblePiso construiblePiso;
    protected ConstruibleEstructura construibleEstructura;
    protected int costoMineral;
    protected int costoGas;
    protected int costoSuministro;

    public abstract Estructura construir(Posicion posicion, Recurso recurso, Piso piso, Raza raza, Estructura estructuraCorrelativa);
}
