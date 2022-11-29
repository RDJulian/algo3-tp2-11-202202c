package edu.fiuba.algo3.modelo.ConstructorEntidades.ConstructorEstructuras;

import edu.fiuba.algo3.modelo.Construible.ConstruibleEstructura.RequiereAcceso;
import edu.fiuba.algo3.modelo.Construible.ConstruiblePiso.RangoPilon;
import edu.fiuba.algo3.modelo.Construible.ConstruibleRecurso.NoSobreRecurso;
import edu.fiuba.algo3.modelo.Entidad.Estructura.Estructura;
import edu.fiuba.algo3.modelo.Entidad.Estructura.PuertoEstelar;
import edu.fiuba.algo3.modelo.Piso.Piso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.Recurso;

public class ConstructorPuertoEstelar extends ConstructorEstructuras {
    public ConstructorPuertoEstelar() {
        this.construibleRecurso = new NoSobreRecurso();
        this.construiblePiso = new RangoPilon();
        this.construibleEstructura = new RequiereAcceso();
        this.costoMineral = 150;
        this.costoGas = 150;
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
        Estructura estructura = new PuertoEstelar(posicion, raza);
        raza.registarEntidad(estructura);
        return estructura;
    }
}