package edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.NoRequiereEstructura;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.RangoPilon;
import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.SobreMineral;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.NexoMineral;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.Recurso;

public class ConstructorNexoMineral extends ConstructorEstructuras {
    public ConstructorNexoMineral() {
        this.construibleRecurso = new SobreMineral();
        this.construiblePiso = new RangoPilon();
        this.construibleEstructura = new NoRequiereEstructura();
        this.costoMineral = 50;
        this.costoGas = 0;
    }

    @Override
    public Estructura construir(Posicion posicion, Recurso recurso, Piso piso, Raza raza, Estructura estructuraCorrelativa) {
        posicion.ocupable();
        recurso.construible(construibleRecurso, posicion);
        piso.construible(construiblePiso, posicion);
        raza.construible(costoMineral, costoGas);
        construibleEstructura.visitar(estructuraCorrelativa);

        raza.gastarRecursos(costoMineral, costoGas);
        return new NexoMineral(posicion, recurso, raza);
    }
}