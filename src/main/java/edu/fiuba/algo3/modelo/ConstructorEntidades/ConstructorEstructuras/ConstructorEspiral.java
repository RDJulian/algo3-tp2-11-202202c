package edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.RequiereGuarida;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.RangoMoho;
import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.NoSobreRecurso;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Criadero;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Espiral;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.Recurso;

public class ConstructorEspiral extends ConstructorEstructuras {
    public ConstructorEspiral() {
        this.construibleRecurso = new NoSobreRecurso();
        this.construiblePiso = new RangoMoho();
        this.construibleEstructura = new RequiereGuarida();
        this.costoMineral = 150;
        this.costoGas = 100;
        this.costoSuministro = 0;
    }

    @Override
    public Estructura construir(Posicion posicion, Recurso recurso, Piso piso, Raza raza, Estructura estructuraCorrelativa) {
        posicion.ocupable();
        recurso.construible(construibleRecurso, posicion);
        piso.construible(construiblePiso, posicion);
        raza.construible(costoMineral, costoGas, costoSuministro);
        construibleEstructura.visitar(estructuraCorrelativa);

        raza.gastarRecursos(costoMineral, costoGas);
        Estructura construccion = new Espiral(posicion);
        raza.registarEstructura(construccion);
        return construccion;
    }
}